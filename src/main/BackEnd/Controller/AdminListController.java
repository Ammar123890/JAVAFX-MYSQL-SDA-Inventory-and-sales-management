package Controller;

import BusinessLogic.Admin;
import Controller.MAIN;
import DataLayer.AdminRegister;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminListController implements Initializable {
    @FXML
    private TableView<Admin> AdminList=new TableView<>();

    @FXML
    private TableColumn<Admin, String> EmailCol=new TableColumn<>();

    @FXML
    private TableColumn<Admin, String> PasswordCol=new TableColumn<>();


    @FXML
    void goBack2(ActionEvent event) throws IOException {
        Stage s= (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("Manage_ADMIN.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        s.setScene(scene);
        s.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        PasswordCol.setCellValueFactory(new PropertyValueFactory<>("Password"));
        Display();

    }

    public void Display() {
        ObservableList<BusinessLogic.Admin> observableList = FXCollections.observableArrayList();
        observableList.addAll(AdminRegister.getAdmins());
        AdminList.setItems(observableList);

    }



}
