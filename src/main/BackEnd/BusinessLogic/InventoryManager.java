package BusinessLogic;

import DataLayer.InventoryManagerRegister;
import DataLayer.InventoryRegister;
import DataLayer.ProductRegister;

import java.sql.SQLException;
import java.util.ArrayList;

public class InventoryManager {
    private String Email;
    private String Password;
    private static int ID;


    public InventoryManager(String email, String password) {
        Email = email;
        Password = password;
    }

    public InventoryManager() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public int IdAssigner()
    {

        for(Product product:ProductRegister.getProducts())
        {
            if(product.getID()>ID)
                ID=product.getID();
        }
        return ++ID;

    }

    public boolean addNewCategory(String Name) throws SQLException {

        for(Category inventoryRegister:InventoryRegister.getInventory())
        {
            if(inventoryRegister.getName().equals(Name))
                return false;
        }
        Category category=new Category();
        category.setName(Name);
        InventoryRegister.getInventory().add(category);
        InventoryRegister inventoryRegister=new InventoryRegister();
        inventoryRegister.WriteDbCategory(Name);
        return true;
    }
    public boolean login(String Email, String Password)
    {
        for(InventoryManager obj:InventoryManagerRegister.getInventoryManagers())
        {
            if(obj.getEmail().equals(Email) && obj.getPassword().equals(Password))
            {
                return  true;
            }
        }
        return false;
    }

    public int addProduct(String Category,String Name, String Description, String Price, String Quantity) throws SQLException {
        for(Category category:InventoryRegister.getInventory())
        {
            if(category.getProducts()!=null) {
                for (int i = 0; i < category.getProducts().size(); i++) {
                    if (category.getProducts().get(i).getName().equals(Name)) {
                        return 0;
                    }
                }
            }
        }
       for(Category category:InventoryRegister.getInventory())
       {

           if(Category.equals(category.getName()))
           {
               int ID=IdAssigner();
               Product product=new Product(Name,Integer.parseInt(Price),Description,Integer.parseInt(Quantity),ID);
               if(category.getProducts()!=null)
               category.getProducts().add(product);
               else
               {
                   ArrayList<Product> products=new ArrayList<>();
                   products.add(product);
                   category.setProducts(products);
               }
               ProductRegister productRegister=new ProductRegister();
               productRegister.WriteDbProducts(ID,Category,Name,Description,Integer.parseInt(Price),Integer.parseInt(Quantity));

               return ID;
           }
       }
       return 0;

    }
    public Product Search(int id)
    {
        for(Category category:InventoryRegister.getInventory())
        {
            for(Product product: category.getProducts())
            {
                if(product.getID()==id)
                {
                    return product;
                }
            }
        }
        return null;
    }

    public Boolean Delete(int id)
    {
        for(Category category:InventoryRegister.getInventory())
        {
            for(Product product: category.getProducts())
            {
                if(product.getID()==id)
                {
                    category.getProducts().remove(product);
                    return true;
                }
            }
        }
        return false;
    }
}
