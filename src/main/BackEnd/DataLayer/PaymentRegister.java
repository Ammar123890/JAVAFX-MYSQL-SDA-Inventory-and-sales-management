package DataLayer;

import BusinessLogic.Payment;
import BusinessLogic.Salesman;

import java.sql.*;
import java.util.ArrayList;

public class PaymentRegister {
    private  static ArrayList<Payment> payments=new ArrayList<>();

    public PaymentRegister() throws SQLException {
    }

    public static ArrayList<Payment> getPayments() {
        return payments;
    }

    public static void setPayments(ArrayList<Payment> payments) {
        PaymentRegister.payments = payments;
    }

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
    public void WriteDbPayment(String Salesman,String Customer, int ID, int Total,int OrderID) throws SQLException {
        String sql;
        PreparedStatement statement;
        sql = "INSERT INTO `payment` (`Salesman`,`Customer`,`ID`,`Total`,`OrderID`)" +
                " VALUES (?, ?, ?, ?, ?)";
        statement = con.prepareStatement(sql);
        statement.setString(1, Salesman);
        statement.setString(2, Customer);
        statement.setInt(3, ID);
        statement.setInt(4, Total);
        statement.setInt(5, OrderID);
        statement.executeUpdate();
    }

    public void ReadDbPayment()
    {
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "Select * from payment";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Payment payment=new Payment(rs.getString(1),rs.getString(2),rs.getInt(3),
                        rs.getInt(4));
                payments.add(payment);
            }
            con.close();
        } catch (SQLException e) {

            System.out.println("exception: " + e);
        }

    }
}
