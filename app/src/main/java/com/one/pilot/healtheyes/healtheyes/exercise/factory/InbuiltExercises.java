package com.one.pilot.healtheyes.healtheyes.exercise.factory;

import com.one.pilot.healtheyes.healtheyes.R;
import com.one.pilot.healtheyes.healtheyes.alarm.IAlarm;
import com.one.pilot.healtheyes.healtheyes.exercise.ExerciseContainer;
import com.one.pilot.healtheyes.healtheyes.exercise.VisualExercise;
import com.one.pilot.healtheyes.healtheyes.exercise.view.ExerciseDrawableGif;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Garkusha Andrey on 1/10/16.
 */
public class InbuiltExercises{

    private List<IAlarm> alarms = new ArrayList();

    public void replenish(ExerciseContainer container, ExerciseDrawableGif exerciseDrawableGif) {
        VisualExercise exercise1 = new VisualExercise("Exercise 1",
                "Description for exercise 1", 3);
        exercise1.setExerciseDrawable(exerciseDrawableGif);
        exercise1.setDrawableResID(R.drawable.android);

        VisualExercise exercise2 = new VisualExercise("Exercise 2",
                "Description for exercise 2", 5);
        exercise2.setExerciseDrawable(exerciseDrawableGif);
        exercise2.setDrawableAsset("animation/horse.gif");

        VisualExercise exercise3 = new VisualExercise("Exercise 3",
                "Description for exercise 3", 7);
        exercise3.setExerciseDrawable(exerciseDrawableGif);
        exercise3.setDrawableFile("/sdcard/auregional.gif");

        VisualExercise exercise4 = new VisualExercise("Exercise 4",
                "Description for exercise 4", 11);
        exercise4.setExerciseDrawable(exerciseDrawableGif);
        //exercise4.setDrawableUri("http://d13yacurqjgara.cloudfront.net/users/31664/screenshots/893769/bipolar-ball.gif");
        //Uri uri = Uri.parse("http://d13yacurqjgara.cloudfront.net/users/31664/screenshots/893769/bipolar-ball.gif");
        //exercise4.setResourceID(); //http://d13yacurqjgara.cloudfront.net/users/31664/screenshots/893769/bipolar-ball.gif

        VisualExercise exercise5 = new VisualExercise("Exercise 5",
                "Description for exercise 5", 256);
        exercise5.setExerciseDrawable(exerciseDrawableGif);

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
