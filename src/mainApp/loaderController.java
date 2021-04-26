package mainApp;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ResourceBundle;

public class loaderController implements Initializable {


    @FXML private ImageView gear1;
    @FXML private ImageView gear2;
    @FXML private ImageView gear3;
    @FXML private Label logo;
    public void rotationAnimation1() {
        RotateTransition rt = new RotateTransition(Duration.millis(3000), gear1);
        FadeTransition tr = new FadeTransition(Duration.millis(3000), gear1);
        tr.setFromValue(0);
        tr.setToValue(1.0);
        tr.setCycleCount(1);
        rt.setByAngle(360);
        rt.setDelay(Duration.millis(700));
        rt.setInterpolator(Interpolator.EASE_IN);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();
        tr.play();
    }
    public void rotationAnimation2() {
        RotateTransition rt = new RotateTransition(Duration.millis(3000), gear2);
        FadeTransition tr = new FadeTransition(Duration.millis(3000), gear2);
        tr.setFromValue(0);
        tr.setToValue(1.0);
        tr.setCycleCount(1);
        rt.setByAngle(-360);
        rt.setDelay(Duration.millis(700));
        rt.setInterpolator(Interpolator.EASE_IN);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();
        tr.play();
    }
    public void rotationAnimation3() {
        RotateTransition rt = new RotateTransition(Duration.millis(3000), gear3);
        FadeTransition tr = new FadeTransition(Duration.millis(3000), gear3);
        tr.setFromValue(0);
        tr.setToValue(1.0);
        tr.setCycleCount(1);
        rt.setByAngle(-360);
        rt.setDelay(Duration.millis(700));
        rt.setInterpolator(Interpolator.EASE_IN);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        tr.play();
        rt.play();
    }

    public void fade() {
        FadeTransition tr = new FadeTransition(Duration.millis(3000), logo);
        tr.setFromValue(0);
        tr.setToValue(1.0);
        tr.setDelay(Duration.millis(1000));
        tr.setCycleCount(1);
        tr.setOnFinished(e -> {
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("res/appSelector.fxml"));
                        Stage window = (Stage) gear1.getScene().getWindow();
                        Scene AppPick = new Scene(root,700,350);
                        window.close();
                        window.setScene(AppPick);
                        window.show();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

        );
        tr.play();
    }




    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        rotationAnimation1();
        rotationAnimation2();
        rotationAnimation3();
        fade();

    }
}
