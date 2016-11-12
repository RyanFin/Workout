

package com.finlayson.ryan.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {


    public WorkoutListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //create an array of NAMES
        String[] names = new String[Workout.workouts.length];

        //get the name of each workout within the workout array
        // and place them in an array called 'names'
        for(int i = 0; i < names.length; i++){
            //for this iteration place the name from 'workouts' array in 'names' array
            names[i] = Workout.workouts[i].getName();
        }


        //create arrayAdapter to function as "bridge" between the listFragment and the array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1,names
        );
        setListAdapter(adapter);

        return super.onCreateView(inflater,container,savedInstanceState);
    }

}
