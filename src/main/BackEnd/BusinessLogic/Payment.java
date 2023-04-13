package BusinessLogic;

import DataLayer.PaymentRegister;

import java.sql.SQLException;

public class Payment {
    private int PaymentID;
    private double Total;

    public Payment() {

    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int paymentID) {
        PaymentID = paymentID;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
    private static int PaymentIDGenerate;
    private int IdGenerator()
    {
        for(Payment payment:PaymentRegister.getPayments())
        {
            if(payment.getPaymentID()>PaymentIDGenerate)
            {
                PaymentIDGenerate=payment.getPaymentID();
            }
        }
        return (PaymentIDGenerate+=1);

    }

    public Payment( double total) {
        PaymentID=IdGenerator();
        Total = total;
    }
    public Payment( String salesman, String customer,  int ID, double total) {
        PaymentID=ID;
        Salesman=salesman;
        Customer=customer;
        Total = total;
    }

    public String getSalesman() {
        return Salesman;
    }

    public void setSalesman(String salesman) {
        Salesman = salesman;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    private String Salesman;
    private String Customer;
    public void makeNewPayment(double Total, String Salesman, String Customer, int OrderID) throws SQLException {
        Payment newPayment=new Payment(Total);
        PaymentRegister.getPayments().add(newPayment);
        PaymentRegister obj=new PaymentRegister();
        obj.WriteDbPayment(Salesman,Customer,IdGenerator(), (int) Double.parseDouble(String.valueOf(Total)),OrderID);
    }
}
