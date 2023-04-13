package BusinessLogic;
import DataLayer.ProductRegister;
import javafx.collections.ObservableList;
import java.sql.SQLException;

public class Inventory {

    public void updateInventory_ORDER(ObservableList<BasketHelper> orderedProducts) throws SQLException {

        for(BasketHelper orders: orderedProducts)
        {
            for(Product Inventory:ProductRegister.getProducts())
            {
                if(Inventory.getID()==Integer.parseInt(orders.getProductID()))
                {
                    int NewQuantity=Inventory.getQuantity()-Integer.parseInt(orders.getQuantity());
                    Inventory.setQuantity(NewQuantity);
                    ProductRegister obj=new ProductRegister();
                    obj.UpdateProducts("UPDATE `product` SET `Quantity`='"+NewQuantity+"' WHERE `ID`="+Inventory.getID());
                    break;
                }
            }
        }
    }
}
