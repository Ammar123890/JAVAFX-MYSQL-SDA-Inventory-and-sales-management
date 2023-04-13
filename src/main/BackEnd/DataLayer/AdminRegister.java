package DataLayer;
import BusinessLogic.Admin;
import BusinessLogic.Customer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class AdminRegister {
    private static ArrayList<BusinessLogic.Admin> admins=new ArrayList<>();

    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    public static void setAdmins(ArrayList<Admin> admins) {
        AdminRegister.admins = admins;
    }

    public AdminRegister() throws SQLException {
    }
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
    public void WriteDbAdmins(String Email,String Password) throws SQLException {
        String sql;
        PreparedStatement statement;
        sql = "INSERT INTO `admin` (`Email`, `Password`)" +
                " VALUES (?, ?)";
        statement = con.prepareStatement(sql);
        statement.setString(1, Email);
        statement.setString(2, Password);
        statement.executeUpdate();
    }

    public void ReadDbAdmins()
    {
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "Select * from admin";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Admin admin=new Admin(rs.getString(1),rs.getString(2));
                admins.add(admin);
            }
            con.close();
        } catch (SQLException e) {

            System.out.println("exception: " + e);
        }

    }



}
