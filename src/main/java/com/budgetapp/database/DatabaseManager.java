package com.budgetapp.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DatabaseManager {
    private Connection connection;

    public void connect() {
        try {
            connection= DriverManager.getConnection("jdbc:sqlite:budgetapp.db");
            System.out.println("Connected!");
        }
        catch (Exception e) {
            System.out.println("Connection Failed"+e.getMessage());
        }
    }

    public void createTables(){
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS transactions (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    amount REAL,\n" +
                    "    type TEXT,\n" +
                    "    category TEXT,\n" +
                    "    date TEXT,\n" +
                    "    note TEXT\n" + ")");
            stmt.execute("CREATE TABLE IF NOT EXISTS categories (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name TEXT\n" + ")");
            stmt.execute("CREATE TABLE IF NOT EXISTS budget_goal (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    goal REAL,\n" +
                    "    month TEXT\n" + ")");
            stmt.execute("CREATE TABLE IF NOT EXISTS saving_goal (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    goal REAL,\n" +
                    "    currS REAL,\n" +
                    "    name TEXT\n" + ")");
            System.out.println("Tables created!");

        }
        catch (Exception e) {
            System.out.println("Connection Failed"+e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        DatabaseManager con= new DatabaseManager();
        con.connect();

        con.createTables();
    }
}
