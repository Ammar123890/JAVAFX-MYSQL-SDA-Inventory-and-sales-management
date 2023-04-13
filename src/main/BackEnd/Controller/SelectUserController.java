package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectUserController {

    public  SelectUserController()
    {

    }

    public void selectAdmin(ActionEvent event) throws IOException
    {
        Helper.ScreenLoader("Login_ADMIN.fxml",event);
    }
    public void selectSuperAdmin(ActionEvent event) throws IOException
    {
        Helper.ScreenLoader("Login_SUPER_ADMIN.fxml",event);
    }
    public void selectCustomer(ActionEvent event) throws IOException
    {
        Helper.ScreenLoader("Login_CUSTOMER.fxml",event);
    }
    public void selectInventoryManager(ActionEvent event) throws IOException
    {
        Helper.ScreenLoader("Login_INVENTORY_MANAGER.fxml",event);
    }
    public void selectSalesman(ActionEvent event) throws IOException
    {
        Helper.ScreenLoader("Login_SALESMAN.fxml",event);
    }
    public void selectCustomerServiceAgent(ActionEvent event) throws IOException
    {
        Helper.ScreenLoader("Login_CUSTOMER_SERVICE_AGENT.fxml",event);
    }
}