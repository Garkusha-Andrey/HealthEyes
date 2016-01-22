package com.one.pilot.healtheyes.healtheyes.exercise;

import android.util.Log;

/**
 * Created by Garkusha Andrey on 1/22/16.
 * Exercise with visual content. Such content can be uploaded from
 * resource, assets, file, uri.
 * According to it setDrawable<type> should exist
 */
public class VisualExercise extends Exercise {

    private IExerciseDrawable exerciseDrawable = null;

    private int drawableResID = 0; // according to Resources#getIdentifier
    private String drawableAsset = null;
    private String drawableFile = null;
    private String drawableUri = null;


    private boolean isImgUploaded = false;

    protected VisualExercise() {
        super("", "", 0);
    };

    public VisualExercise(String name, String description, int duration) {
        super(name, description, duration);
    }

    public void setExerciseDrawable(IExerciseDrawable drawable) {
        exerciseDrawable = drawable;
    }

    public void setDrawableResID(int id) {
        drawableResID = id;
    }

    public void setDrawableAsset(String asset) {
        drawableAsset = asset;
    }

    public void setDrawableFile(String file) {
        drawableFile = file;
    }

    public void setDrawableUri(String uri) {
        drawableUri = uri;
    }

    @Override
    protected void init() {
        super.init();
        if (exerciseDrawable == null) {
            Log.e("VisualExercise", "Fail during _init_. Exercise drawable is not defined");
            return;
        }

        // Upload visual content. Priority is defined by sequence.
        isImgUploaded = true;

        if (drawableResID != 0) {
            exerciseDrawable.setResourceID(drawableResID);
        }
        else if ( drawableAsset != null) {
            exerciseDrawable.setResourceAsset(drawableAsset);
        }
        else if ( drawableFile != null) {
            exerciseDrawable.setResourceFile(drawableFile);
        }
        else if ( drawableUri != null) {
            exerciseDrawable.setResourceURI(drawableUri);
            // TODO: if it is downloaded, need to save gif and update exercise
        }
        else {
            Log.e("VisualExercise", "didn`t find drawable for exercise: " + getName());
            isImgUploaded = false;
        }

        exerciseDrawable.setDrawableState(IExerciseDrawable.ExerciseDrawableState.INIT);
    }

    @Override
    protected void start() {
        super.start();
        if (!isImgUploaded) {
            Log.e("VisualExercise", "Fail during _start_. Exercise drawable is not defined");
            return;
        }
        exerciseDrawable.setDrawableState(IExerciseDrawable.ExerciseDrawableState.START);
    }

    @Override
    protected void pause() {
        super.pause();
        if (!isImgUploaded) {
            Log.e("VisualExercise", "Fail during _pause_. Exercise drawable is not defined");
            return;
        }
        exerciseDrawable.setDrawableState(IExerciseDrawable.ExerciseDrawableState.PAUSE);
    }

    @Override
    protected void stop() {
        super.stop();
        if (!isImgUploaded) {
            Log.e("VisualExercise", "Fail during _stop_. Exercise drawable is not defined");
            return;
        }
        exerciseDrawable.setDrawableState(IExerciseDrawable.ExerciseDrawableState.STOP);
    }

    @Override
    protected void deinit() {
        super.deinit();
        exerciseDrawable.setDrawableState(IExerciseDrawable.ExerciseDrawableState.CLEAR);
    }
}
