package Controller;

import BusinessLogic.Category;
import BusinessLogic.InventoryManager;
import BusinessLogic.Product;
import Controller.MAIN;
import DataLayer.InventoryRegister;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InventoryManagerController implements Initializable{
    public ComboBox<String> AddCategory=new ComboBox<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Load();
    }
    private void Load()
    {
        for(Category obj1:InventoryRegister.getInventory())
        {
            AddCategory.getItems().add(obj1.getName());
        }

    }
    public InventoryManagerController()  {

    }


    public void goBackButton(ActionEvent event) throws IOException {
        Helper.ScreenLoader("login_INVENTORY_MANAGER.fxml",event);

    }
    public void goBack2(ActionEvent event) throws IOException {
        Helper.ScreenLoader("UserSelection_SUPER_ADMIN.fxml",event);
    }

    @FXML
    private TextField Category_Add;
    @FXML
    private TextField PDisc_ADD;
    @FXML
    private TextField PId_Delete;
    @FXML
    private TextField PName_ADD;
    @FXML
    private TextField ProductSearch;
    @FXML
    private TextField Quantity_ADD;
    @FXML
    private  TextField Price_ADD;
    @FXML
    private Button Back;
    @FXML
    void AddCategory(ActionEvent event) throws IOException, SQLException {
        String Category=Category_Add.getText();
        InventoryManager inventoryManager=new InventoryManager();
        if(inventoryManager.addNewCategory(Category))
        {
            Helper.Confirmation("Category added successfully");
            Load();
        }
        else
           Helper.RepeatedData();

    }
    @FXML
    void AddProduct(ActionEvent event) throws IOException, SQLException {

        if(AddCategory.getSelectionModel().getSelectedItem() ==null || PName_ADD.getText()==null
        || PDisc_ADD.getText()== null || Quantity_ADD.getText()==null ||  Price_ADD.getText()==null)
        {
            Helper.FieldError();
        }
        else
        {
            InventoryManager inventoryManager=new InventoryManager();
            int AssignID=inventoryManager.addProduct(AddCategory.getSelectionModel().getSelectedItem(),PName_ADD.getText(),
                    PDisc_ADD.getText(),Price_ADD.getText(),Quantity_ADD.getText());
            Alert alert;
            if(AssignID!=0)
            {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Added successfully\nID assigned: "+AssignID);
                alert.showAndWait();
            }
            else
               Helper.RepeatedData();
        }


    }
    @FXML
    void DeleteProduct(ActionEvent event) throws IOException {
        Alert alert;
        if(PId_Delete.getText()==null)
        {
            Helper.FieldError();
            return;
        }
        InventoryManager inventoryManager=new InventoryManager();
        if(inventoryManager.Delete(Integer.parseInt(PId_Delete.getText())))
            Helper.Confirmation("Deleted Successfully");
        else
            Helper.Error("Product not found");



    }
    @FXML
    void DispatchOrder(ActionEvent event) {
    }
    @FXML
    void ProductSearch(ActionEvent event) throws  IOException{

        String ID=ProductSearch.getText();
        if(ID.isEmpty())
        {
            Helper.FieldError();
            return;

        }
        InventoryManager inventoryManager=new InventoryManager();
        Product product=inventoryManager.Search(Integer.parseInt(ID));

        if(product==null)
            Helper.Error("Product Not Exist");

        else
        {
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Result");
            alert.setHeaderText("Product name: "+product.getName()+"\nProduct Description: "+product.getDescription()+"\n" +
                    "Product Price: "+product.getPrice());
            alert.showAndWait();

        }

    }

    @FXML
    private TextField Email;
    @FXML
    private TextField Password;


     public void Login(ActionEvent event) throws IOException {
        InventoryManager inventoryManager=new InventoryManager();
        if(Email.getText().isEmpty()|| Password.getText().isEmpty())
        {
            Helper.FieldError();
            return;
        }
        if(inventoryManager.login(Email.getText(),Password.getText()))
            Helper.ScreenLoader("HomePage_INVENTORY_MANAGER.fxml",event);
        else
            Helper.Error("Wrong credentials");


    }


    public void DisplayCategory(ActionEvent event) {
    }
}
