package mainApp.admin;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mainApp.client.dbConnector;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

// String price=res.getNString()
public class clientInterfaceController implements Initializable {
    @FXML private TableColumn<clientInfo,String> nameCol;
    @FXML private TableColumn<clientInfo,String> emailCol;
    @FXML private TableView<clientInfo> table;
    @FXML private TableColumn<clientInfo,String> GenderCol;
    @FXML private TableColumn<clientInfo,String> phoneCol;
    @FXML private TableColumn<clientInfo,CheckBox> selectCol;
  @FXML private CheckBox selectAll;
    private dbConnector connect = new dbConnector();
    private Connection conDB = connect.getConnection();
    private ObservableList<clientInfo> data= FXCollections.observableArrayList();
    private ObservableList<clientInfo> item ;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectAll();
        loadData();
        select();
    }
    public void selectAll(){
        selectAll.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
              item= table.getItems();
      for(clientInfo i:item) {
          if (selectAll.isSelected()) i.getSelect().setSelected(true);
          else i.getSelect().setSelected(false);
      }
            }
        });
    }
    public void modify() throws IOException, SQLException {
     /* table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<clientInfo>() {
            @Override
            public void changed(ObservableValue<? extends clientInfo> observableValue, clientInfo clientInfo, clientInfo t1) {
                clientInfo client = table.getSelectionModel().getSelectedItem();
                client.getSelect().setSelected(true);
                System.out.println(client.getPhoneNumber());
                if(!client.getSelect().isSelected()){
                    client.getSelect().setSelected(false);
                    Alert a=new Alert(Alert.AlertType.ERROR);
                    a.show();
                }
        }

        item = table.getItems();

        if(table.getSelectionModel().isSelected(countSelect)){
        for (clientInfo i : item) {
            if (i.getSelect().isSelected()) {
                countSelect++;
                System.out.println(i.getPhoneNumber());;

            } }}
        else {
               // i.getSelect().setSelected(false);
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.show();

            }*/
        clientInfo client=table.getSelectionModel().getSelectedItem();

        FXMLLoader loader= new FXMLLoader(this.getClass().getResource("res/AddView.fxml"));
        Parent root= loader.load();
        addClientController modify=loader.getController();
        modify.setUpdate(true);
        modify.setInfo(getId(client.getEmail(),client.getName()),client.getName(),client.getName(),client.getEmail(),client.getPassword(),client.getGender(),client.getPhoneNumber());
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();

        }
    public int getId(String e,String f) throws SQLException {
        Statement last = conDB.createStatement();
        String query="SELECT * FROM client WHERE first='" +f +"' and email='"+e+"';";
        ResultSet lastR = last.executeQuery(query);
        if(lastR.next()){;
            lastR.getInt("id");}
        return lastR.getInt("id");

    }
    public void select() {

        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<clientInfo>() {
            @Override
            public void changed(ObservableValue<? extends clientInfo> observableValue, clientInfo clientInfo, clientInfo t1) {
                clientInfo client = table.getSelectionModel().getSelectedItem();
                client.getSelect().setSelected(true);
            }
        });

    }
    public void loadData(){
        Statement stmt = null;

        try {
            stmt = conDB.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "select * from client";
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()){
            int id=res.getInt("id");
            String first=res.getString("first");
            String last=res.getString("last");
            String email=res.getString("email");
           // String password=res.getString("password");
            String date=res.getString("registring_date");
            String gender=res.getString("Gender");
            String phoneNumber=res.getString("phoneNumber");

            data.add(new clientInfo(first,email,phoneNumber,date,gender));

            }
            emailCol.setCellValueFactory(new PropertyValueFactory<clientInfo,String>("email"));
            nameCol.setCellValueFactory(new PropertyValueFactory<clientInfo,String>("name"));
            phoneCol.setCellValueFactory(new PropertyValueFactory<clientInfo,String>("phoneNumber"));
            GenderCol.setCellValueFactory(new PropertyValueFactory<clientInfo,String>("gender"));
            selectCol.setCellValueFactory(new PropertyValueFactory<clientInfo,CheckBox>("select"));
            table.setItems(data);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void newClient(ActionEvent newClient) throws IOException {
        FXMLLoader loader= new FXMLLoader(this.getClass().getResource("res/AddView.fxml"));
        Parent root= loader.load();
        addClientController newclient=loader.getController();
        newclient.setUpdate(false);
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();




    }

}

