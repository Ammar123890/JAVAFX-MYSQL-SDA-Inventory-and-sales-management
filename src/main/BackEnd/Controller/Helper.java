package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Helper {
    public static void FieldError()
    {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Please Enter All Fields");
        alert.showAndWait();
    }
    public static void CredentialError()
    {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Wrong Credentials");
        alert.showAndWait();
    }
    public static void Confirmation(String message)
    {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
    public static void RepeatedData()
    {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Enter data has already exit");
        alert.showAndWait();
    }
    public static  void Error(String Error)
    {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(Error);
        alert.showAndWait();
    }
    public static void ScreenLoader(String Screen, ActionEvent event) throws IOException
    {
        Stage s= (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource(Screen));
        Scene scene = new Scene(fxmlLoader.load());
        s.setScene(scene);
        s.show();

    }
}
