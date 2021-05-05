package mainApp.client;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaptopsController {
    @FXML private FlowPane products;
    dbConnector db = new dbConnector();
    Connection connectDB = db.getConnection();
    String query = "SELECT count(product_id) FROM product;";
    Statement s = connectDB.createStatement();
    ResultSet output = s.executeQuery(query);

    public LaptopsController() throws SQLException {
    }

    public void initialize() throws Exception {
        query = "SELECT image, title, price from product;";
        output = s.executeQuery(query);
        while(output.next()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("res/cardTemplate.fxml"));
                VBox v = loader.load();
                cartTemplateController controller = loader.getController();
                controller.populate(output.getString("image"), output.getString("title"), output.getString("price"));
                products.getChildren().add(v);
        }
     }
}
