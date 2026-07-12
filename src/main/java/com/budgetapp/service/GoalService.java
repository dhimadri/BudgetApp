package com.budgetapp.service;
import com.budgetapp.dao.SavingGoalDAO;
import com.budgetapp.model.SavingGoal;
import java.util.*;
public class GoalService {
    private SavingGoalDAO savingGoals;
    private BudgetService budgetService;

    public GoalService(SavingGoalDAO savingGoals, BudgetService budgetService){
        this.savingGoals=savingGoals;
        this.budgetService=budgetService;
    }


}
