package mainApp;


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
        Parent loader = FXMLLoader.load(this.getClass().getResource("admin/res/adminInterface.fxml"));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Komando");
        Scene appLoader = new Scene(loader, 800,500);
        primaryStage.setScene(appLoader);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
