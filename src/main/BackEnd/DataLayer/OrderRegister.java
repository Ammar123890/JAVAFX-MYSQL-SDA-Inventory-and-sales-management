package DataLayer;

import BusinessLogic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class OrderRegister {
    private static ArrayList<Order> orders=new ArrayList<>();

    public OrderRegister() throws SQLException {
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static void setOrders(ArrayList<Order> orders) {
        OrderRegister.orders = orders;
    }



    public void ReadDbOrders() {
        ObservableList<BasketHelper> products = FXCollections.observableArrayList();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "Select MAX(OrderID)from orders";
            ResultSet rs = stmt.executeQuery(sql);
            int max = 0;
            while (rs.next()) {
                max = rs.getInt(1);
            }
            for(int i=1;i<=max;i++)
            {
                products.clear();
                String sql2="Select * from `orders` WHERE `OrderID`="+i;
                ResultSet rs2= stmt.executeQuery(sql2);
                while (rs2.next())
                {
                    for(Product product:ProductRegister.getProducts())
                    {

                        if(product.getID()== rs2.getInt(2))
                        {

                            String ID=String.valueOf(rs2.getInt(1));
                            String Name=product.getName();
                            String Quantity=String.valueOf(rs2.getInt(5));
                            String Price=String.valueOf(product.getPrice());
                            BasketHelper basketHelper=new BasketHelper(ID,Name,Quantity,Price);
                            products.add(basketHelper);
                            Order order=new Order(Integer.parseInt(ID),rs2.getString(4),rs2.getString(3),products,rs2.getString(6));
                            orders.add(order);
                            break;

                        }
                    }
                for(Customer customer:CustomerRegister.getCustomers())
                {
                    if(customer.getEmail().equals(rs2.getString(4)))
                    {
                        customer.setOrders(products);
                        break;
                    }
                }
                for(Salesman salesman:SalesmanRegister.getSalesmen())
                {
                    if(salesman.getEmail().equals(rs2.getString(3)))
                    {
                        salesman.setOrders(products);
                        break;
                    }
                }



                }
            } con.close();

        } catch (SQLException e) {

            System.out.println("exception: " + e);
        }

    }









    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
    public void WriteDbOrders(int OrderID,int ProductID, String Salesman, String Customer, int Quantity, String status) throws SQLException {
        String sql;
        PreparedStatement statement;
        sql = "INSERT INTO `orders` (`OrderID`,`ProductID`,`Salesman`,`Customer`,`Quantity`, `Status`)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        statement = con.prepareStatement(sql);
        statement.setInt(1,OrderID);
        statement.setInt(2,ProductID);
        statement.setString(3,Salesman);
        statement.setString(4,Customer);
        statement.setInt(5,Quantity);
        statement.setString(6,status);

        statement.executeUpdate();
    }










}