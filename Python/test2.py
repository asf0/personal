#!/usr/bin/env python3
import time
from gi.repository import GLib, Gio

# Configuration
IDLE_THRESHOLD = 30000  # 30 seconds in milliseconds
BACKLIGHT_PATH = "/sys/class/leds/asus::kbd_backlight/brightness"
BRIGHTNESS_ON = "3"     # Adjust as needed
BRIGHTNESS_OFF = "0"

def set_backlight(brightness: str):
    try:
        with open(BACKLIGHT_PATH, "w") as f:
            f.write(brightness)
    except Exception as e:
        print("Error setting backlight:", e)

def get_idle_time() -> int:
    """
    Uses GNOME's idle monitor DBus interface to fetch the current idle time (in milliseconds).
    """
    try:
        bus = Gio.bus_get_sync(Gio.BusType.SESSION, None)
        proxy = Gio.DBusProxy.new_sync(
            bus,
            Gio.DBusProxyFlags.NONE,
            None,
            "org.gnome.Mutter.IdleMonitor",
            "/org/gnome/Mutter/IdleMonitor/Core",
            "org.gnome.Mutter.IdleMonitor",
            None
        )
        # The GetIdleTime method returns a variant with the idle time in ms.
        idle_variant = proxy.call_sync("GetIdleTime", None, Gio.DBusCallFlags.NONE, -1, None)
        idle_time = idle_variant.unpack()
        return idle_time
    except Exception as e:
        print("Error getting idle time:", e)
        return 0

def check_idle():
    idle_time = get_idle_time()
    # Debug: print current idle time
    # print("Idle time (ms):", idle_time)
    
    if idle_time >= IDLE_THRESHOLD:
        # If idle for 30 seconds or more, turn the backlight off.
        set_backlight(BRIGHTNESS_OFF)
    else:
        # If there's activity, restore the backlight quickly.
        set_backlight(BRIGHTNESS_ON)
    return True  # Continue calling this function

if __name__ == '__main__':
    # Ensure backlight is on initially
    set_backlight(BRIGHTNESS_ON)
    # Check idle state every second
    GLib.timeout_add(1000, check_idle)
    loop = GLib.MainLoop()
    loop.run()
