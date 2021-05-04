package mainApp.client;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import mainApp.client.userCls;

import java.net.URL;
import java.util.ResourceBundle;

public class homeClientController{
    /*@FXML private Button btn;
    @FXML private Label id;
    @FXML private Label first;
    @FXML private Label last;
    @FXML private Label email;*/
    @FXML private Button More;
    @FXML private Button Support;
    @FXML private Button Cart;
    @FXML private Button Settings;
    private boolean clickedOnce=false;
    userCls loggedClient = new userCls();

    public void initiateClient(userCls u){
        loggedClient.setClient(u);
    }

    /*public void btn(ActionEvent event){

        id.setText(String.format("%d",loggedClient.getId()));
        first.setText(loggedClient.getFirst());
        last.setText(loggedClient.getLast());
        email.setText(loggedClient.getEmail());

    }*/



    public void menuAnimation(double x1,double x2)
    {
        TranslateTransition supportTransition = new TranslateTransition();
        supportTransition.setByX(x1);
        RotateTransition supportRotate = new RotateTransition(Duration.millis(500));
        supportRotate.setByAngle(180);
        ParallelTransition supportParallel = new ParallelTransition(Support, supportTransition, supportRotate);
        supportParallel.statusProperty().addListener((obs,oldStatus,newStatus)-> More.setDisable(newStatus== Animation.Status.RUNNING));
        supportParallel.play();
        TranslateTransition settingsTransition = new TranslateTransition();
        settingsTransition.setByY(x1);
        RotateTransition settingsRotate = new RotateTransition(Duration.millis(500));
        settingsRotate.setByAngle(180);
        ParallelTransition settingsParallel = new ParallelTransition(Settings, settingsRotate, settingsTransition);
        settingsParallel.play();
        TranslateTransition cartTransition = new TranslateTransition();
        cartTransition.setByY(x2);
        cartTransition.setByX(x2);
        RotateTransition cartRotate = new RotateTransition(Duration.millis(500));
        cartRotate.setByAngle(180);
        ParallelTransition cartParallel = new ParallelTransition(Cart, cartRotate, cartTransition);
        cartParallel.play();
    }
    public void moreOption()
    {
        if(!clickedOnce) {
            menuAnimation(-100,-75);
            clickedOnce=true;
        }
        else
        {
            menuAnimation(100,75);
            clickedOnce=false;
        }
    }
    @FXML private Button userBtn;
    @FXML private VBox sideBar;

    private boolean clickedOnceSide=false;
    public void start_transition (){
        if (!clickedOnceSide){
            profileTransition(-250);
            clickedOnceSide=true;
        }
        else {
            profileTransition(250);
            clickedOnceSide=false;
        }
    }
    public void profileTransition(double transitionValue){
        TranslateTransition translate = new TranslateTransition(Duration.millis(700));
        translate.setDelay(Duration.millis(100));
        translate.setByX(transitionValue);
        translate.setNode(sideBar);
        translate.statusProperty().addListener((obs,oldStatus,newStatus)-> userBtn.setDisable(newStatus== Animation.Status.RUNNING));
        translate.play();
    }


}
