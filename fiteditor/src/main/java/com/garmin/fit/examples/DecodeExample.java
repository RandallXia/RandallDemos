/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2023 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit.examples;

import android.os.Environment;

import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.garmin.fit.ActivityMesg;
import com.garmin.fit.ActivityMesgListener;
import com.garmin.fit.BatteryStatus;
import com.garmin.fit.Decode;
import com.garmin.fit.DeveloperField;
import com.garmin.fit.DeveloperFieldDescription;
import com.garmin.fit.DeveloperFieldDescriptionListener;
import com.garmin.fit.DeviceInfoMesg;
import com.garmin.fit.DeviceInfoMesgListener;
import com.garmin.fit.Factory;
import com.garmin.fit.Field;
import com.garmin.fit.FieldBase;
import com.garmin.fit.FileEncoder;
import com.garmin.fit.FileIdMesg;
import com.garmin.fit.FileIdMesgListener;
import com.garmin.fit.Fit;
import com.garmin.fit.FitRuntimeException;
import com.garmin.fit.Gender;
import com.garmin.fit.Mesg;
import com.garmin.fit.MesgBroadcaster;
import com.garmin.fit.MonitoringMesg;
import com.garmin.fit.MonitoringMesgListener;
import com.garmin.fit.RecordMesg;
import com.garmin.fit.RecordMesgListener;
import com.garmin.fit.SessionMesg;
import com.garmin.fit.SessionMesgListener;
import com.garmin.fit.UserProfileMesg;
import com.garmin.fit.UserProfileMesgListener;

import java.io.FileInputStream;

public class DecodeExample {

    private static FileEncoder sEncode;

    private static int sDays;
    static long timeGap;

    public static void main(String[] args) {
        Decode decode = new Decode();
        //decode.skipHeader();        // Use on streams with no header and footer (stream contains FIT defn and data messages only)
        //decode.incompleteStream();  // This suppresses exceptions with unexpected eof (also incorrect crc)
        MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
        Listener listener = new Listener();
        FileInputStream in;

        System.out.printf(
                "FIT Decode Example Application - Protocol %d.%d Profile %d.%d %s\n",
                Fit.PROTOCOL_VERSION_MAJOR,
                Fit.PROTOCOL_VERSION_MINOR,
                Fit.PROFILE_VERSION_MAJOR,
                Fit.PROFILE_VERSION_MINOR,
                Fit.PROFILE_TYPE
        );

        /*if (args.length != 1) {
            System.out.println("Usage: java -jar DecodeExample.jar <filename>");
            return;
        }*/

        try {
            in = new FileInputStream(args[0]);
        } catch (java.io.IOException e) {
            throw new RuntimeException("Error opening file " + args[0] + " [1]");
        }

        try {
            sDays = (int) TimeUtils.getTimeSpan(args[2], args[1], TimeConstants.DAY);
            timeGap = 86500L * sDays;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        try {
            if (!decode.checkFileIntegrity(in)) {
                throw new RuntimeException("FIT file integrity failed.");
            }
        } catch (RuntimeException e) {
            System.err.print("Exception Checking File Integrity: ");
            System.err.println(e.getMessage());
            System.err.println("Trying to continue...");
        } finally {
            try {
                in.close();
            } catch (java.io.IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            in = new FileInputStream(args[0]);
        } catch (java.io.IOException e) {
            throw new RuntimeException("Error opening file " + args[0] + " [2]");
        }
        LogUtils.d("Decoded FIT file " + args[0]);

        String newFitFilePath = Environment.getExternalStorageDirectory().getPath() + "/Download/" + args[2].replace(" ", "").replace("-", "").replace(":", "") + ".fit";
        try {
            sEncode = new FileEncoder(new java.io.File(newFitFilePath), Fit.ProtocolVersion.V2_0);
        } catch (FitRuntimeException e) {
            System.err.println("Error opening file ExampleActivity.fit");
            return;
        }

        mesgBroadcaster.addListener((FileIdMesgListener) listener);
        mesgBroadcaster.addListener((UserProfileMesgListener) listener);
        mesgBroadcaster.addListener((DeviceInfoMesgListener) listener);
        mesgBroadcaster.addListener((MonitoringMesgListener) listener);
        mesgBroadcaster.addListener((RecordMesgListener) listener);
        mesgBroadcaster.addListener((SessionMesgListener) listener);
        mesgBroadcaster.addListener((ActivityMesgListener) listener);

        decode.addListener(listener);

        try {
            decode.read(in, mesgBroadcaster, mesgBroadcaster);
        } catch (FitRuntimeException e) {
            // If a file with 0 data size in it's header  has been encountered,
            // attempt to keep processing the file
            if (decode.getInvalidFileDataSize()) {
                decode.nextFile();
                decode.read(in, mesgBroadcaster, mesgBroadcaster);
            } else {
                System.err.print("Exception decoding file: ");
                System.err.println(e.getMessage());

                try {
                    in.close();
                } catch (java.io.IOException f) {
                    throw new RuntimeException(f);
                }

                return;
            }
        }

        try {
            in.close();
            try {
                Thread.sleep(10000);
                sEncode.close();
            } catch (Exception e) {
                System.err.println("Error closing encode.");
                return;
            }
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }

        LogUtils.d("Encoded FIT file " + newFitFilePath);
    }

    private static class Listener implements ActivityMesgListener, FileIdMesgListener, UserProfileMesgListener, DeviceInfoMesgListener, MonitoringMesgListener, RecordMesgListener,
            DeveloperFieldDescriptionListener, SessionMesgListener {

        @Override
        public void onMesg(FileIdMesg mesg) {
            //System.out.println("File ID:");
            //LogUtils.d(GsonUtils.toJson(mesg));

            mesg.getFields().forEach(field -> {
                String name = field.getName();
                if (name.contains("time")) {
                    field.setRawValue(0, field.getLongValues()[0] + timeGap);
                }
            });
            sEncode.write(mesg);

            if (mesg.getType() != null) {
                System.out.print("   Type: ");
                System.out.println(mesg.getType().getValue());
            }

            if (mesg.getManufacturer() != null) {
                System.out.print("   Manufacturer: ");
                System.out.println(mesg.getManufacturer());
            }

            if (mesg.getProduct() != null) {
                System.out.print("   Product: ");
                System.out.println(mesg.getProduct());
            }

            if (mesg.getSerialNumber() != null) {
                System.out.print("   Serial Number: ");
                System.out.println(mesg.getSerialNumber());
            }

            if (mesg.getNumber() != null) {
                System.out.print("   Number: ");
                System.out.println(mesg.getNumber());
            }
        }

        @Override
        public void onMesg(UserProfileMesg mesg) {
            //System.out.println("User profile:");
            //LogUtils.d(GsonUtils.toJson(mesg));

            if (mesg.getFriendlyName() != null) {
                System.out.print("   Friendly Name: ");
                System.out.println(mesg.getFriendlyName());
            }

            if (mesg.getGender() != null) {
                if (mesg.getGender() == Gender.MALE) {
                    System.out.println("   Gender: Male");
                } else if (mesg.getGender() == Gender.FEMALE) {
                    System.out.println("   Gender: Female");
                }
            }

            if (mesg.getAge() != null) {
                System.out.print("   Age [years]: ");
                System.out.println(mesg.getAge());
            }

            if (mesg.getWeight() != null) {
                System.out.print("   Weight [kg]: ");
                System.out.println(mesg.getWeight());
            }
        }

        @Override
        public void onMesg(DeviceInfoMesg mesg) {
            //System.out.println("Device info:");
            //LogUtils.d(GsonUtils.toJson(mesg));

            sEncode.write(mesg);

            if (mesg.getTimestamp() != null) {
                System.out.print("   Timestamp: ");
                System.out.println(mesg.getTimestamp());
            }

            if (mesg.getBatteryStatus() != null) {
                System.out.print("   Battery status: ");

                switch (mesg.getBatteryStatus()) {
                    case BatteryStatus.CRITICAL:
                        System.out.println("Critical");
                        break;
                    case BatteryStatus.GOOD:
                        System.out.println("Good");
                        break;
                    case BatteryStatus.LOW:
                        System.out.println("Low");
                        break;
                    case BatteryStatus.NEW:
                        System.out.println("New");
                        break;
                    case BatteryStatus.OK:
                        System.out.println("OK");
                        break;
                    default:
                        System.out.println("Invalid");
                        break;
                }
            }
        }

        @Override
        public void onMesg(MonitoringMesg mesg) {
            //System.out.println("Monitoring:");
            //LogUtils.d(GsonUtils.toJson(mesg));

            if (mesg.getTimestamp() != null) {
                System.out.print("   Timestamp: ");
                System.out.println(mesg.getTimestamp());
            }

            if (mesg.getActivityType() != null) {
                System.out.print("   Activity Type: ");
                System.out.println(mesg.getActivityType());
            }

            // Depending on the ActivityType, there may be Steps, Strokes, or Cycles present in the file
            if (mesg.getSteps() != null) {
                System.out.print("   Steps: ");
                System.out.println(mesg.getSteps());
            } else if (mesg.getStrokes() != null) {
                System.out.print("   Strokes: ");
                System.out.println(mesg.getStrokes());
            } else if (mesg.getCycles() != null) {
                System.out.print("   Cycles: ");
                System.out.println(mesg.getCycles());
            }

            printDeveloperData(mesg);
        }

        @Override
        public void onMesg(RecordMesg mesg) {
            //System.out.println("Record:");
            //LogUtils.d(GsonUtils.toJson(mesg));

            mesg.getFields().forEach(field -> {
                if ("timestamp".equals(field.getName())) {
                    field.setRawValue(0, field.getLongValues()[0] + timeGap);
                }
            });
            sEncode.write(mesg);

            //printValues(mesg, RecordMesg.HeartRateFieldNum);
            //printValues(mesg, RecordMesg.CadenceFieldNum);
            //printValues(mesg, RecordMesg.DistanceFieldNum);
            //printValues(mesg, RecordMesg.SpeedFieldNum);

            printDeveloperData(mesg);
        }

        @Override
        public void onMesg(SessionMesg mesg) {
            String session = GsonUtils.toJson(mesg);
            //LogUtils.d(session);

            mesg.getFields().forEach(field -> {
                if (field.getName().equals("timestamp")) {
                    field.setRawValue(0, field.getLongValues()[0] + timeGap);
                }
                if (field.getName().equals("start_time")) {
                    field.setRawValue(0, field.getLongValues()[0] + timeGap);
                }
                if (field.getName().equals("local_timestamp")) {
                    field.setRawValue(0, field.getLongValues()[0] + timeGap);
                }
                /*if (field.getName().equals("total_timer_time")) {
                    field.setRawValue(0, field.getLongValues()[0]  - 86500*3);
                }
                if (field.getName().equals("total_moving_time")) {
                    field.setRawValue(0, field.getLongValues()[0] - 86500*3);
                }*/
            });
            sEncode.write(mesg);
        }

        @Override
        public void onMesg(ActivityMesg mesg) {
            String session = GsonUtils.toJson(mesg);
            //LogUtils.d(session);

            mesg.getFields().forEach(field -> {
                if (field.getName().equals("timestamp")) {
                    field.setRawValue(0, field.getLongValues()[0] + 4 - timeGap);
                }
                if (field.getName().equals("start_time")) {
                    field.setRawValue(0, field.getLongValues()[0] - timeGap);
                }
                if (field.getName().equals("local_timestamp")) {
                    field.setRawValue(0, field.getLongValues()[0] + 4 - timeGap);
                }
                /*if (field.getName().equals("total_timer_time")) {
                    field.setRawValue(0, field.getLongValues()[0] + 4 - 86500*3);
                }
                if (field.getName().equals("total_moving_time")) {
                    field.setRawValue(0, field.getLongValues()[0] + 4 - 86500*3);
                }*/
            });
            sEncode.write(mesg);
        }

        private void printDeveloperData(Mesg mesg) {
            for (DeveloperField field : mesg.getDeveloperFields()) {
                if (field.getNumValues() < 1) {
                    continue;
                }

                if (field.isDefined()) {
                    System.out.print("   " + field.getName());

                    if (field.getUnits() != null) {
                        System.out.print(" [" + field.getUnits() + "]");
                    }

                    System.out.print(": ");
                } else {
                    System.out.print("   Undefined Field: ");
                }

                System.out.print(field.getValue(0));
                for (int i = 1; i < field.getNumValues(); i++) {
                    System.out.print("," + field.getValue(i));
                }

                System.out.println();
            }
        }

        @Override
        public void onDescription(DeveloperFieldDescription desc) {
            System.out.println("New Developer Field Description");
            System.out.println("   App Id: " + desc.getApplicationId());
            System.out.println("   App Version: " + desc.getApplicationVersion());
            System.out.println("   Field Num: " + desc.getFieldDefinitionNumber());
        }

        private void printValues(Mesg mesg, int fieldNum) {
            Iterable<FieldBase> fields = mesg.getOverrideField((short) fieldNum);
            Field profileField = Factory.createField(mesg.getNum(), fieldNum);
            boolean namePrinted = false;

            if (profileField == null) {
                return;
            }

            for (FieldBase field : fields) {
                if (!namePrinted) {
                    System.out.println("   " + profileField.getName() + ":");
                    namePrinted = true;
                }

                if (field instanceof Field) {
                    System.out.println("      native: " + field.getValue());
                } else {
                    System.out.println("      override: " + field.getValue());
                }
            }
        }
    }
}
