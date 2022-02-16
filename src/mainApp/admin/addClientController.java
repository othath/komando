package mainApp.admin;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import mainApp.client.dbConnector;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;



public class addClientController implements Initializable {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField Email;
    @FXML
    private TextField phoneNumber;
    @FXML
    private PasswordField password;
    @FXML
    private Button cancelBtn;
    @FXML
    private ChoiceBox choiceGender;
    public String gender[] = {"M", "F"};
    private boolean update;
  private int ID;
  private  dbConnector connect = new dbConnector();
   private Connection conDB = connect.getConnection();

    private String Sql=null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceGender.setItems(FXCollections.observableArrayList(gender));
    }


    public void inserttoDb(ActionEvent a) throws SQLException {
        if(firstName.getText().isEmpty() || lastName.getText().isEmpty()  || Email.getText().isEmpty()  || phoneNumber.getText().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter All DATA");
            alert.showAndWait();
        }
        else {
            if(update==false){
                Sql="INSERT INTO client(id,first,last,email,registring_date,password,Gender,phoneNumber) VALUES(?,?,?,?,?,?,?,?);";
                PreparedStatement stmnt = conDB.prepareStatement(Sql);
                stmnt.setInt(1, getLastId() + 1);
                stmnt.setString(5, getDate());
                stmnt.setString(2, firstName.getText());
                stmnt.setString(3, lastName.getText());
                stmnt.setString(4, Email.getText());
                stmnt.setString(6, password.getText());
                stmnt.setString(7, choiceGender());
                stmnt.setString(8, phoneNumber.getText());
                stmnt.executeUpdate();
                close();
            }
            else {
      Sql= "UPDATE client SET first=?,last=?,email=?,password=?,Gender=?,phoneNumber=? WHERE id="+ID+";";
                PreparedStatement stmnt = conDB.prepareStatement(Sql);
              //  stmnt.setInt(1, getId() + 1);
                stmnt.setString(5, getDate());
                stmnt.setString(1, firstName.getText());
                stmnt.setString(2, lastName.getText());
                stmnt.setString(3, Email.getText());
                stmnt.setString(4, password.getText());
                stmnt.setString(5, choiceGender());
                stmnt.setString(6, phoneNumber.getText());
                stmnt.executeUpdate();
                close();
    }}}
  /* public void update() throws SQLException {
        Sql="UPDATE client SET "+"first=?,last=?,email=?,registring_date=?,password=?,Gender=?,phoneNumber? WHERE id="+ID+";";
       if(firstName.getText().isEmpty() || lastName.getText().isEmpty()  || Email.getText().isEmpty()  || phoneNumber.getText().isEmpty() ){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText(null);
           alert.setContentText("Please Enter All DATA");
           alert.showAndWait();
       }
       else {
           PreparedStatement stmnt = conDB.prepareStatement(Sql);
           stmnt.setString(2, firstName.getText());
           stmnt.setString(3, lastName.getText());
           stmnt.setString(4, Email.getText());
          // stmnt.setString(5, getDate());
           stmnt.setString(6, password.getText());
           stmnt.setString(7, choiceGender());
           stmnt.setString(8, phoneNumber.getText());
           stmnt.executeUpdate();
           close();

   }  }*/
    public int getLastId() throws SQLException {
        Statement last = conDB.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet lastR = last.executeQuery("SELECT id FROM client WHERE id=(SELECT max(id) FROM client )");
        lastR.next();
        int lastId = lastR.getInt("id");
        return lastId;
    }
public void setUpdate(boolean a){
        update=a;
}
    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy--MM--dd");
        Date date = new Date();

        return formatter.format(date);

    }

    public void close(){
        Stage thisStage = (Stage) cancelBtn.getScene().getWindow();
        thisStage.close();

    }

    public String choiceGender() {
        String GenderSelected = (String) choiceGender.getValue();
  return GenderSelected;
    }

    public void setInfo(int id,String lastN,String firstname,String email,String pass,String gender,String Number){
        ID=id;
        firstName.setText(firstname);
        lastName.setText(lastN);
        password.setText(pass);
        Email.setText(email);
        choiceGender.getSelectionModel().select(gender);
        phoneNumber.setText(Number);    }
}

