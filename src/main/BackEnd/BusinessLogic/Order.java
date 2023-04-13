package BusinessLogic;

import DataLayer.*;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class Order {
    private int OrderID;
    private ObservableList<BasketHelper> products;
    private String status;

    public int getOrderID() {
        return OrderID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }


    public ObservableList<BasketHelper> getProducts() {
        return products;
    }

    public void setProducts(ObservableList<BasketHelper> products) {
        this.products = products;
    }


    private String Customer, Salesman;

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getSalesman() {
        return Salesman;
    }

    public void setSalesman(String salesman) {
        Salesman = salesman;
    }

    private int id;
    private int IdGenerator()
    {
        for(Order orders:OrderRegister.getOrders())
        {
            if(orders.getOrderID()>id)
                id=orders.getOrderID();
        }
        return (id+1);
    }


    public Order() {
    }

    public Order(int orderID,String customer, String salesman,ObservableList<BasketHelper> products, String  status) {
        OrderID = orderID;
        this.status=status;
        this.products=products;
        Customer = customer;
        Salesman = salesman;
    }

    public int newOrder(ObservableList<BasketHelper> products, String Salesman, String Customer) throws SQLException {
        int id=IdGenerator();
        for(BasketHelper product:products)
        {
            Order order=new Order(id,Customer,Salesman,products,"Confirmed");
            OrderRegister.getOrders().add(order);
            OrderRegister obj=new OrderRegister();
            Inventory inventory=new Inventory();
            inventory.updateInventory_ORDER(products);
            obj.WriteDbOrders(id,Integer.parseInt(product.getProductID()),Salesman,Customer,Integer.parseInt(product.getQuantity()),"Confirmed");
        }
        return id;
    }

    public String status(int OrderID)
    {
        for(Order order:OrderRegister.getOrders())
            if(order.getOrderID()== OrderID)
                return order.status;
        return null;
    }
}

















//    public Order(int orderID, String customer, double total) {
//        OrderID = orderID;
//        Customer = customer;
//        products=new ArrayList<>();
//        Total=total;
//    }