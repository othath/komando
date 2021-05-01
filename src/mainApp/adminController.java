package mainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class adminController {

        @FXML
        private Button clientsInfo;
        @FXML private AnchorPane showInterface;
     @FXML private Button dashBoard;
    public void client(ActionEvent a) throws IOException {
            AnchorPane New= FXMLLoader.load(this.getClass().getResource("res/clientInfoInterface.fxml"));
            showInterface.getChildren().setAll(New);
            // Stage thisStage = (Stage)this.clientsInfo.getScene().getWindow();
            // thisStage.setScene(scene);
    }
    public void dashBoard(ActionEvent e) throws IOException{
        AnchorPane New= FXMLLoader.load(this.getClass().getResource("res/dashBoardInterface.fxml"));
        showInterface.getChildren().setAll(New);
    }
}
