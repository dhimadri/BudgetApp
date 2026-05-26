package com.budgetapp.dao;
import java.sql.*;
import com.budgetapp.model.Category;
import java.util.ArrayList;

public class CategoryDAO {
    private Connection connection;

    public CategoryDAO(Connection c) {
        this.connection = c;
    }

    public void addCategory(Category category) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO categories (name) VALUES (?)");
            pstmt.setString(1, category.getName());
            pstmt.executeUpdate();
            System.out.println("Category added!");
        } catch (Exception e) {
            System.out.println("Failed to add category" + e.getMessage());
        }
     }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categories");
            while (rs.next()) {
                Category category = new Category(rs.getInt("id"), rs.getString("name"));
                categories.add(category);
            }
        }
        catch (Exception e){
            System.out.println("Failed to get category" + e.getMessage());
        }
      return categories;
    }
}
