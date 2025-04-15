#!/usr/bin/env python3
import time
from gi.repository import GLib, Gio

# Define your idle threshold in milliseconds (e.g., 10 seconds)
IDLE_THRESHOLD = 10000


# Function to set keyboard backlight brightness
def set_backlight(brightness: int):
    try:
        with open("/sys/class/leds/asus::kbd_backlight/brightness", "w") as f:
            f.write(str(brightness))
    except Exception as e:
        print("Error setting backlight:", e)


# Callback for idle events
def on_idle():
    print("System idle detected: turning off keyboard backlight")
    set_backlight(0)
    return True  # Returning True reschedules the idle callback


# Callback for active events (this would be triggered by your DE’s idle monitor reset)
def on_active():
    print("Activity detected: restoring keyboard backlight")
    set_backlight(1)
    return True


# Example: setting up GLib timeout to simulate checking idle status
def check_idle():
    # NOTE: You must replace this with actual idle detection logic.
    # This is a placeholder for where you would query your DE's idle monitor.
    # For demonstration, we assume idle after every 10 seconds.
    current_idle = int(time.time() * 1000) % 15000  # Dummy idle value cycling
    if current_idle > IDLE_THRESHOLD:
        on_idle()
    else:
        on_active()
    return True  # Continue the timeout


# Main loop using GLib
if __name__ == "__main__":
    loop = GLib.MainLoop()
    GLib.timeout_add(100, check_idle)  # Check every 1 second
    loop.run()
