package Controller;

import BusinessLogic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SalesmanController implements Initializable {

    @FXML
    private Button BasketButton;
    @FXML
    private TextField CustomerEmail;
    @FXML
    private Button DeleteBasketButton;
    @FXML
    private Button PlaceOrderButton;
    @FXML
    private TextField ProductID;
    @FXML
    private TextField ProductQuantity;
    @FXML
    private Label TotalLabel;
    @FXML
    private  static ObservableList<BasketHelper> observableList = FXCollections.observableArrayList();
    @FXML
    private TableView<BasketHelper> BasketTable;
    @FXML
    private TableColumn<BasketHelper, String> NameCol =new TableColumn<>();
    @FXML
    private TableColumn<BasketHelper, String> PidCol=new TableColumn<>();
    @FXML
    private TableColumn<BasketHelper, String> PriceCol=new TableColumn<>();
    @FXML
    private TableColumn<BasketHelper, String> QuantityCol=new TableColumn<>();
    private double Total;
    @FXML
    void AddToBasket(ActionEvent event) throws IOException{

        InventoryManager obj=new InventoryManager();
        Salesman salesman=new Salesman();
        Product product=obj.Search(Integer.parseInt(ProductID.getText()));

        //////////////////////ERRORS//////////////////////////////

        if(CustomerEmail.getText()==null||ProductID.getText()==null||ProductQuantity.getText()==null)
            Helper.FieldError();

        else if (product==null)
            Helper.Error("Product not found");

        else if(salesman.getCustomer(CustomerEmail.getText())==null)
                Helper.Error("Customer not found");

        else if(obj.Search(Integer.parseInt(ProductID.getText())).getQuantity()<Integer.parseInt(ProductQuantity.getText()))
            Helper.Error("Not enough quantity available\nAvailable Quantity :"+obj.Search
                        (Integer.parseInt(ProductID.getText())).getQuantity());

            /////////////////////////ADDING NEW ITEM//////////////////////////
        else {

            for(BasketHelper basketHelper: observableList)
            {
                if(basketHelper.getProductID().equals(ProductID.getText()))
                {
                    Helper.Error("Already Added");
                    return;
                }
            }
            BasketHelper basketHelper = new BasketHelper(ProductID.getText(), product.getName(), String.valueOf(ProductQuantity.getText())
                    , String.valueOf(product.getPrice()));
            observableList.add(basketHelper);
            BasketTable.setItems(observableList);
            Total += product.getPrice() * Double.parseDouble(ProductQuantity.getText());
            TotalLabel.setText(String.valueOf(Total));
            Customer=CustomerEmail.getText();
        }

        }




    @FXML
    void DeleteBasket(ActionEvent event) {
        BasketTable.getItems().clear();
        TotalLabel.setText("");
        Total=0;
    }

    @FXML
    void CheckOut(ActionEvent event) throws IOException {
        if(BasketTable.getItems().isEmpty())
            Helper.Error("Please add products to basket");
        else
        {
            total=TotalLabel.getText();
            Helper.ScreenLoader("Payment.fxml",event);

        }
    }

    public SalesmanController() {
    }

    public void goBack(ActionEvent event) throws IOException {
        Helper.ScreenLoader("UserSelection_SUPER_ADMIN.fxml",event);
    }
    public void goBack2(ActionEvent event) throws IOException {
        Helper.ScreenLoader("Login_SALESMAN.fxml",event);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PidCol.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
    }
    @FXML
    private TextField EmailLogin;
    @FXML
    private Label Salesman_sm=new Label();
    @FXML
    private TextField PasswordLogin;
    public void Login(ActionEvent event) throws IOException {
        if(EmailLogin.getText().isEmpty()|| PasswordLogin.getText().isEmpty())
        {
            Helper.FieldError();
            return;
        }
        Salesman salesman=new Salesman();
        if(salesman.login( EmailLogin.getText(),PasswordLogin.getText())) {
            Salesman=EmailLogin.getText();
            observableList.clear();
            Helper.ScreenLoader("HomePage_SALESMAN.fxml", event);
        }

        else
            Helper.Error("Wrong Credentials");
    }

    @FXML
    void goBack3(ActionEvent event) throws IOException {
        Helper.ScreenLoader("HomePage_SALESMAN.fxml",event);
    }
    private static  String Salesman,total,Customer;
    @FXML
    void payment(ActionEvent event) throws SQLException, IOException {

        Salesman order=new Salesman();
        System.out.println("Total"+total);
        System.out.println(observableList.size());
        order.MakeOrder(observableList,Customer,Double.parseDouble(total),Salesman);
        Helper.Confirmation("Payment Succeed");
        Helper.ScreenLoader("HomePage_SALESMAN.fxml",event);
        observableList.clear();

    }



}
