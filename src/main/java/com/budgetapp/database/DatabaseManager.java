package com.budgetapp.database;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseManager {
    private Connection connection;

    public void connect() {
        try {
            connection= DriverManager.getConnection("jdbc:sqlite:budgetapp.db");
            System.out.println("Connected!");
        } catch (Exception e) {
            System.out.println("Connection Failed"+e.getMessage());
        }
    }
    public static void main(String[] args) {
        DatabaseManager con= new DatabaseManager();
        con.connect();
    }
}
