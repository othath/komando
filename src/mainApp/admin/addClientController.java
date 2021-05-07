package mainApp.admin;
import javafx.scene.control.PasswordField;
import mainApp.client.dbConnector;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class addClientController {

    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField Email;
    @FXML private TextField phoneNumber;
    @FXML private TextField Gender;
  @FXML private PasswordField password;


    dbConnector connect = new dbConnector();
    Connection conDB = connect.getConnection();

    public void inserttoDb() throws SQLException {

        String Sql="INSERT INTO client(id,first,last,email,registring_date,password)" + "VALUES(?,?,?,?,?,?)";
        PreparedStatement stmnt=conDB.prepareStatement(Sql);
      stmnt.setInt(1,getLastId()+1);
        stmnt.setString(2,firstName.getText());
        stmnt.setString(3,lastName.getText());
         stmnt.setString(4,Email.getText());
         stmnt.setString(5,getDate());
         stmnt.setString(6,password.getText());
         stmnt.executeUpdate();

    }
    public int getLastId() throws SQLException {
        Statement last= conDB.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet lastR=last.executeQuery("SELECT id FROM client WHERE id=(SELECT max(id) FROM client )");
       lastR.next();
        int lastId= lastR.getInt("id");
        return lastId;
    }
  public String getDate(){
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy--MM--dd");
      Date date=new Date();

      return   formatter.format(date);

  }
}
