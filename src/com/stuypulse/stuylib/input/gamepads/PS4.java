// Copyright (c) 2021 StuyPulse Inc. All rights reserved.
// This work is licensed under the terms of the MIT license
// found in the root directory of this project.

package com.stuypulse.stuylib.input.gamepads;

import com.stuypulse.stuylib.input.WPIGamepad;

/**
 * Implementation of the PS4 for the Gamepad Class
 *
 * @author Sam (sam.belliveau@gmail.com)
 */
public class PS4 extends WPIGamepad {

    // Constructor //
    public PS4(int port) {
        super(port);
    }

    // Left Stick //
    public double getLeftX() {
        return getRawAxis(0);
    }

    public double getLeftY() {
        return -getRawAxis(1);
    }

    // Right Stick //
    public double getRightX() {
        return getRawAxis(2);
    }

    public double getRightY() {
        return -getRawAxis(5);
    }

    // D-Pad //
    public boolean getRawDPadUp() {
        return getJoystick().getPOV() == 0;
    }

    public boolean getRawDPadDown() {
        return getJoystick().getPOV() == 180;
    }

    public boolean getRawDPadLeft() {
        return getJoystick().getPOV() == 270;
    }

    public boolean getRawDPadRight() {
        return getJoystick().getPOV() == 90;
    }

    // Bumpers //
    public boolean getRawLeftBumper() {
        return getRawButton(5);
    }

    public boolean getRawRightBumper() {
        return getRawButton(6);
    }

    // Triggers //
    public double getLeftTrigger() {
        return (getRawAxis(3) + 1.0) / 2.0;
    }

    public double getRightTrigger() {
        return (getRawAxis(4) + 1.0) / 2.0;
    }

    // Face Buttons //
    public boolean getRawLeftButton() {
        return getRawButton(1);
    }

    public boolean getRawBottomButton() {
        return getRawButton(2);
    }

    public boolean getRawRightButton() {
        return getRawButton(3);
    }

    public boolean getRawTopButton() {
        return getRawButton(4);
    }

    // Start / Select / Option //
    public boolean getRawSelectButton() {
        return getRawButton(9);
    }

    public boolean getRawStartButton() {
        return getRawButton(10);
    }

    public boolean getRawOptionButton() {
        return getRawButton(10);
    }

    // Analog Stick Buttons //
    public boolean getRawLeftStickButton() {
        return getRawButton(11);
    }

    public boolean getRawRightStickButton() {
        return getRawButton(12);
    }
}
