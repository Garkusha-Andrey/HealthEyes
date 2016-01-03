package com.one.pilot.healtheyes.healtheyes.alarm;

/**
 * Created by Garkusha Andrey on 1/3/16.
 *
 * This class is an abstract layer for user notification
 * by any kind of alarms: vibration, sound, music, ...
 */
public abstract class AbstractAlarm {

    /** We have some defined Alarm types, which named in
     * this enum */
    public static enum AlarmType {READY, RUNNING, FINISHED};

    /** The only function in this class. It calls some alarm,
     * which related to type of alarm */
    public abstract int call(AlarmType type);
}
