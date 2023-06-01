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


package com.garmin.fit.util;

import com.garmin.fit.Fit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamHelpers {

    /**
     * Creates a java.io.ByteArrayInputStream from a file.
     *
     * @param fileName the name of the file
     * @return a java.io.ByteArrayInputStream containing the contents of the file
     * @throws IOException if an error occurs while creating a ByteArrayInputStream
     */
    public static ByteArrayInputStream byteStreamFromFile(String fileName) throws IOException {
        ByteArrayInputStream byteArrayInputStream;
        FileInputStream inputStream = new FileInputStream(fileName);
        return byteStreamFromInputStream(inputStream);
    }

    /**
     * Creates a java.io.ByteArrayInputStream from a java.io.InputStream.
     *
     * @param inputStream the InputStream to be converted
     * @return a ByteArrayInputStream containing the contents of the file
     * @throws IOException if an error occurs while creating a ByteArrayInputStream
     */
    public static ByteArrayInputStream byteStreamFromInputStream(InputStream inputStream) throws IOException {
        final int bufLen = inputStream.available();
        if (bufLen > 0) {
            byte[] buf = new byte[bufLen];
            int readLen;

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            while ((readLen = inputStream.read(buf, 0, bufLen)) != -1) {
                outputStream.write(buf, 0, readLen);
            }

            return new ByteArrayInputStream(outputStream.toByteArray());
        }
        return null;
    }

    /**
     * Creates a file and write the contents of a java.io.ByteArrayOutputStream to the file.
     *
     * @param csvStream the ByteArrayOutputStream to be written to the file.
     * @param outputFileName the name of the file to be created.
     * @param writeUTF8ByteOrderMark true if the UTF-8 byte order mark should be written to the file; false if not
     * @throws Exception if an error occurs while creating a file or writing the stream to the file
     */
    public static void writeByteStreamToFile(ByteArrayOutputStream csvStream, String outputFileName, Boolean writeUTF8ByteOrderMark) throws Exception {
            FileOutputStream csvFile = new FileOutputStream(outputFileName);

            if (writeUTF8ByteOrderMark) {
                csvFile.write(Fit.UTF8_BOM_BYTES);
            }

            csvStream.writeTo(csvFile);
    }
}
