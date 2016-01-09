package com.one.pilot.healtheyes.healtheyes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.one.pilot.healtheyes.healtheyes.alarm.vibration.AndroidVibration;
import com.one.pilot.healtheyes.healtheyes.exercise.Exercise;
import com.one.pilot.healtheyes.healtheyes.exercise.ExerciseContainer;
import com.one.pilot.healtheyes.healtheyes.exercise.ExerciseVisualization;
import com.one.pilot.healtheyes.healtheyes.timer.ExerciseTimer;
import com.one.pilot.healtheyes.healtheyes.timer.TimerVisualization;
import com.pascalwelsch.holocircularprogressbar.HoloCircularProgressBar;

public class MainActivity extends AppCompatActivity {

    ExerciseContainer exercises = new ExerciseContainer();

    private TimerVisualization timerVisualization = new TimerVisualization();
    private ExerciseVisualization exerciseVisualization = new ExerciseVisualization();
    private ExerciseTimer exerciseTimer = new ExerciseTimer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidVibration av = new AndroidVibration(this);

        timerVisualization.setTextView((TextView) findViewById(R.id.tv_timer));
        timerVisualization.setProgressBar((HoloCircularProgressBar) findViewById(
                R.id.holoCircularProgressBar));

        exerciseVisualization.setNameTextView((TextView) findViewById(R.id.tv_exercise_name));
        exerciseVisualization.setDescriptionTextView((TextView)findViewById(R.id.tv_exercise_description));

        exerciseTimer.setTimerVisualisation(timerVisualization);

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

        exercise1.addAlarm(av);

        exercises.add(exercise1);
        exercises.add(exercise2);
        exercises.add(exercise3);
        exercises.add(exercise4);
        exercises.add(exercise5);

        prepareNewExercise();
    }

    public void clickStartExercise(View view) {
        exerciseTimer.start();
    }

    public void clickNextExercise(View view) {
        exercises.next();
        prepareNewExercise();
    }

    public void clickPrevExercise(View view) {
        exercises.prev();
        prepareNewExercise();
    }

    private void prepareNewExercise() {
        exerciseVisualization.update(exercises.getCurrentExercise());
        exerciseTimer.init(exercises.getCurrentExercise());
    }

}
