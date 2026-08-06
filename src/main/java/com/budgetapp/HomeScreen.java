package com.budgetapp;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import java.sql.Connection;
import com.budgetapp.dao.*;
import com.budgetapp.service.*;


public class HomeScreen {
    private Connection connection;

    public HomeScreen(Connection connection) {
        this.connection = connection;
    }

    public Scene getScene(Stage stage) {
        Font pixel = Font.loadFont("file:///D:/projects/BudgetApp/src/main/resources/Press_Start_2P/PressStart2P-Regular.ttf", 14);
        System.out.println("Font loaded: " + pixel);
        Label title = new Label("MONEYFESTING");
        Button btn1 = new Button("Financial Overview");
        Button btn2 = new Button("Transactions");
        Button btn3 = new Button("Catagories");
        Button btn4 = new Button("Goals");

        btn1.setFont(pixel);
        btn2.setFont(pixel);
        btn3.setFont(pixel);
        btn4.setFont(pixel);
        title.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 24));

        btn1.setOnAction(e -> {
            TransactionDAO transactionDAO = new TransactionDAO(connection);
            BudgetGoalDAO budgetGoalDAO = new BudgetGoalDAO(connection);
            SavingGoalDAO savingGoalDAO = new SavingGoalDAO(connection);
            BalanceService balanceService = new BalanceService(transactionDAO);
            BudgetService budgetService = new BudgetService(transactionDAO, budgetGoalDAO);
            GoalService goalService = new GoalService(savingGoalDAO, balanceService);
            FinancialOverviewScreen overview = new FinancialOverviewScreen(balanceService, budgetService, goalService, connection);
            stage.setScene(overview.getScene(stage));
        });

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(title,btn1, btn2, btn3, btn4);
        Scene scene=new Scene(vbox, 900, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        return scene;
    }
}
