package com.budgetapp.model;

public class SavingGoal {
    private int id;
    private String name;
    private double goal;
    private int priority;

    public SavingGoal(int id, String name, double goal, int priority) {
        this.id = id;
        this.name = name;
        this.goal = goal;
        this.priority = priority;
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

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nGoal: " + goal + "\nPriority:" + priority;
    }
}
