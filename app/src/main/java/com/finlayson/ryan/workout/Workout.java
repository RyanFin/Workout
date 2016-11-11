package com.finlayson.ryan.workout;

/**
 * Created by Ryan on 11/11/2016.
 */

public class Workout {

    private String name;
    private String description;

    //parameterised constructor
    public Workout(String name, String description){
        this.name= name;
        this.description = description;
    }

    //create the workout array with name and description data
    public static final Workout[] workouts = {
            new Workout("The Limb Loosener","5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Workout("Core Agony","100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("The Wimp Special","5 Pull-ups\n10 Push-ups\n15 Squats"),
            new Workout("Strength and Length","500 Meter run\n21 x 1.5 pood kettlebell swings\n21 x Pull-ups")
    };

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return this.name;
    }

}
