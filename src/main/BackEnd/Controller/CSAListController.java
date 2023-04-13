package Controller;

import BusinessLogic.Admin;
import BusinessLogic.CustomerServiceAgent;
import Controller.Helper;
import DataLayer.AdminRegister;
import DataLayer.CSM_Register;
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

public class CSAListController implements Initializable {
    @FXML
    private TableView<CustomerServiceAgent> CSAList=new TableView<>();

    @FXML
    private TableColumn<CustomerServiceAgent, String> EmailCol=new TableColumn<>();

    @FXML
    private TableColumn<CustomerServiceAgent, String> PasswordCol=new TableColumn<>();


    @FXML
    void goBack2(ActionEvent event) throws IOException {
        Helper.ScreenLoader("Manage_CUSTOMER_SERVICE_AGENT.fxml",event);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        PasswordCol.setCellValueFactory(new PropertyValueFactory<>("Password"));
        Display();

    }

    public void Display() {
        ObservableList<CustomerServiceAgent> observableList = FXCollections.observableArrayList();
        observableList.addAll(CSM_Register.getCustomerServiceAgents());
        CSAList.setItems(observableList);

    }

}
