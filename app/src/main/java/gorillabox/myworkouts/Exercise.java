package gorillabox.myworkouts;

import java.util.ArrayList;

public class Exercise{
    private String name;
    private int serial;
    private ArrayList<Integer> repetitions;
    private ArrayList<Integer> weight;
    private ArrayList<Integer> restTime; //in seconds

    public Exercise(String name, int serial, ArrayList<Integer> repetitions, ArrayList<Integer> weight, ArrayList<Integer> restTime){
        this.name = name;
        this.serial = serial;
        this.repetitions = repetitions;
        this.weight = weight;
        this.restTime = restTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public ArrayList<Integer> getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(ArrayList<Integer> repetitions) {
        this.repetitions = repetitions;
    }

    public ArrayList<Integer> getWeight() {
        return weight;
    }

    public void setWeight(ArrayList<Integer> weight) {
        this.weight = weight;
    }

    public ArrayList<Integer> getRestTime() {
        return restTime;
    }

    public void setRestTime(ArrayList<Integer> restTime) {
        this.restTime = restTime;
    }
}
