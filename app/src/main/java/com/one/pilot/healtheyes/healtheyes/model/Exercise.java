package com.one.pilot.healtheyes.healtheyes.model;

import com.one.pilot.healtheyes.healtheyes.alarm.AbstractAlarm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Garkusha Andrey on 11/12/15.
 */
public class Exercise {
    protected String Name;
    protected String Description;
    protected int Duration;
    protected ExerciseStatus Status;


    public static enum ExerciseStatus {READY, RUNNING, FINISHED};
    private List<AbstractAlarm> alarms = new ArrayList();

    private Exercise() {
    }

    public Exercise(String name, String description, int duration) {
        initExercise(name, description, duration);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() { return Description; }

    public void setDescription(String description) {
        Description = description;
    }

    public int getDuration() { return Duration; }

    public void setDuration(int seconds) {
        Duration = seconds;
    }

    public ExerciseStatus getStatus() { return Status; }

    public void addAlarm(AbstractAlarm alarm) { alarms.add(alarm); }

    public void run() {
        Status = ExerciseStatus.RUNNING;
    }

    public void finish() {
        Status = ExerciseStatus.FINISHED;

        Iterator i = alarms.iterator();
        while (i.hasNext()) {
            AbstractAlarm alarm = (AbstractAlarm)i.next();
            alarm.call(AbstractAlarm.AlarmType.FINISHED);
        }
    }

    /* Private methods */
    private void initExercise(String name, String description, int duration) {
        Name = name;
        Description = description;
        Duration = duration;
        Status = ExerciseStatus.READY;
    }

}
