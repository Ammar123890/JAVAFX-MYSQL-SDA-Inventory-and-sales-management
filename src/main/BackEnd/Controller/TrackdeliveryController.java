package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackdeliveryController {

    public void goBack(ActionEvent event) throws IOException {
        Helper.ScreenLoader("HomePage_CUSTOMER.fxml",event);

    }



}
