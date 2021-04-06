package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        Parent root = FXMLLoader.load(getClass().getResource("LogInForm.fxml"));
        LogInController ctr = new LogInController();
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root,1000,600);
        scene.getStylesheets().add("sample/logInForm.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
