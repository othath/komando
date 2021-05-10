package mainApp.admin;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    @FXML
    private Button clientsInfo;
    @FXML
    private Button dashBoard;
    @FXML
    private Button orders;
    @FXML
    private Button inventory;
    @FXML
    private AnchorPane showInterface;
    @FXML
    private VBox menuBtns;
    @FXML

  private int count=1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AnchorPane New = null;
        try {
            New = FXMLLoader.load(this.getClass().getResource("res/dashBoardInterface.fxml"));
            dashBoard.setStyle("-fx-background-color:teal");
            showInterface.getChildren().setAll(New);
            menuBtns.setVisible(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnVisited(Button pressed, Button noPressed1, Button noPressed2, Button noPressed3) {
        pressed.setStyle("-fx-background-color:teal");
        noPressed1.setStyle("-fx-background-color:transparent");
        noPressed2.setStyle("-fx-background-color:transparent");
      noPressed3.setStyle("-fx-background-color:transparent");

    }

    public void dashBoard(ActionEvent e) throws IOException {
        AnchorPane New = FXMLLoader.load(this.getClass().getResource("res/dashBoardInterface.fxml"));
        showInterface.getChildren().setAll(New);
        btnVisited(dashBoard, clientsInfo, inventory, orders);
        menuBtns.setVisible(false);
        inventory.setLayoutY(340);
    }

    public void client(ActionEvent a) throws IOException {
        AnchorPane New = FXMLLoader.load(this.getClass().getResource("res/clientInfoInterface.fxml"));
        btnVisited(clientsInfo, dashBoard, inventory, orders);
        showInterface.getChildren().setAll(New);
        menuBtns.setVisible(false);
        inventory.setLayoutY(340);

        /* Stage thisStage = (Stage)this.clientsInfo.getScene().getWindow();
        thisStage.setScene(scene);*/
    }
public int countCliks(){
        orders.setOnMouseClicked((mouseEvent) -> {
            count++;
        });

        return count;
    };
  public void inventory(ActionEvent c){
      btnVisited(inventory, clientsInfo, dashBoard, orders);
      menuBtns.setVisible(false);
      inventory.setLayoutY(340);

  }
    public void animationMenuBtns() {
        menuBtns.setVisible(true);
        TranslateTransition transition = new TranslateTransition();
        transition.setByX(220);
        transition.setFromX(0);
        transition.setDuration(Duration.seconds(1));
        transition.setNode(menuBtns);
        transition.play();
        /*transition.setAutoReverse(true);
        return transition;*/
    }

    public void order(ActionEvent a) {
       // countCliks();

  btnVisited(orders,dashBoard,clientsInfo,inventory);
       if(!menuBtns.isVisible()){
           animationMenuBtns();
         /*Translate translate =new Translate();
           translate.setX(x);
           menuBtns.getTransforms().add(translate);*/
           //inventory.setStyle("-fx-background-color:GREEN");
           inventory.setLayoutY(450);

       }
       else {
           menuBtns.setVisible(false);
           inventory.setLayoutY(340);


       }
    }
    /*
    public void translateMenuAndInventory(){
        inventory.setStyle("-fx-background-color:red");
        Translate translate =new Translate();
      //  translate.setX(-150);
        menuBtns.setVisible(false);
        menuBtns.getTransforms().add(translate);

    }
*/
}



