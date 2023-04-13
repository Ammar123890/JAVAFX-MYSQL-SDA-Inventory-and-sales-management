package BusinessLogic;

import java.util.ArrayList;

public class Category {
    private String Name;
    private ArrayList<Product> products;
    public Category(String name) {
        this.Name = name;
        products = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Category() {
    }
}
