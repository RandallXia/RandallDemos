/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2023 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.105Release
// Tag = production/release/21.105.00-0-gdc65d24
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;


public enum AutoSyncFrequency  {
    NEVER((short)0),
    OCCASIONALLY((short)1),
    FREQUENT((short)2),
    ONCE_A_DAY((short)3),
    REMOTE((short)4),
    INVALID((short)255);

    protected short value;

    private AutoSyncFrequency(short value) {
        this.value = value;
    }

    public static AutoSyncFrequency getByValue(final Short value) {
        for (final AutoSyncFrequency type : AutoSyncFrequency.values()) {
            if (value == type.value)
                return type;
        }

        return AutoSyncFrequency.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( AutoSyncFrequency value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}