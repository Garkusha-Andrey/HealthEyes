package com.one.pilot.healtheyes.healtheyes.timer;

import android.os.CountDownTimer;

import com.one.pilot.healtheyes.healtheyes.exercise.Exercise;

/**
 * Created by Garkusha Andrey on 1/7/16.
 *
 * This class need to start an exercise in scope of timer.
 * For use it, need to set an exercise and start timer. Add
 * link to visualisation class to make count down of timer
 * more representative.
 */
public class ExerciseTimer {

    public static enum TimerStatus {READY, RUNNING, FINISHED, STOPPED};

    private CountDownTimer timer;
    private Exercise exercise = null;
    private ITimerVisualization timerVisualization = null;
    private TimerStatus status;

    private long mTimerInterval = 70; // This is a number, that was defined empirically

    public int start() {
        if (status == TimerStatus.RUNNING) return 0;

        status = TimerStatus.RUNNING;
        if (exercise != null) exercise.start();
        timer.start();
        return 0;
    }

    public int pause() {
        // TODO: not sure that it should be implemented
        return 1;
    }

    public int stop() {
        status = TimerStatus.STOPPED;
        timer.cancel();
        return 0;
    }

    public void init(Exercise cur_exercise) {
        exercise = cur_exercise;
        final long duration = exercise.getDuration() * 1000;

        // define timer class that will handle timer functionality
        timer = new CountDownTimer(duration, mTimerInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                status = TimerStatus.RUNNING;
                if (timerVisualization != null )
                    timerVisualization.update(millisUntilFinished, duration);
            }

            @Override
            public void onFinish() {
                status = TimerStatus.FINISHED;
                exercise.stop();

                if (timerVisualization != null )
                    timerVisualization.update(0, duration);
            }
        };

        if ( timerVisualization != null)
            timerVisualization.update(duration, duration);

        status = TimerStatus.READY;
    }

    public void setTimerVisualisation(ITimerVisualization tv) { timerVisualization = tv; }
}
