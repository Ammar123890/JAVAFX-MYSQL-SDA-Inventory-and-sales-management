package BusinessLogic;

public class BasketHelper {
    private String ProductID,Name, Quantity, Price;

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public BasketHelper(String productID, String name, String quantity, String price) {
        ProductID = productID;
        Name = name;
        Quantity = quantity;
        Price = price;
    }
}
