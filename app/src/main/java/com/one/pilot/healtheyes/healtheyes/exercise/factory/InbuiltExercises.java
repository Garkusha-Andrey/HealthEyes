package com.one.pilot.healtheyes.healtheyes.exercise.factory;

import android.util.Log;

import com.one.pilot.healtheyes.healtheyes.alarm.IAlarm;
import com.one.pilot.healtheyes.healtheyes.exercise.Exercise;
import com.one.pilot.healtheyes.healtheyes.exercise.ExerciseContainer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Garkusha Andrey on 1/10/16.
 */
public class InbuiltExercises implements IExerciseSource {

    private List<IAlarm> alarms = new ArrayList();

    public void replenish(ExerciseContainer container) {
        Exercise exercise1 = new Exercise("Exercise 1",
                "Description for exercise 1", 3);
        Exercise exercise2 = new Exercise("Exercise 2",
                "Description for exercise 2", 5);
        Exercise exercise3 = new Exercise("Exercise 3",
                "Description for exercise 3", 7);
        Exercise exercise4 = new Exercise("Exercise 4",
                "Description for exercise 4", 11);
        Exercise exercise5 = new Exercise("Exercise 5",
                "Description for exercise 5", 256);

        Iterator i = alarms.iterator();
        while (i.hasNext()) {
            IAlarm alarm = (IAlarm)i.next();

            exercise1.addAlarm(alarm);
            exercise2.addAlarm(alarm);
            exercise3.addAlarm(alarm);
            exercise4.addAlarm(alarm);
            exercise5.addAlarm(alarm);
        }

        container.add(exercise1);
        container.add(exercise2);
        container.add(exercise3);
        container.add(exercise4);
        container.add(exercise5);
    }

    public void addAlarm(IAlarm alarm) { alarms.add(alarm); }
}
