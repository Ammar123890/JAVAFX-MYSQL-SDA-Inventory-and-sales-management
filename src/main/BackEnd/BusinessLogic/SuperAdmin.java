package BusinessLogic;

import DataLayer.AdminRegister;
import DataLayer.CSM_Register;
import DataLayer.InventoryManagerRegister;
import DataLayer.SalesmanRegister;

import java.sql.SQLException;
import java.util.ArrayList;

public class SuperAdmin {
    private String Email;
    private String Password;


    // getting data from data layer
    public void readData() {
        DataLayer.SuperAdmin obj = new DataLayer.SuperAdmin();
        Email=obj.getEmail();
        Password=obj.getPass();
    }

    // checking for login
    public boolean login(String Email, String password)
    {
        readData();
        return this.Email.equals(Email) && this.Password.equals(password);
    }

    public boolean AddAdmin(String Email,String Password) throws SQLException {



        for(Admin admin:AdminRegister.getAdmins())
        {
            if(admin.getEmail().equals(Email))
            {
                return false;
            }
        }
        Admin newAdmin=new Admin(Email,Password);
        AdminRegister.getAdmins().add(newAdmin);
        AdminRegister adminRegister=new AdminRegister();
        adminRegister.WriteDbAdmins(Email,Password);
        return true;
    }
    public boolean DeleteAdmin(String Email)
    {

        for(Admin admin:AdminRegister.getAdmins())
        {
            if(admin.getEmail().equals(Email))
            {
                AdminRegister.getAdmins().remove(admin);
                return true;
            }
        }
        return false;
    }
    public boolean DeleteSM(String Email)
    {

        for(Salesman salesman:SalesmanRegister.getSalesmen())
        {
            if(salesman.getEmail().equals(Email))
            {
                SalesmanRegister.getSalesmen().remove(salesman);
                return true;
            }
        }
        return false;
    }

    public Admin SearchAdmin(String Email)
    {

        for(Admin admin:AdminRegister.getAdmins())
        {
            if(admin.getEmail().equals(Email))
            {
                 return admin;
            }
        }
        return null;
    }
    public Salesman SearchSM(String Email)
    {

        for(Salesman salesman:SalesmanRegister.getSalesmen())
        {
            if(salesman.getEmail().equals(Email))
            {
                return salesman;
            }
        }
        return null;
    }


    public boolean AddIM(String Email,String Password) throws SQLException {



        for(InventoryManager inventoryManager: InventoryManagerRegister.getInventoryManagers())
        {
            if(inventoryManager.getEmail().equals(Email))
            {
                return false;
            }
        }
        InventoryManager obj=new InventoryManager(Email,Password);
        InventoryManagerRegister.getInventoryManagers().add(obj);
        InventoryManagerRegister inventoryManager=new InventoryManagerRegister();
        inventoryManager.WriteDbIM(Email,Password);
        return true;
    }

    public boolean AddSM(String Email,String Password) throws SQLException {

        for(Salesman salesman: SalesmanRegister.getSalesmen())
        {
            if(salesman.getEmail().equals(Email))
            {
                return false;
            }
        }
        Salesman obj=new Salesman(Email,Password);
        SalesmanRegister.getSalesmen().add(obj);
        SalesmanRegister salesmanRegister=new SalesmanRegister();
        salesmanRegister.WriteDbSM(Email,Password);
        return true;
    }

    public InventoryManager SearchIM(String Email)
    {
        for(InventoryManager inventoryManager: InventoryManagerRegister.getInventoryManagers())
        {
            if(inventoryManager.getEmail().equals(Email))
            {
                return inventoryManager;
            }
        }

        return null;
    }
    public boolean DeleteIM(String Email)
    {
        for(InventoryManager inventoryManager: InventoryManagerRegister.getInventoryManagers())
        {
            if(inventoryManager.getEmail().equals(Email))
            {
                InventoryManagerRegister.getInventoryManagers().remove(inventoryManager);
                return true;
            }
        }

        return false;
    }
    public boolean AddCSA(String Email,String Password) throws SQLException {



        for(CustomerServiceAgent customerServiceAgent: CSM_Register.getCustomerServiceAgents())
        {
            if(customerServiceAgent.getEmail().equals(Email))
            {
                return false;
            }
        }
        CustomerServiceAgent customerServiceAgent=new CustomerServiceAgent(Email,Password);
        CSM_Register.getCustomerServiceAgents().add(customerServiceAgent);
        CSM_Register csm_register=new CSM_Register();
        csm_register.WriteDbCSA(Email,Password);
        return true;
    }
    public boolean DeleteCSA(String Email)
    {
        for(CustomerServiceAgent customerServiceAgent: CSM_Register.getCustomerServiceAgents())
        {
            if(customerServiceAgent.getEmail().equals(Email))
            {
                CSM_Register.getCustomerServiceAgents().remove(customerServiceAgent);
                return true;
            }
        }

        return false;
    }
    public CustomerServiceAgent SearchCSA(String Email)
    {
        for(CustomerServiceAgent customerServiceAgent: CSM_Register.getCustomerServiceAgents())
        {
            if( customerServiceAgent.getEmail().equals(Email))
            {
                return customerServiceAgent;
            }
        }

        return null;
    }

    }





