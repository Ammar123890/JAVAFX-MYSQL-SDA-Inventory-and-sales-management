package DataLayer;
import java.sql.*;
public class DbHandler {
    public void connectDB() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            if (con == null) {
                System.out.println("DB connection failed");
            } else
                System.out.println("DB connection successful");

        } catch (Exception e) {
            System.out.println("exception: " + e);
        }

    }
}
