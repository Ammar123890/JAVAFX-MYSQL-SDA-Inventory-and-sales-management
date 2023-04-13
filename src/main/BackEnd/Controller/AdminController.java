package Controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {


    public AdminController() {
    }

    public void goBack(ActionEvent event) throws IOException {
        Helper.ScreenLoader("UserSelection_SUPER_ADMIN.fxml",event);

    }




}
