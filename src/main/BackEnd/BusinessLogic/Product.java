package BusinessLogic;

public class Product {
    private int ID;
    private String Name;
    private int Price;
    private String Description;
    private int Quantity;

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Product(String name, int  price, String description, int Quantity,int ID) {

        Name = name;
        Price = price;
        Description = description;
        this.Quantity=Quantity;
        this.ID=ID;
    }

    public Product() {
    }
}
