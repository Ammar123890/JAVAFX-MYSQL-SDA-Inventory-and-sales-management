package Controller;

import BusinessLogic.ComplainsAndFeedback;
import BusinessLogic.Customer;
import BusinessLogic.Order;
import BusinessLogic.Payment;
import DataLayer.CustomerRegister;
import DataLayer.OrderRegister;
import DataLayer.PaymentRegister;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerHomePageController implements Initializable {

    @FXML
    private Button Complain;
    @FXML
    private ComboBox<Integer> Orders;
    @FXML
    private ComboBox<Integer> Orders1;
    @FXML
    private TextArea Complains;
    @FXML

    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Integer> ord =new ArrayList<>();
        for(Customer customer1: CustomerRegister.getCustomers())
        {
            if(CustomerController.Customer.equals(customer1.getEmail()))
            {

                for(Order Order: OrderRegister.getOrders())
                {
                    if(Order.getCustomer().equals(CustomerController.Customer))
                    {
                        if(!ord.contains((Order.getOrderID())))
                            ord.add(Order.getOrderID());
                    }
                }
                break;
            }
        }
        for(int i : ord){
            Orders1.getItems().add(i);
            Orders.getItems().add(i);
        }
    }

    public void goBack3(ActionEvent event) throws IOException {
        Helper.ScreenLoader("Login_CUSTOMER.fxml",event);
    }

    public void TrackOrder(ActionEvent event) {
        Order order=new Order();
        if(Orders.getValue()==null){
            Helper.FieldError();
            return;
        }
        String str=order.status(Orders.getValue());
        Helper.Confirmation("Status: "+str);
    }

    public void Complain(ActionEvent event) throws SQLException {
        if(Orders1.getValue()==null ||Complains.getText() ==null){
            Helper.FieldError();
            return;
        }

        ComplainsAndFeedback obj=new ComplainsAndFeedback();
        obj.newCnF(Complains.getText(),Integer.parseInt(CustomerController.Customer),Orders1.getValue());
        Helper.Confirmation("Submitted Successfully ");
    }
}
