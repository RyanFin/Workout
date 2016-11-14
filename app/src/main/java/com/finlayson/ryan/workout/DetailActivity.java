package com.finlayson.ryan.workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    //create the key value for the intent message
    public static String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //retrieve the intent
        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);

        //reference the workoutDetailFragment
        WorkoutDetailFragment workoutDetailFragment = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        workoutDetailFragment.setWorkoutId(workoutId);
    }
}
