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


package com.garmin.fit.csv;

import com.garmin.fit.DeveloperField;
import com.garmin.fit.Field;
import com.garmin.fit.Fit;
import com.garmin.fit.Mesg;
import com.garmin.fit.MesgListener;

import java.io.ByteArrayOutputStream;

public class MesgDataCSVWriter extends MesgCSVWriterBase implements MesgListener {

    public MesgDataCSVWriter(ByteArrayOutputStream byteArrayOutputStream) {
        super(byteArrayOutputStream);
    }

    public void onMesg(Mesg mesg) {
        if (mesg.getName().equals("unknown") && hideUnknownData) {
            return;
        }

        if (removeExpandedFields) {
            mesg.removeExpandedFields();
        }

        for (Field field : mesg.getFields()) {
            if (hideUnknownData && field.getName().equals("unknown")) {
                continue;
            }

            int subFieldIndex = mesg.getActiveSubFieldIndex(field.getNum());

            String value = null;

            if (null == value) {
                value = getValueString(field, subFieldIndex);
            }

            String headerString = mesg.getName() + "." + field.getName(subFieldIndex);


            String units = formatUnits(field.getUnits(subFieldIndex), field.getProfileType().name());
            if (!units.isEmpty()) {
                headerString += "[" + units + "]";
            }

            csv.set(headerString, value);
        }

        for (DeveloperField field : mesg.getDeveloperFields()) {
            if (!field.isDefined() && hideUnknownData) {
                continue;
            }

            String value = getValueString(field, Fit.SUBFIELD_INDEX_MAIN_FIELD);
            String headerString = mesg.getName() + ".developer." + field.getDeveloperDataIndex() + "." + field.getName();

            String units = formatUnits(field.getUnits());
            if (units != null && !units.isEmpty()) {
                headerString += "[" + units + "]";
            }

            csv.set(headerString, value);
        }

        csv.writeln();
    }

    public void setMaxNumFields(int numFields) {
        csv.setMaxNumberValues(numFields);
    }
}