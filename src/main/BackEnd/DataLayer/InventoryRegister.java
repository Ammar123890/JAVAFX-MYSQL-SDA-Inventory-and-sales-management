package DataLayer;

import BusinessLogic.Category;
import BusinessLogic.Product;

import java.sql.*;
import java.util.ArrayList;

public class InventoryRegister {
    private static ArrayList<Category> Inventory= new ArrayList<>();

    public InventoryRegister() throws SQLException {
    }

    public static ArrayList<Category> getInventory() {
        return Inventory;
    }

    public static void setInventory(ArrayList<Category> inventory) {
        Inventory = inventory;
    }

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

    public void WriteDbCategory(String Category) throws SQLException {
        String sql;
        PreparedStatement statement;
        sql = "INSERT INTO `category` (`Category`)" +
                " VALUES (?)";
        statement = con.prepareStatement(sql);
        statement.setString(1, Category);
        statement.executeUpdate();
    }

    public void ReadDbCategory() {
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "Select * from category";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Category category = new Category(rs.getString(1));
                Inventory.add(category);
            }
            con.close();
        } catch (SQLException e) {

            System.out.println("exception: " + e);
        }

    }
}
