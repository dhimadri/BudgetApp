package com.budgetapp.dao;
import java.sql.*;
import com.budgetapp.model.SavingGoal;
import java.util.ArrayList;
public class SavingGoalDAO {
    private Connection connection;
    public SavingGoalDAO(Connection c) {
        this.connection = c;
    }

    public void addSavingGoal(SavingGoal savingGoal) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO saving_goal (name, goal, currS) VALUES (?, ?, ?)");
            pstmt.setString(1, savingGoal.getName());
            pstmt.setDouble(2, savingGoal.getGoal());
            pstmt.setDouble(3, savingGoal.getCurrentSavings());
            pstmt.executeUpdate();
            System.out.println("saving Goal added!");
        } catch (Exception e) {
            System.out.println("Failed to add saving Goal" + e.getMessage());
        }
    }

    public ArrayList<SavingGoal> getAllSavingGoal() {
        ArrayList<SavingGoal> savingGoals = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM saving_goal");
            while (rs.next()) {
                SavingGoal savingGoal = new SavingGoal(rs.getInt("id"),  rs.getString("name"), rs.getDouble("goal"), rs.getDouble("currS"));
                savingGoals.add(savingGoal);
            }
        }
        catch (Exception e){
            System.out.println("Failed to get budget goals" + e.getMessage());
        }
        return savingGoals;
    }
}

