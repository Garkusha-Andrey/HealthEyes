package com.one.pilot.healtheyes.healtheyes.timer;

import android.widget.TextView;

import com.pascalwelsch.holocircularprogressbar.HoloCircularProgressBar;

/**
 * Created by Garkusha Andrey on 1/8/16.
 *
 * This class needs to visualize work of timer. Different
 * objects can be used to show current status of exercise:
 * circular progress bar, text filed.
 */
public class TimerVisualization implements ITimerVisualization{

    private TextView textView = null;
    private HoloCircularProgressBar progressBar = null;

    public void setTextView(TextView tv) {
        textView = tv;
    }
    public void setProgressBar(HoloCircularProgressBar pb) {
        progressBar = pb;
    }

    public void update(long msUntilFinished, long msDuration) {
        float progress = 0.0F;

        // +999 needs to make timer more natural
        if ( textView != null )
            textView.setText(secondsToStringMMSS(
                    (int) ((msUntilFinished + 999) / 1000)));

        if ( progressBar != null ) {
            progress = (float)(msDuration - msUntilFinished) / msDuration;
            progressBar.setProgress(progress);
        }
    }

    private String secondsToStringMMSS(long seconds) {
        String rv;

        int min = (int) seconds / 60;
        int sec = (int) seconds - (min*60);

        rv = String.format("%02d:%02d", min, sec);

        return rv;
    }
}
