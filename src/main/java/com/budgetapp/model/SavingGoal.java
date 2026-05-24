package com.budgetapp.model;

public class SavingGoal {
    private int id;
    private String name;
    private double goal;
    private double currS;// current amount saved toward this goal, need to fix later.

    public SavingGoal(int id, String name, double goal, double currS) {
        this.id = id;
        this.name = name;
        this.goal = goal;
        this.currS = currS;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGoal() {
        return goal;
    }

    public double getCurrentSavings() {
        return currS;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nGoal: " + goal + "\nCurrent Savings:" + currS;
    }
}
