package Controller;

import BusinessLogic.InventoryManager;
import Controller.Helper;
import Controller.MAIN;
import Controller.SuperAdminController;
import DataLayer.InventoryManagerRegister;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IMListController implements Initializable {
    @FXML
    private TableColumn<InventoryManager, String> EmailCol=new TableColumn<>();

    @FXML
    private TableView<InventoryManager> IMList=new TableView<>();

    @FXML
    private TableColumn<InventoryManager, String> PasswordCol=new TableColumn<>();


    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        PasswordCol.setCellValueFactory(new PropertyValueFactory<>("Password"));
        Display();
    }

    public void Display() {
        ObservableList<InventoryManager> observableList = FXCollections.observableArrayList();
        observableList.addAll(InventoryManagerRegister.getInventoryManagers());
        IMList.setItems(observableList);

    }

    public void goBack2(ActionEvent event) throws IOException {
        Helper.ScreenLoader("Manage_INVENTORY_MANAGER.fxml",event);

    }
}
