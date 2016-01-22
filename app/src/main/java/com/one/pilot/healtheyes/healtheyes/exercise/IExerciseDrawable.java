package com.one.pilot.healtheyes.healtheyes.exercise;

import android.support.annotation.IdRes;


/**
 * Created by Garkusha Andrey on 1/22/16.
 */
public interface IExerciseDrawable {
    enum ExerciseDrawableState {INIT, START, PAUSE, STOP, CLEAR};

    public int setDrawableState(ExerciseDrawableState exerciseDrawableState);
    public int setResourceID(@IdRes int id);
    public int setResourceAsset(String name);
    public int setResourceFile(String path);
    public int setResourceURI(String uri);
}
