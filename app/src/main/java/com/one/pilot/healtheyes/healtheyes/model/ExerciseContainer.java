package com.one.pilot.healtheyes.healtheyes.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Garkusha Andreys on 11/12/15.
 * 14/11/15 11.00 - 3.00
 * 15/11/15 12.40 - 11.40
 */
public class ExerciseContainer {
    protected List<Exercise> Container;
    protected int currentExercise;

    public ExerciseContainer() {
        Log.e("1", "Constructor");
        Container = new ArrayList<Exercise>();
        currentExercise = 0;
    }

    public void add(Exercise exercise) {
        Log.e("1", "Start of add");
        Container.add(exercise);
        Log.e("1", "End of add");
    }

    public void add(String name) {
        Exercise exercise = new Exercise();
    }

    public Exercise getCurrentExercise() {
        if (Container.isEmpty()) {
            Log.e("Exercise", "The container is empty");
            return null;
        }
        return Container.get(currentExercise);
    }

    public Exercise next() {
        if (currentExercise < Container.size() -1)
            currentExercise++;
        return getCurrentExercise();
    }

    public Exercise prev() {
        if (currentExercise > 0)
            currentExercise--;
        return getCurrentExercise();
    }

}
