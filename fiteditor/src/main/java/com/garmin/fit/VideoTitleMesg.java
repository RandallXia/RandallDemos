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



public class VideoTitleMesg extends Mesg   {

    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int MessageCountFieldNum = 0;
    
    public static final int TextFieldNum = 1;
    

    protected static final  Mesg videoTitleMesg;
    static {
        // video_title
        videoTitleMesg = new Mesg("video_title", MesgNum.VIDEO_TITLE);
        videoTitleMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        videoTitleMesg.addField(new Field("message_count", MessageCountFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        
        videoTitleMesg.addField(new Field("text", TextFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
    }

    public VideoTitleMesg() {
        super(Factory.createMesg(MesgNum.VIDEO_TITLE));
    }

    public VideoTitleMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get message_index field
     * Comment: Long titles will be split into multiple parts
     *
     * @return message_index
     */
    public Integer getMessageIndex() {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set message_index field
     * Comment: Long titles will be split into multiple parts
     *
     * @param messageIndex The new messageIndex value to be set
     */
    public void setMessageIndex(Integer messageIndex) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get message_count field
     * Comment: Total number of title parts
     *
     * @return message_count
     */
    public Integer getMessageCount() {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set message_count field
     * Comment: Total number of title parts
     *
     * @param messageCount The new messageCount value to be set
     */
    public void setMessageCount(Integer messageCount) {
        setFieldValue(0, 0, messageCount, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get text field
     *
     * @return text
     */
    public String getText() {
        return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set text field
     *
     * @param text The new text value to be set
     */
    public void setText(String text) {
        setFieldValue(1, 0, text, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
