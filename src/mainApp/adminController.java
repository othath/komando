package mainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminController implements Initializable {

        @FXML
        private Button clientsInfo;
        @FXML private AnchorPane showInterface;
     @FXML private Button dashBoard;
    public void client(ActionEvent a) throws IOException {
            AnchorPane New= FXMLLoader.load(this.getClass().getResource("res/clientInfoInterface.fxml"));
        clientsInfo.setStyle("-fx-background-color:teal");
            showInterface.getChildren().setAll(New);
            // Stage thisStage = (Stage)this.clientsInfo.getScene().getWindow();
        // thisStage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AnchorPane New= null;
        try {
            New = FXMLLoader.load(this.getClass().getResource("res/dashBoardInterface.fxml"));

        showInterface.getChildren().setAll(New);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dashBoard(ActionEvent e) throws IOException{
        AnchorPane New= FXMLLoader.load(this.getClass().getResource("res/dashBoardInterface.fxml"));
        showInterface.getChildren().setAll(New);
        dashBoard.setStyle("-fx-background-color:teal");
    }
}
