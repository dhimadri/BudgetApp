package com.budgetapp.service;
import com.budgetapp.dao.TransactionDAO;
import com.budgetapp.model.Transaction;
import com.budgetapp.dao.BudgetGoalDAO;
import com.budgetapp.model.BudgetGoal;
import java.util.*;
import java.time.LocalDate;

public class BudgetService {
    private TransactionDAO transactions;
    private BudgetGoalDAO budgetGoals;

    public BudgetService(TransactionDAO transactions, BudgetGoalDAO budgetGoals){
        this.transactions=transactions;
        this.budgetGoals=budgetGoals;
    }

    public double getTotalExpenseForMonth(){
        double total = 0;
        String month=LocalDate.now().toString().substring(0, 7);
        for (Transaction t : transactions.getAllTransaction()) {
            if (t.getType().equals("expense")&&t.getDate().startsWith(month)) {
                total += t.getAmount();
            }
        }
        return total;
    }

    public boolean isOverBudget(){
        for (BudgetGoal b :budgetGoals.getAllBudgetGoals()) {
            if(b.getMonth().equals(LocalDate.now().toString().substring(0, 7))&&b.getGoal()<getTotalExpenseForMonth()){
                return true;
            }
        }
        return false;
    }

    public String getBudgetWarning(){
        if(isOverBudget()){
            return  "Warning! You are over your budget for " + LocalDate.now().toString().substring(0, 7);
        }
        return "You are within your budget";
    }
}
