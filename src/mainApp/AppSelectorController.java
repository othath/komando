package mainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mainApp.client.LogInController;

public class AppSelectorController {
    @FXML private Button clientBtn;
    @FXML private Button adminBtn;

    public void clientScene(ActionEvent Action) throws Exception{

        Stage stage = (Stage) clientBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("client/res/logInForm.fxml"));
        Scene scene = new Scene(root, 1000,600);
        scene.getStylesheets().add(LogInController.class.getResource("res/LogInForm.css").toExternalForm());
        stage.setScene(scene);
    }
    public void adminScene(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("admin/res/adminInterface.fxml"));
        Scene scene=new Scene(root, 800, 480);
        scene.getStylesheets().add(getClass().getResource("admin/res/adminInterface.css").toExternalForm());
        Stage thisStage = (Stage) adminBtn.getScene().getWindow();
        thisStage.setScene(scene);
        //thisStage.show();
    }
}
