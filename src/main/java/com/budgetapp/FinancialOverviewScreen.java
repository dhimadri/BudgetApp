package com.budgetapp;
import com.budgetapp.service.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import java.sql.Connection;


public class FinancialOverviewScreen {
    private BalanceService balanceService;
    private BudgetService budgetService;
    private GoalService goalService;
    private Connection connection;

    public FinancialOverviewScreen(BalanceService balanceService, BudgetService budgetService, GoalService goalService, Connection connection) {
        this.balanceService = balanceService;
        this.budgetService = budgetService;
        this.goalService = goalService;
        this.connection=connection;
    }

    public Scene getScene(Stage stage) {

        Font pixel = Font.loadFont("file:///D:/projects/BudgetApp/src/main/resources/Press_Start_2P/PressStart2P-Regular.ttf", 12);
        Label warningLabel = new Label("");
        Label balanceLabel = new Label("Balance: " + balanceService.getNetBalance());
        Label incomeLabel = new Label("Income: " + balanceService.getTotalIncome());
        Label expenseLabel = new Label("Expenses: " + balanceService.getTotalExpense());

        balanceLabel.getStyleClass().add("balance-label");
        incomeLabel.getStyleClass().add("overview-label");
        expenseLabel.getStyleClass().add("overview-label");
        warningLabel.getStyleClass().add("warning-label");

        balanceLabel.setFont(Font.loadFont("file:///D:/projects/BudgetApp/src/main/resources/Press_Start_2P/PressStart2P-Regular.ttf", 24));
        incomeLabel.setFont(pixel);
        expenseLabel.setFont(pixel);
        warningLabel.setFont(pixel);

        warningLabel.setVisible(false);


        if(budgetService.isOverBudget()) {
            warningLabel.setText("⚠ WARNING: Over Budget!");
            warningLabel.setVisible(true);
        }
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-background-color: #000000; -fx-padding: 40px;");
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(warningLabel, balanceLabel, incomeLabel, expenseLabel);

        Button backBtn = new Button("< Back");
        backBtn.setFont(pixel);
        backBtn.setOnAction(e -> stage.setScene(new HomeScreen(connection).getScene(stage)));
        vbox.getChildren().add(backBtn);

        Scene scene = new Scene(vbox, 900, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        return scene;
    }
}
