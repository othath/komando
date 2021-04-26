package mainApp.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import mainApp.client.userCls;

import java.net.URL;
import java.util.ResourceBundle;

public class homeClientController{
    @FXML private Button btn;
    @FXML private Label id;
    @FXML private Label first;
    @FXML private Label last;
    @FXML private Label email;
    userCls loggedClient = new userCls();

    public void initiateClient(userCls u){
        loggedClient.setClient(u);
    }

    public void btn(ActionEvent event){

        id.setText(String.format("%d",loggedClient.getId()));
        first.setText(loggedClient.getFirst());
        last.setText(loggedClient.getLast());
        email.setText(loggedClient.getEmail());

    }


}
