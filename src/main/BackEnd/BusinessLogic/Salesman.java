package BusinessLogic;

import DataLayer.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class Salesman {
    private String Email;
    private String Password;
    private ObservableList<BasketHelper> orders;

    public Salesman(String email, String password) {
        Email = email;
        Password = password;
        orders= FXCollections.observableArrayList();
    }

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

    public Salesman() {
    }
    public boolean login(String Email, String Password)
    {
        for(Salesman obj: SalesmanRegister.getSalesmen())
        {
            if(obj.getEmail().equals(Email) && obj.getPassword().equals(Password))
            {
                return  true;
            }
        }
        return false;
    }

    public Customer  getCustomer(String Email)
    {

        for(Customer obj:CustomerRegister.getCustomers())
        {
            if(obj.getEmail().equals(Email))
            {
                return obj;
            }
        }
        return  null;
    }

    public void MakeOrder(ObservableList<BasketHelper> products, String customer, double total, String salesman) throws SQLException {
        Order order=new Order();
        int OrderID=order.newOrder(products,salesman,customer);

        Payment payment=new Payment();
        payment.makeNewPayment(total,salesman,customer,OrderID);



    }






}


