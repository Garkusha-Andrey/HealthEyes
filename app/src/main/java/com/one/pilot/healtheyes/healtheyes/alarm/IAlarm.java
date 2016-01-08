package com.one.pilot.healtheyes.healtheyes.alarm;

/**
 * Created by Garkusha Andrey on 1/3/16.
 *
 * This class is an interface class for user notification.
 * It needs to notify user about start of exercise, finish, ...
 * Alarm can use any kind of notification: vibration, sound,
 * music, etc.
 */
public interface IAlarm {

    /** We have some defined Alarm types, which named in
     * this enum */
    public static enum AlarmType {READY, RUNNING, STARTED, FINISHED};

    /** The only function in this class. It calls some alarm,
     * which related to type of alarm */
    public int call(AlarmType type);
}
