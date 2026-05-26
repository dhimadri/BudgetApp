package com.budgetapp.dao;
import java.sql.Connection;
import java.sql.*;
import com.budgetapp.model.Transaction;
import java.util.ArrayList;

public class TransactionDAO {
    private Connection connection;

    public TransactionDAO(Connection c) {
        this.connection = c;
    }

    public void addTransaction(Transaction transaction) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO transactions (amount, type, category, date, note) VALUES (?, ?, ?, ?, ?)");
            pstmt.setDouble(1, transaction.getAmount());
            pstmt.setString(2, transaction.getType());
            pstmt.setString(3, transaction.getCategory());
            pstmt.setString(4, transaction.getDate());
            pstmt.setString(5, transaction.getNote());
            pstmt.executeUpdate();
            System.out.println("transaction added!");
        } catch (Exception e) {
            System.out.println("Failed to add transaction" + e.getMessage());
        }
    }

    public ArrayList<Transaction> getAllTransaction() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM transactions");
            while (rs.next()) {
                Transaction transaction = new Transaction(rs.getInt("id"), rs.getDouble("amount"), rs.getString("type"), rs.getString("category"), rs.getString("date"), rs.getString("note"));
                transactions.add(transaction);
            }
        } catch (Exception e) {
            System.out.println("Failed to get transaction" + e.getMessage());
        }
        return transactions;
    }
}