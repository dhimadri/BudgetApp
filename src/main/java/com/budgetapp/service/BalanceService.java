package com.budgetapp.service;
import com.budgetapp.dao.TransactionDAO;
import com.budgetapp.model.Transaction;
import java.util.*;
public class BalanceService {
    TransactionDAO transactions;

    public BalanceService(TransactionDAO transactions){
        this.transactions=transactions;
    }

    public double getTotalIncome() {
        double totalI = 0;
        for (Transaction t : transactions.getAllTransaction()) {
            if (t.getType().equals("income")) {
                totalI += t.getAmount();
            }
        }
        return totalI;
    }

    public double getTotalExpense() {
        double totalE = 0;
        for (Transaction t : transactions.getAllTransaction()) {
            if (t.getType().equals("expense")) {
                totalE += t.getAmount();
            }
        }
        return totalE;
    }

    public double getNetBalance(){
        return getTotalIncome()-getTotalExpense();
    }

}
