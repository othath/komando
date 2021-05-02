package mainApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mainApp.client.dbConnector;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

// String price=res.getNString();
public class clientInterfaceController implements Initializable {
    @FXML private TableColumn<clientInfo,String> nameCol;
    @FXML private TableColumn<clientInfo,String> emailCol;
    @FXML private TableView<clientInfo> table;
    @FXML private TableColumn<clientInfo,String> pass;
    @FXML private TableColumn<clientInfo,String> dateRe;
    @FXML private Label l;
    dbConnector connect = new dbConnector();
    Connection conDB = connect.getConnection();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Statement stmt = null;
        try {
            stmt = conDB.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "select * from client";
        ResultSet res = stmt.executeQuery(sql);
        res.next();
        int id=res.getInt("id");
        String first=res.getString("first");
        String last=res.getString("last");
        String email=res.getString("email");
        String password=res.getString("password");
        String date=res.getString("registring_date");
        ObservableList<clientInfo> data= FXCollections.observableArrayList(new clientInfo(first,password,email,date),new clientInfo("test","sss","s","s"),new clientInfo("test","sss","s","s"));

       emailCol.setCellValueFactory(new PropertyValueFactory<clientInfo,String>("email"));
       nameCol.setCellValueFactory(new PropertyValueFactory<clientInfo,String>("name"));
        pass.setCellValueFactory(new PropertyValueFactory<clientInfo,String>("password"));
        dateRe.setCellValueFactory(new PropertyValueFactory<clientInfo,String>("registring_date"));
        table.setItems(data);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //emailCol.se(email);
      //  table.getItems().addAll("a","06",'a',"M");



    }
}

