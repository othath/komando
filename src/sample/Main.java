package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

/*        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setTitle("El Comundo");

        Text title = new Text("Login Form");

        Label userName = new Label("Username : ");
        userTextField = new TextField();
        Label password = new Label("Password : ");
        PasswordField pwBox = new PasswordField();

        grid.add(title, 0,0);
        grid.add(userName, 0,1);
        grid.add(userTextField, 1,1);
        grid.add(password, 0,2);
        grid.add(pwBox, 1,2);

        grid.setGridLinesVisible(false);

        Button  btn = new Button("Log in");
        HBox hbtn = new HBox(10);
        hbtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbtn.getChildren().add(btn);
        grid.add(hbtn,1,4);

        Text message = new Text();
        grid.add(message,1,5);

        btn.setOnAction(event -> {
            message.setText("test Login");
        });
        primaryStage.setScene(scene);
        primaryStage.show();*/



    }


    public static void main(String[] args) {
        launch(args);
    }
}
