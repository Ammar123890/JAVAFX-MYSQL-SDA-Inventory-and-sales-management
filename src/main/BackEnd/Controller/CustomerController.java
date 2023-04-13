package Controller;

import BusinessLogic.BasketHelper;
import BusinessLogic.Customer;
import BusinessLogic.Order;
import DataLayer.CustomerRegister;
import DataLayer.OrderRegister;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerController  {


    @FXML
    private TextField Login_Email;
    @FXML
    private TextField Login_Password;
    @FXML
    private TextField AddressRegister;
    @FXML
    private TextField EmailRegister;
    @FXML
    private TextField PasswordRegister;


    public CustomerController() {
    }

    public void goBack(ActionEvent event) throws IOException {
        Helper.ScreenLoader("UserSelection_SUPER_ADMIN.fxml",event);
    }

    public void goBack1(ActionEvent event) throws IOException {
        Helper.ScreenLoader("Login_CUSTOMER.fxml",event);
    }
    @FXML
    void GoToRegisterPage(ActionEvent event) throws IOException {
        Helper.ScreenLoader("Register_CUSTOMER.fxml",event);
    }
    public static  String Customer;
    @FXML
    void Login(ActionEvent event) throws IOException {
        Customer customer=new Customer();
        if(Login_Email.getText()==null|| Login_Password.getText()==null)
            Helper.FieldError();
        else
        {
            if(customer.login(Login_Email.getText(),Login_Password.getText())) {
                Customer=Login_Email.getText();
                Helper.ScreenLoader("HomePage_CUSTOMER.fxml", event);

            }
            else
                Helper.Error("Wrong Credentials");
        }
    }


    public void RegisterCustomer(ActionEvent event) throws SQLException {
        if(EmailRegister.getText()==null|| PasswordRegister.getText()==null||AddressRegister.getText()==null){
            Helper.FieldError();
            return;
        }
        Customer customer=new Customer();
        if(customer.Register(EmailRegister.getText(),PasswordRegister.getText(),AddressRegister.getText()))
        Helper.Confirmation("Registered Successfully");
        else
        Helper.Error("Email already existed");
    }








}
