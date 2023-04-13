package BusinessLogic;
import DataLayer.CustomerRegister;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class Customer {
    private String Email;
    private String Password;
    private String Address;
    private ObservableList<BasketHelper> orders;

    public ObservableList<BasketHelper> getOrders() {
        return orders;
    }

    public void setOrders(ObservableList<BasketHelper> orders) {
        this.orders = orders;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAddress() {
        return Address;
    }

    public Customer(String email, String password, String address) {
        orders=  FXCollections.observableArrayList();
        Email = email;
        Password = password;
        Address = address;
    }

    public Customer() {
    }

    public void setAddress(String address) {
        Address = address;
    }
    public boolean login(String Email, String Password)
    {
        for(Customer customer: CustomerRegister.getCustomers())
        {
            if(customer.getEmail().equals(Email)&& customer.getPassword().equals(Password))
            {
                return true;
            }
        }
        return false;
    }
    public boolean Register(String Email, String Password,String Address) throws SQLException {
        for(Customer customer: CustomerRegister.getCustomers())
        {
            if(customer.getEmail().equals(Email))
            {
                return false;
            }
        }
        Customer customer=new Customer(Email,Password,Address);
        CustomerRegister.getCustomers().add(customer);
        CustomerRegister customerRegister=new CustomerRegister();
        customerRegister.WriteDbCustomers(Email,Password,Address);
        return true;
    }

}
