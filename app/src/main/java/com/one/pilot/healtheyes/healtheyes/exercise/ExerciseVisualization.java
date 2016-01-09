package com.one.pilot.healtheyes.healtheyes.exercise;

import android.widget.TextView;

/**
 * Created by Garkusha Andrey on 1/9/16.
 *
 * This class need to show new exercise at the screen.
 */
public class ExerciseVisualization {
    private TextView exerciseName = null;
    private TextView exerciseDescription = null;

    public void update(Exercise exercise) {
        if (exerciseName != null)
            exerciseName.setText( "Exercise: " + exercise.getName() );
        if (exerciseDescription != null)
            exerciseDescription.setText( exercise.getDescription() );
    }

    public void setNameTextView(TextView tv) {
        exerciseName = tv;
    }

    public void setDescriptionTextView(TextView tv) {
        exerciseDescription = tv;
    }
}
