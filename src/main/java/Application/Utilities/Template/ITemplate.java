package Application.Utilities.Template;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Products.Model.Product;

import java.io.FileNotFoundException;
import java.util.List;

public interface ITemplate {

    public String PlaceOrderMessage(String name, List<Product> products , boolean isTemp) ;
    public String PlacementOrderMessage(String name, List<Product> products , boolean isTemp) ;
    public String CancelOrderMessage (String name, List<Product> products , boolean isTemp) ;

}
