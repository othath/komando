package mainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import mainApp.client.dbConnector;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dashBoardController {
   /* dbConnector connect=new dbConnector();
    Connection conDB = connect.getConnection();
    Statement stmt=conDB.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    String sql="select Price from product";
    ResultSet res=stmt.executeQuery(sql);
   // String price=res.getNString();

    public dashBoardController() throws SQLException {
    }*/
    @FXML private
   Label numberOrder;
    public void test(ActionEvent a) throws IOException{numberOrder.setText("pf");
    }

    public void test(javafx.event.ActionEvent a) {numberOrder.setText("pf");
    }
}
