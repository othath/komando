package sample;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {

    @FXML
    private TextField username;
    @FXML
    private TextField pass;
    @FXML
    private Text message;

    public void ConnectBtn(ActionEvent event){
        dbConnector connect = new dbConnector();
        Connection connectDB = connect.getConnection();

        String connectQuery = "SELECT user, password FROM users WHERE user='" + username.getText() + "' and password='" + pass.getText() + "';";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);
            while(queryOutput.next()){
                if (queryOutput.getString("user") != "") {
                    message.setText("Connection success");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
