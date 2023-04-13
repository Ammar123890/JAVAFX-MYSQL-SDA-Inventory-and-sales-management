package DataLayer;
import BusinessLogic.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRegister {
    private static ArrayList<Customer> customers=new ArrayList<>();

    public CustomerRegister() throws SQLException {
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        CustomerRegister.customers = customers;
    }




    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
    public void WriteDbCustomers(String Email,String Password, String Address) throws SQLException {
        String sql;
        ;
        PreparedStatement statement;
        sql = "INSERT INTO `customer` (`Email`, `Address`, `Passwrod`)" +
                " VALUES (?, ?, ?)";
        statement = con.prepareStatement(sql);
        statement.setString(1, Email);
        statement.setString(2, Address);
        statement.setString(3, Password);
        statement.executeUpdate();
    }

    public void ReadDbCustomers()
    {
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "Select * from customer";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Customer customer=new Customer(rs.getString(1),rs.getString(3),rs.getString(2));
                customers.add(customer);
            }
            con.close();
        } catch (SQLException e) {

            System.out.println("exception: " + e);
        }

    }



















}
