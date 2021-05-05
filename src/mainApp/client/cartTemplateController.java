package mainApp.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class cartTemplateController {
    @FXML private ImageView image;
    @FXML private Label title;
    @FXML private Label price;

    public void populate(String iurl, String ititle, String iprice){
        title.setText(ititle);
        price.setText(iprice);
        Image newImage = new Image(iurl);
        image.setImage(newImage);
    }

}
