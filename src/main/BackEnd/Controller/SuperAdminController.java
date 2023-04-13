package Controller;
import BusinessLogic.Admin;
import BusinessLogic.SuperAdmin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.sql.SQLException;

public class SuperAdminController  {
    public TextField EMAIL,PASSWORD;
    public SuperAdminController() {


    }
    ////////////////////////////////////////////////////////////
    ///////////////////////BACK BUTTONS/////////////////////////
    ////////////////////////////////////////////////////////////

    public void SuperAdminBack(ActionEvent event) throws IOException
    {
        Helper.ScreenLoader("Login_SUPER_ADMIN.fxml",event);
    }
    public void goBackToUserSelection(ActionEvent event) throws IOException {
        Helper.ScreenLoader("UserSelection_SUPER_ADMIN.fxml",event);
    }

    public void goBackFromHomePage(ActionEvent event) throws IOException {
        Helper.ScreenLoader("HomePage_SUPER_ADMIN.fxml",event);
    }

    ////////////////////////////////////////////////////////////
    ////////////////////SUPER ADMIN LOGIN///////////////////////
    ////////////////////////////////////////////////////////////

    public void login(ActionEvent event) throws IOException
    {
        if(EMAIL.getText().isEmpty()|| PASSWORD.getText().isEmpty())
        {
            Helper.FieldError();
            return;
        }
        BusinessLogic.SuperAdmin obj=new SuperAdmin();
        if(obj.login(EMAIL.getText(),PASSWORD.getText()))
            Helper.ScreenLoader("HomePage_SUPER_ADMIN.fxml",event);
        else
            Helper.Error("Wrong Credentials");
    }
    /////////////////////////////////////////////////////////////
    ///////////////MANAGE USER SCREENS LOADERS///////////////////
    /////////////////////////////////////////////////////////////

    public void manageAdmin(ActionEvent event) throws IOException
    {
        Helper.ScreenLoader("Manage_ADMIN.fxml",event);

    }
    public  void ManageSM(ActionEvent event) throws IOException{
        Helper.ScreenLoader("Manage_SALESMAN.fxml",event);

    }
    public  void ManageIM(ActionEvent event) throws IOException{
        Helper.ScreenLoader("Manage_INVENTORY_MANAGER.fxml",event);

    }
    public  void ManageCSM(ActionEvent event) throws IOException
    {
        Helper.ScreenLoader("Manage_CUSTOMER_SERVICE_AGENT.fxml",event);
    }

    /////////////////////////////////////////////////////////////
    //////////////////////ADMIN MANAGEMENT///////////////////////
    /////////////////////////////////////////////////////////////

    @FXML
    private TextField AddEmailTextFieldA;
    @FXML
    private TextField AddPasswordTextFieldA;
    @FXML
    private TextField DeleteTextFiledA;
    @FXML
    private TextField SearchEmailTextFiledA;
    @FXML
    void AddA(ActionEvent event) throws SQLException {
        String Email= AddEmailTextFieldA.getText();
        String Password=AddPasswordTextFieldA.getText();
        if(Email.isEmpty() || Password.isEmpty())
        {
            Helper.FieldError();
            return;
        }
        SuperAdmin admin=new SuperAdmin();
        if(admin.AddAdmin(Email,Password))
            Helper.Confirmation("Added successfully");
        else
            Helper.Error("Email Already Exist");
    }

    @FXML
    void DeleteA(ActionEvent event) {
        String Email= DeleteTextFiledA.getText();
        if(Email.isEmpty())
        {
            Helper.FieldError();
            return;
        }
        SuperAdmin admin=new SuperAdmin();
        if(admin.DeleteAdmin(Email))
            Helper.Confirmation("Admin deleted successfully");
        else
            Helper.Error("Email not exist");
    }

    @FXML
    void DisplayListA(ActionEvent event) throws IOException {
        Helper.ScreenLoader("List_ADMIN.fxml",event);

    }

    @FXML
    void SearchA(ActionEvent event) {
        String Email= SearchEmailTextFiledA.getText();
        if(Email.isEmpty())
        {
            Helper.FieldError();
            return;
        }
        SuperAdmin admin=new SuperAdmin();
        Admin SearchedAdmin=admin.SearchAdmin(Email);
        if(SearchedAdmin == null)
        {
            Helper.Error("Admin not found");
        }
        else
        {
            Helper.Confirmation("Admin found\nEmail: "+SearchedAdmin.getEmail()+"\n" +
                    "Password: "+SearchedAdmin.getPassword() );
        }
    }

    /////////////////////////////////////////////////////////////
    ////////////////INVENTORY MANAGER MANAGEMENT/////////////////
    /////////////////////////////////////////////////////////////
    @FXML
    private TextField AddEmailTextFieldIM;
    @FXML
    private TextField AddPasswordTextFieldIM;
    @FXML
    private TextField DeleteTextFiledIM;
    @FXML
    private TextField SearchEmailTextFiledIM;


    @FXML
    void AddIM(ActionEvent event) throws SQLException {
        String Email= AddEmailTextFieldIM.getText();
        String Password=AddPasswordTextFieldIM.getText();
        if(Email.isEmpty() || Password.isEmpty())
        {
            Helper.FieldError();
            return;
        }
        SuperAdmin obj=new SuperAdmin();
        if(obj.AddIM(Email,Password))
        {
            Helper.Confirmation("Added Successfully");
        }
        else
        {
            Helper.Error("Inventory Manager Already Exist");
        }


    }

    @FXML
    void DeleteSalesmanIM(ActionEvent event) {
        String Email= DeleteTextFiledIM.getText();
        if(Email.isEmpty())
        {
            Helper.FieldError();
        }
        SuperAdmin obj=new SuperAdmin();
        if(obj.DeleteIM(Email))
        {
            Helper.Confirmation("Deleted Successfully");
        }
        else
        {
            Helper.Error("Inventory Manager not exist");

        }

    }

    @FXML
    void SearchIM(ActionEvent event) {
        String Email= SearchEmailTextFiledIM.getText();
        if(Email.isEmpty())
        {
            Helper.FieldError();
            return;
        }
        SuperAdmin obj=new SuperAdmin();

        if(obj.SearchIM(Email)==null)
        {
            Helper.Error("Inventory Manager not found");

        }
        else
        {
            Helper.Confirmation("Email: "+obj.SearchIM(Email).getEmail()+"\nPassword: "+obj.SearchIM(Email).getPassword());
        }

    }

    public void DisplayListIM(ActionEvent event) throws IOException {
        Helper.ScreenLoader("List_INVENTORY_MANAGER.fxml",event);
    }


    /////////////////////////////////////////////////////////////
    /////////////////////SALESMAN MANAGEMENT/////////////////////
    /////////////////////////////////////////////////////////////

    @FXML
    private TextField AddEmailTextFieldSM;
    @FXML
    private TextField AddPasswordTextFieldSM;
    @FXML
    private TextField DeleteTextFiledSM;
    @FXML
    private TextField SearchEmailTextFiledSM;
    @FXML
    void AddSalesman(ActionEvent event) throws SQLException {
        String Email= AddEmailTextFieldSM.getText();
        String Password=AddPasswordTextFieldSM.getText();
        if(Email.isEmpty() || Password.isEmpty())
        {
            Helper.FieldError();
            return;

        }
        SuperAdmin obj=new SuperAdmin();
        if(obj.AddSM(Email,Password))
        {
            Helper.Confirmation("Added Successfully");
        }
        else
        {
            Helper.Error("Salesman Already Exist");
        }

    }
    public void DeleteSalesman(ActionEvent event)throws IOException
    {
        String Email= DeleteTextFiledSM.getText();
        if(Email.isEmpty())
        {
            Helper.FieldError();
            return;
        }
        SuperAdmin obj=new SuperAdmin();
        if(obj.DeleteSM(Email))
        {
            Helper.Confirmation("Deleted Successfully");
        }
        else
        {
            Helper.Error("Salesman not exist");

        }
    }
    public void SearchSalesman(ActionEvent event)throws IOException
    {
        String Email= SearchEmailTextFiledSM.getText();
        if(Email.isEmpty())
        {
            Helper.FieldError();
            return;
        }
        SuperAdmin obj=new SuperAdmin();

        if(obj.SearchSM(Email)==null)
        {
            Helper.Error("Salesman not found");
        }
        else
        {
            Helper.Confirmation("Email: "+obj.SearchSM(Email).getEmail()+"\nPassword: "+obj.SearchSM(Email).getPassword());
        }
    }

    @FXML
    void DisplayListSM(ActionEvent event) throws IOException {
        Helper.ScreenLoader("List_SALESMAN.fxml",event);
    }
    /////////////////////////////////////////////////////////////
    //////////////CUSTOMER SERVICE AGENT MANAGEMENT//////////////
    /////////////////////////////////////////////////////////////


    @FXML
    private TextField AddEmailTextFieldCSM;
    @FXML
    private TextField AddPasswordTextFieldCSM;
    @FXML
    private TextField DeleteTextFiledCSM;
    @FXML
    private TextField SearchEmailTextFiledCSM;

    @FXML
    void AddCSM(ActionEvent event) throws SQLException {
        String Email= AddEmailTextFieldCSM.getText();
        String Password=AddPasswordTextFieldCSM.getText();
        if(Email.isEmpty() || Password.isEmpty())
        {
            Helper.FieldError();
            return;
        }
        SuperAdmin admin=new SuperAdmin();
        if(admin.AddCSA(Email,Password))
            Helper.Confirmation("Added successfully");
        else
            Helper.Error("Email Already Exist");

    }

    @FXML
    void DeleteSalesmanCSM(ActionEvent event) {
        String Email= DeleteTextFiledCSM.getText();
        if(Email.isEmpty())
        {
            Helper.FieldError();
            return;
        }
        SuperAdmin obj=new SuperAdmin();
        if(obj.DeleteCSA(Email))
        {
            Helper.Confirmation("Deleted Successfully");
        }
        else
        {
            Helper.Error("Customer service agent does not exist");

        }

    }

    @FXML
    void DisplayListCSM(ActionEvent event) throws IOException {
        Helper.ScreenLoader("List_CUSTOMER_SERVICE_AGENT.fxml",event);

    }

    @FXML
    void SearchCSM(ActionEvent event) {
        String Email= SearchEmailTextFiledCSM.getText();
        if(Email.isEmpty())
        {
            Helper.FieldError();
            return;
        }
        SuperAdmin obj=new SuperAdmin();

        if(obj.SearchCSA(Email)==null)
        {
            Helper.Error("Salesman not found");
        }
        else
        {
            Helper.Confirmation("Email: "+obj.SearchCSA(Email).getEmail()+"\nPassword: "+obj.SearchCSA(Email).getPassword());
        }

    }

}



































