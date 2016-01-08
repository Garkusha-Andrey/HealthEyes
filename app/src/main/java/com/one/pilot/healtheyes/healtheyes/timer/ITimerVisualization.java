package com.one.pilot.healtheyes.healtheyes.timer;

/**
 * Created by Garkusha Andrey on 1/8/16.
 *
 * This is an interface for timer visualisation. Visualization needs
 * to make work of timer more representative.
 */
public interface ITimerVisualization {
    public void update(long msUntilFinished, long msDuration);
}
