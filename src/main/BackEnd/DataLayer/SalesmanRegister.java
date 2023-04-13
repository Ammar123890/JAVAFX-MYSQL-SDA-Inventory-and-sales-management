package DataLayer;

import BusinessLogic.InventoryManager;
import BusinessLogic.Salesman;

import java.sql.*;
import java.util.ArrayList;

public class SalesmanRegister {
    private static ArrayList<Salesman>salesmen=new ArrayList<>();

    public SalesmanRegister() throws SQLException {
    }

    public static ArrayList<Salesman> getSalesmen() {
        return salesmen;
    }

    public static void setSalesmen(ArrayList<Salesman> salesmen) {
        SalesmanRegister.salesmen = salesmen;
    }



    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
    public void WriteDbSM(String Email,String Password) throws SQLException {
        String sql;
        PreparedStatement statement;
        sql = "INSERT INTO `salesman` (`Email`,`Password`)" +
                " VALUES (?, ?)";
        statement = con.prepareStatement(sql);
        statement.setString(1, Email);
        statement.setString(2, Password);
        statement.executeUpdate();
    }

    public void ReadDbSM()
    {
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "Select * from salesman";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Salesman salesman=new Salesman(rs.getString(1),rs.getString(2));
                salesmen.add(salesman);
            }
            con.close();
        } catch (SQLException e) {

            System.out.println("exception: " + e);
        }

    }
}
