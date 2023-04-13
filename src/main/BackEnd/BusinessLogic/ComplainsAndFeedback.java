package BusinessLogic;

import DataLayer.ComplainAndFeedbackRegister;

import java.sql.SQLException;

public class ComplainsAndFeedback {
    private  String Complain;
    private  int CustomerID,OrderID;

    public String getComplain() {
        return Complain;
    }

    public void setComplain(String complain) {
        Complain = complain;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public ComplainsAndFeedback(String complain, int customerID, int orderID){
        Complain = complain;
        CustomerID = customerID;
        OrderID = orderID;

    }

    public ComplainsAndFeedback() {
    }

    public void newCnF(String complain, int customerID, int orderID) throws SQLException {
        ComplainAndFeedbackRegister obj=new ComplainAndFeedbackRegister();
        ComplainsAndFeedback obj2=new ComplainsAndFeedback(complain,customerID,orderID);
        ComplainAndFeedbackRegister.getComplainAndFeedbackRegisters().add(obj2);
        obj.WriteDbCnF(customerID,orderID,complain);
    }


}
