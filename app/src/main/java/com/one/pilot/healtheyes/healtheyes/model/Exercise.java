package com.one.pilot.healtheyes.healtheyes.model;

import android.util.Log;

/**
 * Created by Garkusha Andrey on 11/12/15.
 */
public class Exercise {
    protected String Name;
    protected String Description;
    protected int LengthOfExcercise;
    protected ExerciseStatus Status;

    public static enum ExerciseStatus {READY, RUNNING, FINISHED};

    protected Exercise() {
    }

    public Exercise(String name) {
        Name = name;
        Description = "Simple description";
        LengthOfExcercise = 0;
        Status = ExerciseStatus.READY;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getLengthOfExcercise() {
        return LengthOfExcercise;
    }

    public void setLengthOfExcercise(int secconds) {
        LengthOfExcercise = secconds;
    }

    public void run() {
        Status = ExerciseStatus.RUNNING;
    }

    public void finish() {
        Status = ExerciseStatus.FINISHED;
    }

    public ExerciseStatus getStatus() { return Status; }

}
