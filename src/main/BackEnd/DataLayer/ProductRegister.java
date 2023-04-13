package DataLayer;

import BusinessLogic.Category;
import BusinessLogic.Customer;
import BusinessLogic.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductRegister {
    private  static  ArrayList<Product> products = new ArrayList<>();

    public ProductRegister() throws SQLException {
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        ProductRegister.products = products;
    }

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");

    public void WriteDbProducts(int ID, String Category, String Name, String Description, int Price, int Quantity) throws SQLException {
        String sql;
        PreparedStatement statement;
        sql = "INSERT INTO `product` (`ID`, `Name`, `Price`, `Description`, `Quantity`, `Category`)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        statement = con.prepareStatement(sql);
        statement.setInt(1, ID);
        statement.setString(2, Name);
        statement.setInt(3, Price);
        statement.setString(4, Description);
        statement.setInt(5, Quantity);
        statement.setString(6, Category);
        statement.executeUpdate();
    }

    public void ReadDbProducts() {
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "Select * from product";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Product product = new Product(rs.getString(2), rs.getInt(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(1));
                products.add(product);
                for(Category category:InventoryRegister.getInventory())
                {
                    if(rs.getString(6).equals(category.getName()))
                    {
                        if(category.getProducts()!=null)
                            category.getProducts().add(product);
                        else
                        {
                            ArrayList<Product> products=new ArrayList<>();
                            products.add(product);
                            category.setProducts(products);
                        }
                    }
                }
            }
            con.close();
        } catch (SQLException e) {

            System.out.println("exception: " + e);
        }

    }

    public void UpdateProducts(String Query) {

        Statement stmt;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(Query);
        } catch (SQLException e) {
            System.out.println("exception: " + e);
        }

    }
}
