package DataLayer;

import BusinessLogic.Admin;
import BusinessLogic.CustomerServiceAgent;

import java.sql.*;
import java.util.ArrayList;

public class CSM_Register {
    private static ArrayList<CustomerServiceAgent> customerServiceAgents=new ArrayList<>();

    public CSM_Register() throws SQLException {
    }

    public static ArrayList<CustomerServiceAgent> getCustomerServiceAgents() {
        return customerServiceAgents;
    }

    public static void setCustomerServiceAgents(ArrayList<CustomerServiceAgent> customerServiceAgents) {
        CSM_Register.customerServiceAgents = customerServiceAgents;
    }

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
    public void WriteDbCSA(String Email,String Password) throws SQLException {
        String sql;
        PreparedStatement statement;
        sql = "INSERT INTO `csa` (`Email`, `Password`)" +
                " VALUES (?, ?)";
        statement = con.prepareStatement(sql);
        statement.setString(1, Email);
        statement.setString(2, Password);
        statement.executeUpdate();
    }

    public void ReadDbCSA()
    {
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "Select * from csa";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CustomerServiceAgent customerServiceAgent=new CustomerServiceAgent
                        (rs.getString(1),rs.getString(2));
                customerServiceAgents.add(customerServiceAgent);
            }
            con.close();
        } catch (SQLException e) {

            System.out.println("exception: " + e);
        }

    }



}
