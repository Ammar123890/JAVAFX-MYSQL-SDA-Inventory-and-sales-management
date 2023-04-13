package DataLayer;

import BusinessLogic.Admin;
import BusinessLogic.ComplainsAndFeedback;

import java.sql.*;
import java.util.ArrayList;

public class ComplainAndFeedbackRegister {


    private  static ArrayList<ComplainsAndFeedback> complainAndFeedbackRegisters=new ArrayList<>();

    public ComplainAndFeedbackRegister() throws SQLException {
    }

    public static ArrayList<ComplainsAndFeedback> getComplainAndFeedbackRegisters() {
        return complainAndFeedbackRegisters;
    }

    public static void setComplainAndFeedbackRegisters(ArrayList<ComplainsAndFeedback> complainAndFeedbackRegisters) {
        ComplainAndFeedbackRegister.complainAndFeedbackRegisters = complainAndFeedbackRegisters;
    }

    private final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
    public void WriteDbCnF(int CID,int OID, String CnF) throws SQLException {
        String sql;
        PreparedStatement statement;
        sql = "INSERT INTO `complainandfeedback` (`CustomerID`, `OrderID`,`C&F`)" +
                " VALUES (?, ?, ?)";
        statement = con.prepareStatement(sql);
        statement.setInt(1,  CID);
        statement.setInt(2,  OID);
        statement.setString(3,CnF);
        statement.executeUpdate();
    }

    public void ReadDbAdmins()
    {
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "Select * from complainandfeedback";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
               ComplainsAndFeedback obj=new ComplainsAndFeedback(rs.getString(3),rs.getInt(1),
                       rs.getInt(2));
                complainAndFeedbackRegisters.add(obj);
            }
            con.close();
        } catch (SQLException e) {

            System.out.println("exception: " + e);
        }

    }

}


