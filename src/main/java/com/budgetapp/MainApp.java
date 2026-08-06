package com.budgetapp;
import javafx.application.Application;
import javafx.stage.Stage;
import com.budgetapp.database.DatabaseManager;

public class MainApp extends Application{
    @Override
    public void start(Stage stage) {
        DatabaseManager db = new DatabaseManager();
        db.connect();
        db.createTables();
        stage.setScene(new HomeScreen(db.getConnection()).getScene(stage));
        stage.setTitle("Moneyfesting");
        stage.show();
    }
    public static void main(String[]args){
        launch(args);
    }
}
