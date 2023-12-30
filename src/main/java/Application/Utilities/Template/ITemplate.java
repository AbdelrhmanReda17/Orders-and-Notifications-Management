package Application.Utilities.Template;

import Application.APIS.Products.Model.Product;
import java.util.List;

public interface ITemplate {

    String PlaceOrderMessage(String name, List<Product> products , boolean isTemp) ;
    String ShippingOrderMessage(String name, List<Product> products , boolean isTemp) ;
    String ShippedOrderMessage (String name, List<Product> products , boolean isTemp) ;
    String CancelOrderMessage (String name, List<Product> products , boolean isTemp) ;
    String CancelShippingOrderMessage (String name, List<Product> products , boolean isTemp) ;

}
