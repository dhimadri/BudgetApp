package com.budgetapp;
import javafx.application.Application;
import javafx.stage.Stage;
public class MainApp extends Application{
    @Override
    public void start(Stage stage) {
        HomeScreen homeScreen = new HomeScreen();
        stage.setScene(homeScreen.getScene(stage));
        stage.setTitle("Moneyfesting");
        stage.show();
    }
    public static void main(String[]args){
        launch(args);
    }
}
