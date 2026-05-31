package com.budgetapp.dao;
import java.sql.*;
import com.budgetapp.model.BudgetGoal;


import java.util.ArrayList;
public class BudgetGoalDAO {
    private Connection connection;
    public BudgetGoalDAO(Connection c) {
        this.connection = c;
    }

    public void addBudgetGoal(BudgetGoal budgetGoal) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO budget_goal (goal, month) VALUES (?, ?)");
            pstmt.setDouble(1, budgetGoal.getGoal());
            pstmt.setString(2, budgetGoal.getMonth());
            pstmt.executeUpdate();
            System.out.println("Budget Goal added!");
        } catch (Exception e) {
            System.out.println("Failed to add category" + e.getMessage());
        }
    }

    public ArrayList<BudgetGoal> getAllBudgetGoals() {
        ArrayList<BudgetGoal> budgetGoals = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM budget_goal");
            while (rs.next()) {
                BudgetGoal budgetGoal = new BudgetGoal(rs.getInt("id"),  rs.getString("month"), rs.getDouble("goal"));
                budgetGoals.add(budgetGoal);
            }
        }
        catch (Exception e){
            System.out.println("Failed to get budget goals" + e.getMessage());
        }
        return budgetGoals;
    }
}

