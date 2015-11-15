package com.one.pilot.healtheyes.healtheyes;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.one.pilot.healtheyes.healtheyes.model.Exercise;
import com.one.pilot.healtheyes.healtheyes.model.ExerciseContainer;

import utils.one.com.TimeHelper;

public class MainActivity extends AppCompatActivity {

    ExerciseContainer exercises = new ExerciseContainer();

    protected TextView tv_Name;
    protected TextView tv_Description;
    protected TextView tv_Timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_Name = (TextView)findViewById(R.id.tv_exercise_name);
        tv_Description = (TextView)findViewById(R.id.tv_exercise_description);
        tv_Timer = (TextView)findViewById(R.id.tv_timer);

        Exercise exercise1 = new Exercise("Exercise 1");
        exercise1.setDescription("Description for exercise 1");
        exercise1.setLengthOfExcercise(9);
        Exercise exercise2 = new Exercise("Exercise 2");
        exercise2.setDescription("Description for exercise 2");
        exercise2.setLengthOfExcercise(12);
        Exercise exercise3 = new Exercise("Exercise 3");
        exercise3.setDescription("Description for exercise 3");
        exercise3.setLengthOfExcercise(711);
        Exercise exercise4 = new Exercise("Exercise 4");
        exercise4.setDescription("Description for exercise 4");
        exercise4.setLengthOfExcercise(72);
        Exercise exercise5 = new Exercise("Exercise 5");
        exercise5.setDescription("Description for exercise 5");
        exercise5.setLengthOfExcercise(42);
        exercises.add(exercise1);
        exercises.add(exercise2);
        exercises.add(exercise3);
        exercises.add(exercise4);
        exercises.add(exercise5);

        tv_Name.setText("Exercise: " + exercises.getCurrentExercise().getName());
        tv_Description.setText(exercises.getCurrentExercise().getDescription());
        tv_Timer.setText(TimeHelper.seccondsToStringMMSS(exercises.getCurrentExercise()
                .getLengthOfExcercise()));
    }

    public void clickStartExercise(View view) {
        Log.i("Main", "Start exercise");
        int duration = exercises.getCurrentExercise().getLengthOfExcercise();

        CountDownTimer countDownTimer = new CountDownTimer(duration * 1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_Timer.setText(TimeHelper.seccondsToStringMMSS((int)(millisUntilFinished / 1000)));
            }

            @Override
            public void onFinish() {}
        }.start();
    }

    public void clickNextExercise(View view) {
        Log.i("Main", "Click next exercise");

        exercises.next();

        tv_Name.setText("Exercise: " + exercises.getCurrentExercise().getName());
        tv_Description.setText(exercises.getCurrentExercise().getDescription());
        tv_Timer.setText(TimeHelper.seccondsToStringMMSS(exercises.getCurrentExercise()
                .getLengthOfExcercise()));
    }

    public void clickPrevExercise(View view) {
        Log.i("Main", "Click next exercise");

        exercises.prev();

        tv_Name.setText("Exercise: " + exercises.getCurrentExercise().getName());
        tv_Description.setText(exercises.getCurrentExercise().getDescription());
        tv_Timer.setText(TimeHelper.seccondsToStringMMSS(exercises.getCurrentExercise()
                .getLengthOfExcercise()));
    }

}
