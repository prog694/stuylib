/* Copyright (c) 2021 StuyPulse Robotics. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.stuypulse.stuylib.input;

import com.stuypulse.stuylib.math.Vector2D;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * An class for using gamepads with different interfaces. You can implement this class in another
 * file, and then use it with a standard interface.
 *
 * <p>Any unimplemented buttons will never be triggered, so if a certain controller is missing one,
 * dont worry about it.
 *
 * <p>The button type that is used in OI.java is automatically generated by this class, as long as
 * you implement the {@code getRaw...()} function, the {@code getRaw...()} function will work.
 *
 * <p>This class does not come with a constructor because by itself, the class does not do anything.
 * You need to extend this class in order to use it.
 *
 * @author Sam (sam.belliveau@gmail.com)
 */
public class Gamepad implements Sendable {

    /*******************/
    /*** CONSTRUCTOR ***/
    /*******************/

    public Gamepad() {}

    /*******************************/
    /*** IMPLEMENTABLE FUNCTIONS ***/
    /*******************************/

    /** @return The name of the gamepad being used */
    public String getGamepadName() {
        return this.getClass().getSimpleName();
    }

    // Left Stick //
    /** @return The X position of the left analog stick */
    public double getLeftX() {
        return 0.0;
    }

    /** @return The Y position of the left analog stick */
    public double getLeftY() {
        return 0.0;
    }

    // Right Stick //
    /** @return The X position of the right analog stick */
    public double getRightX() {
        return 0.0;
    }

    /** @return The Y position of the right analog stick */
    public double getRightY() {
        return 0.0;
    }

    // D-Pad //
    /** @return If the up d-pad button is pressed */
    public boolean getRawDPadUp() {
        return false;
    }

    /** @return If the down d-pad button is pressed */
    public boolean getRawDPadDown() {
        return false;
    }

    /** @return If the left d-pad button is pressed */
    public boolean getRawDPadLeft() {
        return false;
    }

    /** @return If the right d-pad button is pressed */
    public boolean getRawDPadRight() {
        return false;
    }

    // Bumpers //
    /** @return If the left bumper is pressed */
    public boolean getRawLeftBumper() {
        return false;
    }

    /** @return If the right bumper is pressed */
    public boolean getRawRightBumper() {
        return false;
    }

    // Triggers //
    /** @return The amount that the left trigger is pressed */
    public double getLeftTrigger() {
        return 0.0;
    }

    /** @return The amount that the right trigger is pressed */
    public double getRightTrigger() {
        return 0.0;
    }

    // Face Buttons //
    /** @return If the face button on the top is pressed */
    public boolean getRawTopButton() {
        return false;
    }

    /** @return If the face button on the bottom is pressed */
    public boolean getRawBottomButton() {
        return false;
    }

    /** @return If the face button on the left is pressed */
    public boolean getRawLeftButton() {
        return false;
    }

    /** @return If the face button on the right is pressed */
    public boolean getRawRightButton() {
        return false;
    }

    // Start / Select / Option //
    /** @return If the select button is pressed */
    public boolean getRawSelectButton() {
        return false;
    }

    /** @return If the start button is pressed */
    public boolean getRawStartButton() {
        return false;
    }

    // Analog Stick Buttons //
    /** @return If the left analog stick is pressed down */
    public boolean getRawLeftStickButton() {
        return false;
    }

    /** @return If the right analog stick is pressed down */
    public boolean getRawRightStickButton() {
        return false;
    }

    // Rumble //
    /** @param intensity amount to make the gamepad rumble */
    public void setRumble(double intensity) {
        return;
    }

    /*************************************************/
    /*** HELPER FUNCTIONS BASED ON IMPLEMENTATIONS ***/
    /*************************************************/

    // Left Stick //
    /** @return The position of the left analog stick in a {@link Vector2D} */
    public final Vector2D getLeftStick() {
        return new Vector2D(this.getLeftX(), this.getLeftY());
    }

    // Right Stick //
    /** @return The position of the right analog stick in a {@link Vector2D} */
    public final Vector2D getRightStick() {
        return new Vector2D(this.getRightX(), this.getRightY());
    }

    // D-Pad //
    /** @return The x position of the d-pad as if it were a stick */
    public final double getDPadX() {
        return (getRawDPadRight() ? 1.0 : 0.0) - (getRawDPadLeft() ? 1.0 : 0.0);
    }

    /** @return The y position of the d-pad as if it were a stick */
    public final double getDPadY() {
        return (getRawDPadUp() ? 1.0 : 0.0) - (getRawDPadDown() ? 1.0 : 0.0);
    }

    /** @return The position of the d-pad as if it were a stick in a Vector2D */
    public final Vector2D getDPad() {
        return new Vector2D(this.getDPadX(), this.getDPadY());
    }

    // Triggers //
    public static final double TRIGGER_PRESSED_THRESHOLD = 1.0 / 4.0;

    /** @return If the left trigger is pressed down more than {@link #TRIGGER_PRESSED_THRESHOLD} */
    public final boolean getLeftTriggerPressed() {
        return getLeftTrigger() > TRIGGER_PRESSED_THRESHOLD;
    }

    /** @return If the left trigger is pressed down more than {@link #TRIGGER_PRESSED_THRESHOLD} */
    public final boolean getRightTriggerPressed() {
        return getRightTrigger() > TRIGGER_PRESSED_THRESHOLD;
    }

    /**************************************************/
    /*** BUTTONS BASED OFF OF IMPLEMENTED FUNCTIONS ***/
    /**************************************************/

    // D-Pad //
    /** @return Button that activates with {@link #getRawDPadUp()} */
    public final Button getDPadUp() {
        return new Button(this::getRawDPadUp);
    }

    /** @return Button that activates with {@link #getRawDPadDown()} */
    public final Button getDPadDown() {
        return new Button(this::getRawDPadDown);
    }

    /** @return Button that activates with {@link #getRawDPadLeft()} */
    public final Button getDPadLeft() {
        return new Button(this::getRawDPadLeft);
    }

    /** @return Button that activates with {@link #getRawDPadRight()} */
    public final Button getDPadRight() {
        return new Button(this::getRawDPadRight);
    }

    // Bumpers //
    /** @return Button that activates with {@link #getRawLeftBumper()} */
    public final Button getLeftBumper() {
        return new Button(this::getRawLeftBumper);
    }

    /** @return Button that activates with {@link #getRawRightBumper()} */
    public final Button getRightBumper() {
        return new Button(this::getRawRightBumper);
    }

    // Triggers //
    /** @return Button that activates with {@link #getLeftTriggerPressed()} */
    public final Button getLeftTriggerButton() {
        return new Button(this::getLeftTriggerPressed);
    }

    /** @return Button that activates with {@link #getRightTriggerPressed()} */
    public final Button getRightTriggerButton() {
        return new Button(this::getRightTriggerPressed);
    }

    // Face Buttons //
    /** @return Button that activates with {@link #getRawTopButton()} */
    public final Button getTopButton() {
        return new Button(this::getRawTopButton);
    }

    /** @return Button that activates with {@link #getRawBottomButton()} */
    public final Button getBottomButton() {
        return new Button(this::getRawBottomButton);
    }

    /** @return Button that activates with {@link #getRawLeftButton()} */
    public final Button getLeftButton() {
        return new Button(this::getRawLeftButton);
    }

    /** @return Button that activates with {@link #getRawRightButton()} */
    public final Button getRightButton() {
        return new Button(this::getRawRightButton);
    }

    // Select / Start / Option //
    /** @return Button that activates with {@link #getRawSelectButton()} */
    public final Button getSelectButton() {
        return new Button(this::getRawSelectButton);
    }

    /** @return Button that activates with {@link #getRawStartButton()} */
    public final Button getStartButton() {
        return new Button(this::getRawStartButton);
    }

    // Analog Stick Buttons //
    /** @return Button that activates with {@link #getRawLeftStickButton()} */
    public final Button getLeftAnalogButton() {
        return new Button(this::getRawLeftStickButton);
    }

    /** @return Button that activates with {@link #getRawRightStickButton()} */
    public final Button getRightAnalogButton() {
        return new Button(this::getRawRightStickButton);
    }

    /*******************************/
    /*** SENDABLE INITIALIZATION ***/
    /*******************************/

    @Override
    public final void initSendable(SendableBuilder builder) {
        // Name
        builder.addStringProperty("Gamepad Name", this::getGamepadName, x -> {});

        // Left Stick
        builder.addDoubleProperty("Left Stick X", this::getLeftX, x -> {});
        builder.addDoubleProperty("Left Stick Y", this::getLeftY, x -> {});

        // Right Stick
        builder.addDoubleProperty("Right Stick X", this::getRightX, x -> {});
        builder.addDoubleProperty("Right Stick Y", this::getRightY, x -> {});

        // D-Pad
        builder.addBooleanProperty("D-Pad Up", this::getRawDPadUp, x -> {});
        builder.addBooleanProperty("D-Pad Down", this::getRawDPadDown, x -> {});
        builder.addBooleanProperty("D-Pad Left", this::getRawDPadLeft, x -> {});
        builder.addBooleanProperty("D-Pad Right", this::getRawDPadRight, x -> {});

        // Bumpers
        builder.addBooleanProperty("Bumper Left", this::getRawLeftBumper, x -> {});
        builder.addBooleanProperty("Bumper Right", this::getRawRightBumper, x -> {});

        // Triggers
        builder.addDoubleProperty("Trigger Left", this::getLeftTrigger, x -> {});
        builder.addDoubleProperty("Trigger Right", this::getRightTrigger, x -> {});

        // Face Buttons
        builder.addBooleanProperty("Face Button Top", this::getRawTopButton, x -> {});
        builder.addBooleanProperty("Face Button Bottom", this::getRawBottomButton, x -> {});
        builder.addBooleanProperty("Face Button Left", this::getRawLeftButton, x -> {});
        builder.addBooleanProperty("Face Button Right", this::getRawRightButton, x -> {});

        // Start / Select / Option
        builder.addBooleanProperty("Button Select", this::getRawSelectButton, x -> {});
        builder.addBooleanProperty("Button Start", this::getRawStartButton, x -> {});

        // Analog Stick Buttons
        builder.addBooleanProperty("Left Stick Button", this::getRawLeftStickButton, x -> {});
        builder.addBooleanProperty("Right Stick Button", this::getRawRightStickButton, x -> {});
    }
}
