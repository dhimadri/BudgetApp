package com.budgetapp.service;
import java.util.*;
import com.budgetapp.dao.SavingGoalDAO;
import com.budgetapp.model.SavingGoal;

public class GoalService {
    private SavingGoalDAO savingGoals;
    private BalanceService balanceService;

    public GoalService(SavingGoalDAO savingGoals, BalanceService balanceService){
        this.savingGoals=savingGoals;
        this.balanceService =balanceService;
    }
    public double getTotalTarget(){
        double total=0;
        for(SavingGoal s: savingGoals.getAllSavingGoal()){
            total+=s.getGoal();
        }
        return total;
    }

    public double getOverallProgress(){
        double progress=(balanceService.getNetBalance()/getTotalTarget())*100;
        return progress;
    }

    public ArrayList<String> getGoalStatus() {

        ArrayList<SavingGoal> sorted = new ArrayList<>(savingGoals.getAllSavingGoal());
        sorted.sort((a, b) -> a.getPriority() - b.getPriority());

        ArrayList<String> statuses = new ArrayList<>();
        double runningBalance = balanceService.getNetBalance();

        for (SavingGoal s : sorted) {
            if (runningBalance >= s.getGoal()) {

                statuses.add("✅ " + s.getName() + " — Complete!");

                runningBalance -= s.getGoal();
            } else {

                statuses.add("❌ " + s.getName() + " — Need " + (s.getGoal() - runningBalance) + " more");
                break;
            }
        }
        return statuses;
    }
}

