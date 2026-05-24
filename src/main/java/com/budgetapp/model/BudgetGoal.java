package com.budgetapp.model;

public class BudgetGoal {
    private int id;
    private String month;
    private double goal;
    public BudgetGoal( int id, String month,double goal )
    {
        this.id=id;
        this.month =month;
        this.goal=goal;
    }
    public int getID(){
        return id;
    }
    public String  getMonth(){
        return month;
    }
    public double getGoal(){
        return goal;
    }
    @Override public String toString(){
        return "ID: "+id+"\nMonth: "+month+"\nGoal: "+goal;
    }
}
