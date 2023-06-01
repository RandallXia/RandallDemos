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



public class EventMesg extends Mesg implements MesgWithEvent   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int EventFieldNum = 0;
    
    public static final int EventTypeFieldNum = 1;
    
    public static final int Data16FieldNum = 2;
    
    public static final int DataFieldNum = 3;
    
    public static final int EventGroupFieldNum = 4;
    
    public static final int ScoreFieldNum = 7;
    
    public static final int OpponentScoreFieldNum = 8;
    
    public static final int FrontGearNumFieldNum = 9;
    
    public static final int FrontGearFieldNum = 10;
    
    public static final int RearGearNumFieldNum = 11;
    
    public static final int RearGearFieldNum = 12;
    
    public static final int DeviceIndexFieldNum = 13;
    
    public static final int RadarThreatLevelMaxFieldNum = 21;
    
    public static final int RadarThreatCountFieldNum = 22;
    
    public static final int RadarThreatAvgApproachSpeedFieldNum = 23;
    
    public static final int RadarThreatMaxApproachSpeedFieldNum = 24;
    

    protected static final  Mesg eventMesg;
    static {
        int field_index = 0;
        int subfield_index = 0;
        // event
        eventMesg = new Mesg("event", MesgNum.EVENT);
        eventMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        field_index++;
        eventMesg.addField(new Field("event", EventFieldNum, 0, 1, 0, "", false, Profile.Type.EVENT));
        field_index++;
        eventMesg.addField(new Field("event_type", EventTypeFieldNum, 0, 1, 0, "", false, Profile.Type.EVENT_TYPE));
        field_index++;
        eventMesg.addField(new Field("data16", Data16FieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        eventMesg.fields.get(field_index).components.add(new FieldComponent(3, false, 16, 1, 0)); // data
        field_index++;
        eventMesg.addField(new Field("data", DataFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        subfield_index = 0;
        eventMesg.fields.get(field_index).subFields.add(new SubField("timer_trigger", 0, 1, 0, ""));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 0);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("course_point_index", 132, 1, 0, ""));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 10);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("battery_level", 132, 1000, 0, "V"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 11);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("virtual_partner_speed", 132, 1000, 0, "m/s"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 12);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("hr_high_alert", 2, 1, 0, "bpm"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 13);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("hr_low_alert", 2, 1, 0, "bpm"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 14);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("speed_high_alert", 134, 1000, 0, "m/s"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 15);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("speed_low_alert", 134, 1000, 0, "m/s"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 16);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("cad_high_alert", 132, 1, 0, "rpm"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 17);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("cad_low_alert", 132, 1, 0, "rpm"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 18);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("power_high_alert", 132, 1, 0, "watts"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 19);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("power_low_alert", 132, 1, 0, "watts"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 20);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("time_duration_alert", 134, 1000, 0, "s"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 23);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("distance_duration_alert", 134, 100, 0, "m"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 24);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("calorie_duration_alert", 134, 1, 0, "calories"));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 25);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("fitness_equipment_state", 0, 1, 0, ""));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 27);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("sport_point", 134, 1, 0, ""));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 33);
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addComponent(new FieldComponent(7, false, 16, 1, 0));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addComponent(new FieldComponent(8, false, 16, 1, 0));
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("gear_change_data", 134, 1, 0, ""));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 42);
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 43);
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addComponent(new FieldComponent(11, false, 8, 1, 0));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addComponent(new FieldComponent(12, false, 8, 1, 0));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addComponent(new FieldComponent(9, false, 8, 1, 0));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addComponent(new FieldComponent(10, false, 8, 1, 0));
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("rider_position", 0, 1, 0, ""));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 44);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("comm_timeout", 132, 1, 0, ""));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 47);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("dive_alert", 0, 1, 0, ""));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 56);
        subfield_index++;
        eventMesg.fields.get(field_index).subFields.add(new SubField("radar_threat_alert", 134, 1, 0, ""));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 75);
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addComponent(new FieldComponent(21, false, 8, 1, 0));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addComponent(new FieldComponent(22, false, 8, 1, 0));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addComponent(new FieldComponent(23, false, 8, 10, 0));
        eventMesg.fields.get(field_index).subFields.get(subfield_index).addComponent(new FieldComponent(24, false, 8, 10, 0));
        subfield_index++;
        field_index++;
        eventMesg.addField(new Field("event_group", EventGroupFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        field_index++;
        eventMesg.addField(new Field("score", ScoreFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        field_index++;
        eventMesg.addField(new Field("opponent_score", OpponentScoreFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        field_index++;
        eventMesg.addField(new Field("front_gear_num", FrontGearNumFieldNum, 10, 1, 0, "", false, Profile.Type.UINT8Z));
        field_index++;
        eventMesg.addField(new Field("front_gear", FrontGearFieldNum, 10, 1, 0, "", false, Profile.Type.UINT8Z));
        field_index++;
        eventMesg.addField(new Field("rear_gear_num", RearGearNumFieldNum, 10, 1, 0, "", false, Profile.Type.UINT8Z));
        field_index++;
        eventMesg.addField(new Field("rear_gear", RearGearFieldNum, 10, 1, 0, "", false, Profile.Type.UINT8Z));
        field_index++;
        eventMesg.addField(new Field("device_index", DeviceIndexFieldNum, 2, 1, 0, "", false, Profile.Type.DEVICE_INDEX));
        field_index++;
        eventMesg.addField(new Field("radar_threat_level_max", RadarThreatLevelMaxFieldNum, 0, 1, 0, "", false, Profile.Type.RADAR_THREAT_LEVEL_TYPE));
        field_index++;
        eventMesg.addField(new Field("radar_threat_count", RadarThreatCountFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        field_index++;
        eventMesg.addField(new Field("radar_threat_avg_approach_speed", RadarThreatAvgApproachSpeedFieldNum, 2, 10, 0, "m/s", false, Profile.Type.UINT8));
        field_index++;
        eventMesg.addField(new Field("radar_threat_max_approach_speed", RadarThreatMaxApproachSpeedFieldNum, 2, 10, 0, "m/s", false, Profile.Type.UINT8));
        field_index++;
    }

    public EventMesg() {
        super(Factory.createMesg(MesgNum.EVENT));
    }

    public EventMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get event field
     *
     * @return event
     */
    public Event getEvent() {
        Short value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Event.getByValue(value);
    }

    /**
     * Set event field
     *
     * @param event The new event value to be set
     */
    public void setEvent(Event event) {
        setFieldValue(0, 0, event.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get event_type field
     *
     * @return event_type
     */
    public EventType getEventType() {
        Short value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return EventType.getByValue(value);
    }

    /**
     * Set event_type field
     *
     * @param eventType The new eventType value to be set
     */
    public void setEventType(EventType eventType) {
        setFieldValue(1, 0, eventType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get data16 field
     *
     * @return data16
     */
    public Integer getData16() {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set data16 field
     *
     * @param data16 The new data16 value to be set
     */
    public void setData16(Integer data16) {
        setFieldValue(2, 0, data16, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get data field
     *
     * @return data
     */
    public Long getData() {
        return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set data field
     *
     * @param data The new data value to be set
     */
    public void setData(Long data) {
        setFieldValue(3, 0, data, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get timer_trigger field
     *
     * @return timer_trigger
     */
    public TimerTrigger getTimerTrigger() {
        Short value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIMER_TRIGGER);
        if (value == null) {
            return null;
        }
        return TimerTrigger.getByValue(value);
    }

    /**
     * Set timer_trigger field
     *
     * @param timerTrigger The new timerTrigger value to be set
     */
    public void setTimerTrigger(TimerTrigger timerTrigger) {
        setFieldValue(3, 0, timerTrigger.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIMER_TRIGGER);
    }

    /**
     * Get course_point_index field
     *
     * @return course_point_index
     */
    public Integer getCoursePointIndex() {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_COURSE_POINT_INDEX);
    }

    /**
     * Set course_point_index field
     *
     * @param coursePointIndex The new coursePointIndex value to be set
     */
    public void setCoursePointIndex(Integer coursePointIndex) {
        setFieldValue(3, 0, coursePointIndex, Profile.SubFields.EVENT_MESG_DATA_FIELD_COURSE_POINT_INDEX);
    }

    /**
     * Get battery_level field
     * Units: V
     *
     * @return battery_level
     */
    public Float getBatteryLevel() {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_BATTERY_LEVEL);
    }

    /**
     * Set battery_level field
     * Units: V
     *
     * @param batteryLevel The new batteryLevel value to be set
     */
    public void setBatteryLevel(Float batteryLevel) {
        setFieldValue(3, 0, batteryLevel, Profile.SubFields.EVENT_MESG_DATA_FIELD_BATTERY_LEVEL);
    }

    /**
     * Get virtual_partner_speed field
     * Units: m/s
     *
     * @return virtual_partner_speed
     */
    public Float getVirtualPartnerSpeed() {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_VIRTUAL_PARTNER_SPEED);
    }

    /**
     * Set virtual_partner_speed field
     * Units: m/s
     *
     * @param virtualPartnerSpeed The new virtualPartnerSpeed value to be set
     */
    public void setVirtualPartnerSpeed(Float virtualPartnerSpeed) {
        setFieldValue(3, 0, virtualPartnerSpeed, Profile.SubFields.EVENT_MESG_DATA_FIELD_VIRTUAL_PARTNER_SPEED);
    }

    /**
     * Get hr_high_alert field
     * Units: bpm
     *
     * @return hr_high_alert
     */
    public Short getHrHighAlert() {
        return getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_HIGH_ALERT);
    }

    /**
     * Set hr_high_alert field
     * Units: bpm
     *
     * @param hrHighAlert The new hrHighAlert value to be set
     */
    public void setHrHighAlert(Short hrHighAlert) {
        setFieldValue(3, 0, hrHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_HIGH_ALERT);
    }

    /**
     * Get hr_low_alert field
     * Units: bpm
     *
     * @return hr_low_alert
     */
    public Short getHrLowAlert() {
        return getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_LOW_ALERT);
    }

    /**
     * Set hr_low_alert field
     * Units: bpm
     *
     * @param hrLowAlert The new hrLowAlert value to be set
     */
    public void setHrLowAlert(Short hrLowAlert) {
        setFieldValue(3, 0, hrLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_LOW_ALERT);
    }

    /**
     * Get speed_high_alert field
     * Units: m/s
     *
     * @return speed_high_alert
     */
    public Float getSpeedHighAlert() {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_HIGH_ALERT);
    }

    /**
     * Set speed_high_alert field
     * Units: m/s
     *
     * @param speedHighAlert The new speedHighAlert value to be set
     */
    public void setSpeedHighAlert(Float speedHighAlert) {
        setFieldValue(3, 0, speedHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_HIGH_ALERT);
    }

    /**
     * Get speed_low_alert field
     * Units: m/s
     *
     * @return speed_low_alert
     */
    public Float getSpeedLowAlert() {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_LOW_ALERT);
    }

    /**
     * Set speed_low_alert field
     * Units: m/s
     *
     * @param speedLowAlert The new speedLowAlert value to be set
     */
    public void setSpeedLowAlert(Float speedLowAlert) {
        setFieldValue(3, 0, speedLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_LOW_ALERT);
    }

    /**
     * Get cad_high_alert field
     * Units: rpm
     *
     * @return cad_high_alert
     */
    public Integer getCadHighAlert() {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_HIGH_ALERT);
    }

    /**
     * Set cad_high_alert field
     * Units: rpm
     *
     * @param cadHighAlert The new cadHighAlert value to be set
     */
    public void setCadHighAlert(Integer cadHighAlert) {
        setFieldValue(3, 0, cadHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_HIGH_ALERT);
    }

    /**
     * Get cad_low_alert field
     * Units: rpm
     *
     * @return cad_low_alert
     */
    public Integer getCadLowAlert() {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_LOW_ALERT);
    }

    /**
     * Set cad_low_alert field
     * Units: rpm
     *
     * @param cadLowAlert The new cadLowAlert value to be set
     */
    public void setCadLowAlert(Integer cadLowAlert) {
        setFieldValue(3, 0, cadLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_LOW_ALERT);
    }

    /**
     * Get power_high_alert field
     * Units: watts
     *
     * @return power_high_alert
     */
    public Integer getPowerHighAlert() {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_HIGH_ALERT);
    }

    /**
     * Set power_high_alert field
     * Units: watts
     *
     * @param powerHighAlert The new powerHighAlert value to be set
     */
    public void setPowerHighAlert(Integer powerHighAlert) {
        setFieldValue(3, 0, powerHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_HIGH_ALERT);
    }

    /**
     * Get power_low_alert field
     * Units: watts
     *
     * @return power_low_alert
     */
    public Integer getPowerLowAlert() {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_LOW_ALERT);
    }

    /**
     * Set power_low_alert field
     * Units: watts
     *
     * @param powerLowAlert The new powerLowAlert value to be set
     */
    public void setPowerLowAlert(Integer powerLowAlert) {
        setFieldValue(3, 0, powerLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_LOW_ALERT);
    }

    /**
     * Get time_duration_alert field
     * Units: s
     *
     * @return time_duration_alert
     */
    public Float getTimeDurationAlert() {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIME_DURATION_ALERT);
    }

    /**
     * Set time_duration_alert field
     * Units: s
     *
     * @param timeDurationAlert The new timeDurationAlert value to be set
     */
    public void setTimeDurationAlert(Float timeDurationAlert) {
        setFieldValue(3, 0, timeDurationAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIME_DURATION_ALERT);
    }

    /**
     * Get distance_duration_alert field
     * Units: m
     *
     * @return distance_duration_alert
     */
    public Float getDistanceDurationAlert() {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_DISTANCE_DURATION_ALERT);
    }

    /**
     * Set distance_duration_alert field
     * Units: m
     *
     * @param distanceDurationAlert The new distanceDurationAlert value to be set
     */
    public void setDistanceDurationAlert(Float distanceDurationAlert) {
        setFieldValue(3, 0, distanceDurationAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_DISTANCE_DURATION_ALERT);
    }

    /**
     * Get calorie_duration_alert field
     * Units: calories
     *
     * @return calorie_duration_alert
     */
    public Long getCalorieDurationAlert() {
        return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_CALORIE_DURATION_ALERT);
    }

    /**
     * Set calorie_duration_alert field
     * Units: calories
     *
     * @param calorieDurationAlert The new calorieDurationAlert value to be set
     */
    public void setCalorieDurationAlert(Long calorieDurationAlert) {
        setFieldValue(3, 0, calorieDurationAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_CALORIE_DURATION_ALERT);
    }

    /**
     * Get fitness_equipment_state field
     *
     * @return fitness_equipment_state
     */
    public FitnessEquipmentState getFitnessEquipmentState() {
        Short value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_FITNESS_EQUIPMENT_STATE);
        if (value == null) {
            return null;
        }
        return FitnessEquipmentState.getByValue(value);
    }

    /**
     * Set fitness_equipment_state field
     *
     * @param fitnessEquipmentState The new fitnessEquipmentState value to be set
     */
    public void setFitnessEquipmentState(FitnessEquipmentState fitnessEquipmentState) {
        setFieldValue(3, 0, fitnessEquipmentState.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_FITNESS_EQUIPMENT_STATE);
    }

    /**
     * Get sport_point field
     *
     * @return sport_point
     */
    public Long getSportPoint() {
        return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPORT_POINT);
    }

    /**
     * Set sport_point field
     *
     * @param sportPoint The new sportPoint value to be set
     */
    public void setSportPoint(Long sportPoint) {
        setFieldValue(3, 0, sportPoint, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPORT_POINT);
    }

    /**
     * Get gear_change_data field
     *
     * @return gear_change_data
     */
    public Long getGearChangeData() {
        return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_GEAR_CHANGE_DATA);
    }

    /**
     * Set gear_change_data field
     *
     * @param gearChangeData The new gearChangeData value to be set
     */
    public void setGearChangeData(Long gearChangeData) {
        setFieldValue(3, 0, gearChangeData, Profile.SubFields.EVENT_MESG_DATA_FIELD_GEAR_CHANGE_DATA);
    }

    /**
     * Get rider_position field
     * Comment: Indicates the rider position value.
     *
     * @return rider_position
     */
    public RiderPositionType getRiderPosition() {
        Short value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_RIDER_POSITION);
        if (value == null) {
            return null;
        }
        return RiderPositionType.getByValue(value);
    }

    /**
     * Set rider_position field
     * Comment: Indicates the rider position value.
     *
     * @param riderPosition The new riderPosition value to be set
     */
    public void setRiderPosition(RiderPositionType riderPosition) {
        setFieldValue(3, 0, riderPosition.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_RIDER_POSITION);
    }

    /**
     * Get comm_timeout field
     *
     * @return comm_timeout
     */
    public Integer getCommTimeout() {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_COMM_TIMEOUT);
    }

    /**
     * Set comm_timeout field
     *
     * @param commTimeout The new commTimeout value to be set
     */
    public void setCommTimeout(Integer commTimeout) {
        setFieldValue(3, 0, commTimeout, Profile.SubFields.EVENT_MESG_DATA_FIELD_COMM_TIMEOUT);
    }

    /**
     * Get dive_alert field
     *
     * @return dive_alert
     */
    public DiveAlert getDiveAlert() {
        Short value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_DIVE_ALERT);
        if (value == null) {
            return null;
        }
        return DiveAlert.getByValue(value);
    }

    /**
     * Set dive_alert field
     *
     * @param diveAlert The new diveAlert value to be set
     */
    public void setDiveAlert(DiveAlert diveAlert) {
        setFieldValue(3, 0, diveAlert.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_DIVE_ALERT);
    }

    /**
     * Get radar_threat_alert field
     * Comment: The first byte is the radar_threat_level_max, the second byte is the radar_threat_count, third bytes is the average approach speed, and the 4th byte is the max approach speed
     *
     * @return radar_threat_alert
     */
    public Long getRadarThreatAlert() {
        return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_RADAR_THREAT_ALERT);
    }

    /**
     * Set radar_threat_alert field
     * Comment: The first byte is the radar_threat_level_max, the second byte is the radar_threat_count, third bytes is the average approach speed, and the 4th byte is the max approach speed
     *
     * @param radarThreatAlert The new radarThreatAlert value to be set
     */
    public void setRadarThreatAlert(Long radarThreatAlert) {
        setFieldValue(3, 0, radarThreatAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_RADAR_THREAT_ALERT);
    }

    /**
     * Get event_group field
     *
     * @return event_group
     */
    public Short getEventGroup() {
        return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set event_group field
     *
     * @param eventGroup The new eventGroup value to be set
     */
    public void setEventGroup(Short eventGroup) {
        setFieldValue(4, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get score field
     * Comment: Do not populate directly. Autogenerated by decoder for sport_point subfield components
     *
     * @return score
     */
    public Integer getScore() {
        return getFieldIntegerValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set score field
     * Comment: Do not populate directly. Autogenerated by decoder for sport_point subfield components
     *
     * @param score The new score value to be set
     */
    public void setScore(Integer score) {
        setFieldValue(7, 0, score, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get opponent_score field
     * Comment: Do not populate directly. Autogenerated by decoder for sport_point subfield components
     *
     * @return opponent_score
     */
    public Integer getOpponentScore() {
        return getFieldIntegerValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set opponent_score field
     * Comment: Do not populate directly. Autogenerated by decoder for sport_point subfield components
     *
     * @param opponentScore The new opponentScore value to be set
     */
    public void setOpponentScore(Integer opponentScore) {
        setFieldValue(8, 0, opponentScore, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get front_gear_num field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Front gear number. 1 is innermost.
     *
     * @return front_gear_num
     */
    public Short getFrontGearNum() {
        return getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set front_gear_num field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Front gear number. 1 is innermost.
     *
     * @param frontGearNum The new frontGearNum value to be set
     */
    public void setFrontGearNum(Short frontGearNum) {
        setFieldValue(9, 0, frontGearNum, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get front_gear field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Number of front teeth.
     *
     * @return front_gear
     */
    public Short getFrontGear() {
        return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set front_gear field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Number of front teeth.
     *
     * @param frontGear The new frontGear value to be set
     */
    public void setFrontGear(Short frontGear) {
        setFieldValue(10, 0, frontGear, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get rear_gear_num field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Rear gear number. 1 is innermost.
     *
     * @return rear_gear_num
     */
    public Short getRearGearNum() {
        return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set rear_gear_num field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Rear gear number. 1 is innermost.
     *
     * @param rearGearNum The new rearGearNum value to be set
     */
    public void setRearGearNum(Short rearGearNum) {
        setFieldValue(11, 0, rearGearNum, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get rear_gear field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Number of rear teeth.
     *
     * @return rear_gear
     */
    public Short getRearGear() {
        return getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set rear_gear field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Number of rear teeth.
     *
     * @param rearGear The new rearGear value to be set
     */
    public void setRearGear(Short rearGear) {
        setFieldValue(12, 0, rearGear, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get device_index field
     *
     * @return device_index
     */
    public Short getDeviceIndex() {
        return getFieldShortValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set device_index field
     *
     * @param deviceIndex The new deviceIndex value to be set
     */
    public void setDeviceIndex(Short deviceIndex) {
        setFieldValue(13, 0, deviceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get radar_threat_level_max field
     * Comment: Do not populate directly. Autogenerated by decoder for threat_alert subfield components.
     *
     * @return radar_threat_level_max
     */
    public RadarThreatLevelType getRadarThreatLevelMax() {
        Short value = getFieldShortValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return RadarThreatLevelType.getByValue(value);
    }

    /**
     * Set radar_threat_level_max field
     * Comment: Do not populate directly. Autogenerated by decoder for threat_alert subfield components.
     *
     * @param radarThreatLevelMax The new radarThreatLevelMax value to be set
     */
    public void setRadarThreatLevelMax(RadarThreatLevelType radarThreatLevelMax) {
        setFieldValue(21, 0, radarThreatLevelMax.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get radar_threat_count field
     * Comment: Do not populate directly. Autogenerated by decoder for threat_alert subfield components.
     *
     * @return radar_threat_count
     */
    public Short getRadarThreatCount() {
        return getFieldShortValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set radar_threat_count field
     * Comment: Do not populate directly. Autogenerated by decoder for threat_alert subfield components.
     *
     * @param radarThreatCount The new radarThreatCount value to be set
     */
    public void setRadarThreatCount(Short radarThreatCount) {
        setFieldValue(22, 0, radarThreatCount, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get radar_threat_avg_approach_speed field
     * Units: m/s
     * Comment: Do not populate directly. Autogenerated by decoder for radar_threat_alert subfield components
     *
     * @return radar_threat_avg_approach_speed
     */
    public Float getRadarThreatAvgApproachSpeed() {
        return getFieldFloatValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set radar_threat_avg_approach_speed field
     * Units: m/s
     * Comment: Do not populate directly. Autogenerated by decoder for radar_threat_alert subfield components
     *
     * @param radarThreatAvgApproachSpeed The new radarThreatAvgApproachSpeed value to be set
     */
    public void setRadarThreatAvgApproachSpeed(Float radarThreatAvgApproachSpeed) {
        setFieldValue(23, 0, radarThreatAvgApproachSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get radar_threat_max_approach_speed field
     * Units: m/s
     * Comment: Do not populate directly. Autogenerated by decoder for radar_threat_alert subfield components
     *
     * @return radar_threat_max_approach_speed
     */
    public Float getRadarThreatMaxApproachSpeed() {
        return getFieldFloatValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set radar_threat_max_approach_speed field
     * Units: m/s
     * Comment: Do not populate directly. Autogenerated by decoder for radar_threat_alert subfield components
     *
     * @param radarThreatMaxApproachSpeed The new radarThreatMaxApproachSpeed value to be set
     */
    public void setRadarThreatMaxApproachSpeed(Float radarThreatMaxApproachSpeed) {
        setFieldValue(24, 0, radarThreatMaxApproachSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
