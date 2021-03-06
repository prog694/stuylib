/* Copyright (c) 2021 StuyPulse Robotics. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.stuypulse.stuylib.network;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.function.Supplier;

/**
 * SmartString works as a wrapper for values on {@link SmartDashboard}. The idea for this class was
 * to make getting values on {@link SmartDashboard} easier by making them variables that you know
 * were initialized.
 *
 * @author Sam (sam.belliveau@gmail.com)
 */
public class SmartString implements Supplier<String> {

    /** The ID / Name for the value on {@link SmartDashboard}. */
    private final NetworkTableEntry mEntry;

    /** The default value that the {@link SmartDashboard} value was set too. */
    private final String mDefaultValue;

    /**
     * Creates a {@link SmartString} with a network table entry instead of a value for {@link
     * SmartDashboard}. This allows you to put items on things like {@link
     * edu.wpi.first.wpilibj.shuffleboard.Shuffleboard}, without having to use a raw {@link
     * NetworkTableEntry}.
     *
     * @param entry the {@link NetworkTableEntry} the {@link SmartString} should be set to.
     * @param value the default value of the {@link SmartString}
     */
    public SmartString(NetworkTableEntry entry, String value) {
        mEntry = entry;
        mDefaultValue = value;
        mEntry.forceSetString(value);
    }

    /**
     * Creates a SmartString with the element name and a default value. The value on {@link
     * SmartDashboard} will be reset to the default value on initialization.
     *
     * @param id the name of the String on {@link SmartDashboard}
     * @param value the default / initialization value for the value
     */
    public SmartString(String id, String value) {
        this(SmartDashboard.getEntry(id), value);
    }

    /** @return the value of the String from SmartDashboard */
    public String get() {
        return mEntry.getString(mDefaultValue);
    }

    /** @return the default value of the String */
    public String getDefault() {
        return mDefaultValue;
    }

    /** @param value what the value on {@link SmartDashboard} will be set to */
    public void set(String value) {
        mEntry.forceSetString(value);
    }

    /** Resets the value on {@link SmartDashboard} to the default value */
    public void reset() {
        set(getDefault());
    }
}
