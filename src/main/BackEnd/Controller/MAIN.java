package Controller;
import DataLayer.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class MAIN extends Application {

    public static void main(String[] args) throws SQLException {
        DbHandler dbHandler=new DbHandler();
        dbHandler.connectDB();

        CustomerRegister customerRegister=new CustomerRegister();
        customerRegister.ReadDbCustomers();

        InventoryManagerRegister inventoryManager=new InventoryManagerRegister();
        inventoryManager.ReadDbIM();

        SalesmanRegister salesmanRegister=new SalesmanRegister();
        salesmanRegister.ReadDbSM();

        InventoryRegister inventoryRegister=new InventoryRegister();
        inventoryRegister.ReadDbCategory();

        ProductRegister productRegister=new ProductRegister();
        productRegister.ReadDbProducts();

        PaymentRegister paymentRegister=new PaymentRegister();
        paymentRegister.ReadDbPayment();

        OrderRegister orderRegister=new OrderRegister();
        orderRegister.ReadDbOrders();

        CSM_Register csm_register=new CSM_Register();
        csm_register.ReadDbCSA();

        AdminRegister adminRegister=new AdminRegister();
        adminRegister.ReadDbAdmins();

        ComplainAndFeedbackRegister complainAndFeedbackRegister=new ComplainAndFeedbackRegister();
        complainAndFeedbackRegister.ReadDbAdmins();

        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("UserSelection_SUPER_ADMIN.fxml"));
            Scene scene;
            scene = new Scene(fxmlLoader.load());
            stage.setTitle("SILK LOGISTICS");
            stage.setScene(scene);
            stage.show();

        }catch(Exception e)
        {
           e.printStackTrace();
        }
    }

}