#!/usr/bin/env python3

import evdev
import time
import os
import select
from evdev import InputDevice, list_devices

MAX_BRIGHTNESS = 2
IDLE_TIMEOUT = 10  # seconds
BACKLIGHT_PATH = "/sys/class/leds/asus::kbd_backlight/brightness"


def set_backlight(level):
    try:
        with open(BACKLIGHT_PATH, "w") as f:
            f.write(str(level))
    except Exception as e:
        print("Failed to set brightness:", e)


# Find input devices to monitor
devices = [InputDevice(path) for path in list_devices()]
monitored_devices = []

for device in devices:
    name = device.name.lower()
    if "keyboard" in name or "kbd" in name or "touchpad" in name or "trackpad" in name:
        print(f"Monitoring: {device.name} ({device.path})")
        device.grab = False  # make sure we don’t grab it
        monitored_devices.append(device)

if not monitored_devices:
    print("No input devices found.")
    exit(1)

# Create a mapping of fd to device
fd_to_device = {dev.fd: dev for dev in monitored_devices}

last_activity = time.time()
backlight_on = True
set_backlight(MAX_BRIGHTNESS)

while True:
    r, _, _ = select.select(fd_to_device.keys(), [], [], 1)
    if r:
        for fd in r:
            device = fd_to_device[fd]
            for event in device.read():
                if (
                    event.type == evdev.ecodes.EV_KEY
                    or event.type == evdev.ecodes.EV_REL
                ):
                    last_activity = time.time()
                    if not backlight_on:
                        set_backlight(MAX_BRIGHTNESS)
                        backlight_on = True
    else:
        if time.time() - last_activity > IDLE_TIMEOUT and backlight_on:
            set_backlight(0)
            backlight_on = False
