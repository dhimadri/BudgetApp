package com.budgetapp.model;

public class Category {
    private int id;
    private String name;
    public Category( int id, String name)
    {
        this.id=id;
        this.name =name;
    }
    public int getID(){
        return id;
    }
    public String  getName(){
        return name;
    }
    @Override public String toString(){
        return "ID: "+id+"\nName: "+ name;
    }

}
