package com.finlayson.ryan.workout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change the color of the support bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(Color.parseColor("#4c0606"));
        }

        //change the actionbar color in java
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        /*
        //create a reference to the fragment-- HARDCODED :(
        WorkoutDetailFragment frag = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        frag.setWorkoutId(1);*/



    }

    //must override this interface method
    @Override
    public void itemClicked(long id) {

        //create a reference to the fragment container
        View fragContainer = findViewById(R.id.frag_container);

        //if the framelayout is there the device must be running layout in 'layout-large' folder
        //considering that the frame layout only exists for tablets
        if(fragContainer != null) {
            //The code to set the details for a particular workout from the listview indexed at 'id'
            //TODO: Add the fragment to the FrameLayout
            //detail fragment object created
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            //start initial changes
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //set the details to gather info about the clicked item in the ListView
            details.setWorkoutId(id);
            //replace the <FrameLayout> face with the fragment
            ft.replace(R.id.frag_container, details);
            //add to the back button stack, no "String name" required!!
            ft.addToBackStack(null);
            //add a fade transition
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            //commit the changes
            ft.commit();
        } else{
            //create an intent and from MainActivity to DetailActivity
            //device is running on a smaller mobile device as framelayout does not exist in 'layout' folder

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int)id); //cast to an integer
            startActivity(intent);

        }
    }
}
