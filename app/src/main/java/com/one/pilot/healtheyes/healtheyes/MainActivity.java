package com.one.pilot.healtheyes.healtheyes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.one.pilot.healtheyes.healtheyes.alarm.vibration.AndroidVibration;
import com.one.pilot.healtheyes.healtheyes.exercise.ExerciseContainer;
import com.one.pilot.healtheyes.healtheyes.exercise.ExerciseVisualization;
import com.one.pilot.healtheyes.healtheyes.exercise.factory.InbuiltExercises;
import com.one.pilot.healtheyes.healtheyes.exercise.view.ExerciseDrawableGif;
import com.one.pilot.healtheyes.healtheyes.timer.ExerciseTimer;
import com.one.pilot.healtheyes.healtheyes.timer.TimerVisualization;
import com.pascalwelsch.holocircularprogressbar.HoloCircularProgressBar;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    private ExerciseTimer exerciseTimer = new ExerciseTimer();
    private ExerciseContainer exercises = new ExerciseContainer();
    private InbuiltExercises inbuiltExercises = new InbuiltExercises();

    private TimerVisualization timerVisualization = new TimerVisualization();
    private ExerciseVisualization exerciseVisualization = new ExerciseVisualization();
    private ExerciseDrawableGif exerciseDrawableGif = new ExerciseDrawableGif();

    //private GifImageView gifImageView;
    //GifDrawable gifDrawable = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidVibration av = new AndroidVibration(this);

        timerVisualization.setTextView((TextView) findViewById(R.id.tv_timer));
        timerVisualization.setProgressBar((HoloCircularProgressBar) findViewById(
                R.id.holoCircularProgressBar));

        exerciseVisualization.setNameTextView((TextView) findViewById(R.id.tv_exercise_name));
        exerciseVisualization.setDescriptionTextView((TextView) findViewById(
                R.id.tv_exercise_description));

        exerciseDrawableGif.setGifDrawableParam((GifImageView) findViewById(R.id.gif_image_view),
                this);
        exerciseDrawableGif.setNoImage(R.drawable.noimage);

        exerciseTimer.setTimerVisualisation(timerVisualization);
        inbuiltExercises.addAlarm(av);
        inbuiltExercises.replenish(exercises, exerciseDrawableGif);

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
