package sample;

import java.util.*;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LogInController {

    /*public void ConnectBtn(ActionEvent event){
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
    }*/
    @FXML private VBox firstColumn;
    @FXML private VBox secondColumn;
    @FXML private Text title;
    @FXML private Text question;
    @FXML private Text joinNow;
    @FXML private Text forgotPassword;
    @FXML private TextField fullNameField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Button signInOrUp;
    private boolean clickedOnce=false;

    //this function starts the animation when "join now is clicked"
    @FXML public void startAnimation()
    {
        if(!clickedOnce) {
            firstColumnAnimation(-410);
            secondColumnAnimation(600);
            showContent(true,"Sign Up :","Already have an account ?","LogIn",20);
            clickedOnce = true;
        }
        else
        {
            firstColumnAnimation(410);
            secondColumnAnimation(-600);
            showContent(false,"Sign In :","New to Komando ?","Join Now",30);
            clickedOnce=false;
        }
    }

    //animation for firstColumn which contains login/sign up form
    public void firstColumnAnimation(double translateValue)
    {
        TranslateTransition translate = new TranslateTransition(Duration.millis(1000));
        translate.setDelay(Duration.millis(200));
        translate.setByX(translateValue);
        translate.setNode(firstColumn);
        translate.statusProperty().addListener((obs,oldStatus,newStatus)-> joinNow.setDisable(newStatus== Animation.Status.RUNNING));
        translate.play();
    }

    //show the hidden content in the first column (full name field,confirm password field) and edit some content
    public void showContent(boolean hidden,String Title,String Question,String joinOrLog,double spacing)
    {
        PauseTransition pause = new PauseTransition(Duration.millis(650));
        pause.setOnFinished(event -> {
            fullNameField.setVisible(hidden);
            confirmPasswordField.setVisible(hidden);
            forgotPassword.setVisible(!hidden);
            fullNameField.setManaged(hidden);
            confirmPasswordField.setManaged(hidden);
            forgotPassword.setManaged(!hidden);
            question.setText(Question);
            joinNow.setText(joinOrLog);
            title.setText(Title);
            signInOrUp.setText(Title.substring(0,Title.length()-2));
            firstColumn.setSpacing(spacing);
        });
        pause.play();
    }

    //animation for secondColumn which contains the name of the application
    public void secondColumnAnimation(double translateValue)
    {
        ScaleTransition scale = new ScaleTransition(Duration.millis(625));
        scale.setToX(1.3);
        scale.setCycleCount(2);
        scale.setAutoReverse(true);
        TranslateTransition translate = new TranslateTransition(Duration.millis(1200));
        translate.setByX(translateValue);
        ParallelTransition p1 = new ParallelTransition(secondColumn,scale,translate);
        p1.statusProperty().addListener((obs,oldStatus,newStatus)-> joinNow.setDisable(newStatus==Animation.Status.RUNNING));
        p1.play();
    }

}
