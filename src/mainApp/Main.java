package mainApp;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        Parent loader = FXMLLoader.load(getClass().getResource("res/loader.fxml"));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Komando");
        Scene appLoader = new Scene(loader, 300,350);
        primaryStage.setScene(appLoader);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
