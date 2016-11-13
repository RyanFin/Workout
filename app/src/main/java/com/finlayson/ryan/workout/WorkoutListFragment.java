

package com.finlayson.ryan.workout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {

    //create the interface
    public static interface WorkoutListListener{
        void itemClicked(long id);
    }

    //create an instance of the listener
    private WorkoutListListener listener;

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (WorkoutListListener) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //use interface method for the listener
        listener.itemClicked(id);
    }
}
