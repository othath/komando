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

    public void clientScene(ActionEvent Action) throws Exception{
        Stage stage = (Stage) clientBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("client/res/logInForm.fxml"));
        Scene scene = new Scene(root, 1000,600);
        scene.getStylesheets().add(LogInController.class.getResource("res/LogInForm.css").toExternalForm());
        stage.setScene(scene);
    }
}
