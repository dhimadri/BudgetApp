package com.budgetapp;
import javafx.application.Application;
import javafx.stage.Stage;
public class MainApp extends Application{
    @Override
    public void start(Stage stage){
        stage.setTitle("Budget App");
        stage.setWidth(900);
        stage.setHeight(600);
        stage.show();
    }
    public static void main(String[]args){
        launch(args);
    }
}
