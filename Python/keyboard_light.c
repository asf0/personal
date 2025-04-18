#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <linux/input.h>
#include <string.h>
#include <sys/select.h>
#include <time.h>
#include <dirent.h>
#include <errno.h>

#define IDLE_TIMEOUT 20 // seconds
#define BACKLIGHT_PATH "/sys/class/leds/asus::kbd_backlight/brightness"
#define MAX_BRIGHTNESS "2"
#define OFF_BRIGHTNESS "0"

// Match devices to monitor
const char *monitored_keywords[] = {
    "keyboard", "kbd",
    "touchpad", "trackpad",
    "mouse", "logitech", "usb", "pointer",
    NULL};

int is_monitored_device(const char *name)
{
    for (int i = 0; monitored_keywords[i] != NULL; i++)
    {
        if (strcasestr(name, monitored_keywords[i]))
            return 1;
    }
    return 0;
}

void set_backlight(const char *value)
{
    FILE *f = fopen(BACKLIGHT_PATH, "w");
    if (f)
    {
        fwrite(value, 1, strlen(value), f);
        fclose(f);
    }
    else
    {
        perror("Failed to set brightness");
    }
}

int main()
{
    DIR *d;
    struct dirent *dir;
    char path[128];
    struct input_event ev;

    int fds[32];
    int fd_count = 0;
    int max_fd = -1;
    fd_set read_fds;

    time_t last_activity = time(NULL);
    int backlight_on = 1;

    // Optional startup delay to let devices initialize
    sleep(3);

    // Open /dev/input and filter devices
    d = opendir("/dev/input");
    if (!d)
    {
        perror("opendir /dev/input");
        return 1;
    }

    while ((dir = readdir(d)) != NULL)
    {
        if (strncmp(dir->d_name, "event", 5) == 0)
        {
            snprintf(path, sizeof(path), "/dev/input/%s", dir->d_name);
            int fd = open(path, O_RDONLY | O_NONBLOCK);
            if (fd < 0)
                continue;

            char name[256] = "unknown";
            ioctl(fd, EVIOCGNAME(sizeof(name)), name);

            if (is_monitored_device(name))
            {
                fds[fd_count++] = fd;
                if (fd > max_fd)
                    max_fd = fd;
                printf("Monitoring: %s (%s)\n", name, path);
            }
            else
            {
                close(fd);
            }
        }
    }
    closedir(d);

    if (fd_count == 0)
    {
        fprintf(stderr, "No monitored input devices found.\n");
        return 1;
    }

    // Turn on backlight at startup
    set_backlight(MAX_BRIGHTNESS);

    while (1)
    {
        FD_ZERO(&read_fds);
        for (int i = 0; i < fd_count; i++)
        {
            FD_SET(fds[i], &read_fds);
        }

        struct timeval timeout = {1, 0}; // 1-second poll
        int activity = select(max_fd + 1, &read_fds, NULL, NULL, &timeout);
        time_t now = time(NULL);

        if (activity > 0)
        {
            for (int i = 0; i < fd_count; i++)
            {
                if (FD_ISSET(fds[i], &read_fds))
                {
                    ssize_t n;
                    while ((n = read(fds[i], &ev, sizeof(ev))) > 0)
                    {
                        if (ev.type == EV_KEY || ev.type == EV_REL || ev.type == EV_ABS)
                        {
                            last_activity = now;
                            if (!backlight_on)
                            {
                                set_backlight(MAX_BRIGHTNESS);
                                backlight_on = 1;
                            }
                        }
                    }
                    if (n < 0 && errno != EAGAIN && errno != EWOULDBLOCK)
                    {
                        perror("read");
                    }
                }
            }
        }

        // Timeout: Turn off if idle
        if ((now - last_activity > IDLE_TIMEOUT) && backlight_on)
        {
            set_backlight(OFF_BRIGHTNESS);
            backlight_on = 0;
        }
    }

    for (int i = 0; i < fd_count; i++)
    {
        close(fds[i]);
    }

    return 0;
}
