package DataLayer;

import BusinessLogic.Customer;
import BusinessLogic.InventoryManager;

import java.sql.*;
import java.util.ArrayList;

public class InventoryManagerRegister {
    private static ArrayList<InventoryManager> inventoryManagers=new ArrayList<>();

    public static ArrayList<InventoryManager> getInventoryManagers() {
        return inventoryManagers;
    }

    public static void setInventoryManagers(ArrayList<InventoryManager> inventoryManagers) {
        InventoryManagerRegister.inventoryManagers = inventoryManagers;
    }

    public InventoryManagerRegister() throws SQLException {
    }

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
    public void WriteDbIM(String Email,String Password) throws SQLException {
        String sql;
        PreparedStatement statement;
        sql = "INSERT INTO `inventorymanager` (`Email`,`Password`)" +
                " VALUES (?, ?)";
        statement = con.prepareStatement(sql);
        statement.setString(1, Email);
        statement.setString(2, Password);
        statement.executeUpdate();
    }

    public void ReadDbIM()
    {
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "Select * from inventorymanager";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                InventoryManager inventoryManager=new InventoryManager(rs.getString(1),rs.getString(2));
                inventoryManagers.add(inventoryManager);
            }
            con.close();
        } catch (SQLException e) {

            System.out.println("exception: " + e);
        }

    }
}
