package mainApp.client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mainApp.client.userCls;

public class LogInController {
    @FXML private Label message;
    @FXML private TextField emailField;
    @FXML private TextField passwordField;;
    @FXML private VBox firstColumn;
    @FXML private VBox secondColumn;
    @FXML private Text title;
    @FXML private Text question;
    @FXML private Text joinNow;
    @FXML private Text forgotPassword;
    @FXML private TextField fullNameField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Button signInOrUp;
    @FXML private Label userMessage;
    public Pattern p = Pattern.compile("^(.+)@(.+)$");
    public boolean loginFormIsValid() {
        if(!p.matcher(emailField.getText()).matches()){
            userMessage.setText("Wrong email !");
            return false;
        }else {
            userMessage.setText("");
            return true;
        }
    }
    public boolean signupFormIsValid(){
        if(!p.matcher(emailField.getText()).matches()){
            message.setText("Wrong email !");
            return false;
        } else if (!passwordField.getText().equals(confirmPasswordField.getText())){
            message.setText("Passwords don't match");
            return false;
        } else {
            message.setText("");
            return true;
        }
    }

    public void ConnectBtn(ActionEvent event){
        dbConnector connect = new dbConnector();
        Connection connectDB = connect.getConnection();


        if (signInOrUp.getText().contains("In") && loginFormIsValid()) {

            try{
                String connectQuery = "SELECT id, first, last,email, password FROM client WHERE email='" + emailField.getText() + "' and password='" + passwordField.getText() + "';";
                Statement statement = connectDB.createStatement();
                ResultSet queryOutput = statement.executeQuery(connectQuery);
                if(queryOutput.next()){
                    if (queryOutput.getString("email").contains(emailField.getText()) && queryOutput.getString("password").contains(passwordField.getText())) {

                        Stage window = (Stage) signInOrUp.getScene().getWindow();
                        window.close();
                        userCls u = new userCls(queryOutput.getInt("id"), queryOutput.getString("first"), queryOutput.getString("last"), queryOutput.getString("email"));
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("res/homeClient.fxml"));
                        Parent root = loader.load();

                        homeClientController homeclientController = loader.getController();
                        homeclientController.initiateClient(u);

                        window.show();
                        window.setScene(new Scene(root,1000,600));
                    }
                }else{
                    userMessage.setText("Account not found !");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (signInOrUp.getText().contains("Up") && signupFormIsValid()){

            try{
                String connectQuery = "select count(id) from client;";
                Statement statement = connectDB.createStatement();
                ResultSet queryOutput = statement.executeQuery(connectQuery);
                queryOutput.next();
                int current_id = queryOutput.getInt(1) + 1;
                String[] fullName = fullNameField.getText().split(" ", 2);
                String createQuery = String.format("INSERT INTO client VALUES(%d,'%s','%s','%s','%s','%s')",current_id, fullName[0], fullName[1], emailField.getText(), passwordField.getText(), java.time.LocalDate.now());
                statement.executeUpdate(createQuery);
                message.setText("Account created successfully !");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

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
