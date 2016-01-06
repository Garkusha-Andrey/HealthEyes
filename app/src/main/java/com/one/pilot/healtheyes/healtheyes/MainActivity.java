package com.one.pilot.healtheyes.healtheyes;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.one.pilot.healtheyes.healtheyes.alarm.vibration.AndroidVibration;
import com.one.pilot.healtheyes.healtheyes.model.Exercise;
import com.one.pilot.healtheyes.healtheyes.model.ExerciseContainer;
import com.pascalwelsch.holocircularprogressbar.HoloCircularProgressBar;

import utils.one.com.TimeHelper;

public class MainActivity extends AppCompatActivity {

    ExerciseContainer exercises = new ExerciseContainer();

    private TextView tv_Name;
    private TextView tv_Description;
    private TextView tv_Timer;
    private HoloCircularProgressBar mHoloCircularProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_Name = (TextView)findViewById(R.id.tv_exercise_name);
        tv_Description = (TextView)findViewById(R.id.tv_exercise_description);
        tv_Timer = (TextView)findViewById(R.id.tv_timer);
        mHoloCircularProgressBar = (HoloCircularProgressBar)findViewById(
                R.id.holoCircularProgressBar);

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
        AndroidVibration av = new AndroidVibration(this);
        exercise1.addAlarm(av);

        exercises.add(exercise1);
        exercises.add(exercise2);
        exercises.add(exercise3);
        exercises.add(exercise4);
        exercises.add(exercise5);

        tv_Name.setText("Exercise: " + exercises.getCurrentExercise().getName());
        tv_Description.setText(exercises.getCurrentExercise().getDescription());
        tv_Timer.setText(TimeHelper.seccondsToStringMMSS(exercises.getCurrentExercise()
                .getDuration()));
        mHoloCircularProgressBar.setProgress(0.0F);

    }

    public void clickStartExercise(View view) {
        Log.i("Main", "Start exercise");
        if (exercises.getCurrentExercise().getStatus() == Exercise.ExerciseStatus.RUNNING)
            return;

        exercises.getCurrentExercise().run();
        int duration = exercises.getCurrentExercise().getDuration();


        findViewById(R.id.bn_next_exercise).setEnabled(false); // Disable Next Button
        findViewById(R.id.bn_prev_exercise).setEnabled(false); // Disable Prev Button
        mHoloCircularProgressBar.setProgress(0.0F);
        mHoloCircularProgressBar.setMarkerProgress(0.0F);

        CountDownTimer countDownTimer = new CountDownTimer(duration * 1000, 70) {
            float progress = 0.0F;
            float duration = exercises.getCurrentExercise().getDuration() * 1000; // in ms
            @Override
            public void onTick(long millisUntilFinished) {
                // +999 need to make timer more comfortable for user
                tv_Timer.setText(TimeHelper.seccondsToStringMMSS(
                        (int)((millisUntilFinished + 999) / 1000 )));

                progress = (duration - millisUntilFinished) / duration;
                mHoloCircularProgressBar.setProgress(progress);
            }

            @Override
            public void onFinish() {
                exercises.getCurrentExercise().finish();
                tv_Timer.setText(TimeHelper.seccondsToStringMMSS(0));
                findViewById(R.id.bn_next_exercise).setEnabled(true); // Enable Next Button
                findViewById(R.id.bn_prev_exercise).setEnabled(true); // Enable Prev Button
                mHoloCircularProgressBar.setProgress(1.0F);
            }
        }.start();
    }

    public void clickNextExercise(View view) {
        Log.i("Main", "Click next exercise");

        exercises.next();

        tv_Name.setText("Exercise: " + exercises.getCurrentExercise().getName());
        tv_Description.setText(exercises.getCurrentExercise().getDescription());
        tv_Timer.setText(TimeHelper.seccondsToStringMMSS(exercises.getCurrentExercise()
                .getDuration()));
    }

    public void clickPrevExercise(View view) {
        Log.i("Main", "Click next exercise");

        exercises.prev();

        tv_Name.setText("Exercise: " + exercises.getCurrentExercise().getName());
        tv_Description.setText(exercises.getCurrentExercise().getDescription());
        tv_Timer.setText(TimeHelper.seccondsToStringMMSS(exercises.getCurrentExercise()
                .getDuration()));
    }

}
