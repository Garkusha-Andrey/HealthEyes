package com.one.pilot.healtheyes.healtheyes.exercise.view;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;

import com.one.pilot.healtheyes.healtheyes.exercise.IExerciseDrawable;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Garkusha Andrey on 1/22/16.
 */
public class ExerciseDrawableGif implements IExerciseDrawable {
    private GifImageView gifImageView = null;
    private GifDrawable gifDrawable = null;
    private GifDrawable gifNoImage = null;
    private Context context = null;

    public void setGifDrawableParam(GifImageView view, Context context) {
        this.gifImageView = view;
        this.context = context;
    }

    public void setNoImage(@IdRes int id) {
        try {
            gifNoImage = new GifDrawable(context.getResources(), id);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    @Override
    public int setDrawableState(ExerciseDrawableState exerciseDrawableState) {
        switch (exerciseDrawableState) {
            case INIT:
                init();  break;
            case START:
                start(); break;
            case PAUSE:
                pause(); break;
            case STOP:
                stop(); break;
            case CLEAR:
                clear(); break;
            default:
                Log.e("ExerciseDrawableGif", "Unknown exercise drawable state "
                        + exerciseDrawableState);
                return 1;
        }
        return 0;
    }

    @Override
    public int setResourceID(@IdRes int id) {
        try {
            gifDrawable = new GifDrawable(context.getResources(), id);
        } catch (IOException e) {
            Log.e("ExerciseDrawableGif", "setResourceID catch IOException exeption: " + e.getMessage());
            return 1;
        }

        return 0;
    }

    @Override
    public int setResourceAsset(String name) {
        try {
            gifDrawable = new GifDrawable(context.getAssets(), name);
        } catch (IOException e) {
            Log.e("ExerciseDrawableGif", "setResourceAsset catch IOException exeption: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public int setResourceFile(String path) {
        try {
            gifDrawable = new GifDrawable(path);
        } catch (IOException e) {
            Log.e("ExerciseDrawableGif", "setResourceFile catch IOException exeption: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public int setResourceURI(String uri) {
        Uri source = Uri.parse(uri);
        try {
            gifDrawable = new GifDrawable(context.getContentResolver(), source);
        } catch (IOException e) {
            Log.e("ExerciseDrawableGif", "setResourceURI catch IOException exeption: " + e.getMessage());
        }
        return 0;
    }

    private void init() {
        if (gifDrawable == null) {
            Log.e("ExerciseDrawableGif", "Fail during _init_. Exercise drawable is empty");
            setUnknownImg();
            return;
        }

        gifDrawable.setVisible(true, false);
        gifImageView.setImageDrawable(gifDrawable);
        gifDrawable.stop();
    }

    private void start() {
        if (gifDrawable == null) {
            Log.e("ExerciseDrawableGif", "Fail during _start_. Exercise drawable is empty");
            return;
        }

        if (gifDrawable.isPlaying() == false)
            gifDrawable.start();
    }

    private void pause() {
        if (gifDrawable == null) {
            Log.e("ExerciseDrawableGif", "Fail during _start_. Exercise drawable is empty");
            return;
        }

        if (gifDrawable.isPlaying() == true)
            gifDrawable.pause();
    }

    private void stop() {
        if (gifDrawable == null) {
            Log.e("ExerciseDrawableGif", "Fail during _start_. Exercise drawable is empty");
            return;
        }

        if (gifDrawable.isPlaying() == true)
            gifDrawable.pause();
        gifDrawable.seekToFrame(0);
    }

    private void clear() {
        gifImageView.setImageDrawable(null);
        gifDrawable = null;
    }

    private void setUnknownImg() {
        if (gifNoImage != null) {
            gifNoImage.setVisible(true, false);
            gifImageView.setImageDrawable(gifNoImage);
        }
    }
}
