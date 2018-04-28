package gorillabox.myworkouts;

import java.util.ArrayList;

public class Training {
    private ArrayList<Exercise> exercises;
    private String name;
    private ArrayList<Integer> days; //1 = lundi

    public Training(ArrayList<Exercise> exercises, String name, ArrayList<Integer> days){
        this.exercises = exercises;
        this.name = name;
        this.days = days;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getDays() {
        return days;
    }

    public void setDays(ArrayList<Integer> days) {
        this.days = days;
    }
}
