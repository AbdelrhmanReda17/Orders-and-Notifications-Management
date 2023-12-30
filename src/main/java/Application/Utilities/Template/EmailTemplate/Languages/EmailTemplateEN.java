package Application.Utilities.Template.EmailTemplate.Languages;


import Application.APIS.Products.Model.Product;
import Application.Utilities.Template.EmailTemplate.EmailTemplate;
import java.util.List;

public class EmailTemplateEN extends EmailTemplate {

    @Override
    public String PlaceOrderMessage(String name, List<Product> products , boolean isTemp)  {
        StringBuilder productsString = GetProductList(products);
        if(isTemp)
            return "Dear {x}, Your booking of the item. {x} is confirmed, Thank you for shopping with us!";
        else{
            return "Dear "+name+", Your booking of the item" + (products.size() == 1 ? " " : "s ")  + productsString  +" is confirmed, Thank you for shopping with us!";

        }
    }
    @Override
    public String PlacementOrderMessage(String name, List<Product> products, boolean isTemp)  {
        StringBuilder productsString = GetProductList(products);

        if(isTemp)
            return "Dear {x}, Your booking of the item {x} is Shipped . Thank you for choosing us!";
        else{
            return "Dear "+name+", Your booking of the item" + (products.size() == 1 ? " " : "s ")  + productsString  +" is Shipped . Thank you for choosing us!";
        }
    }
    @Override
    public String CancelOrderMessage(String name, List<Product> products , boolean isTemp)  {
        StringBuilder productsString = GetProductList(products);
        if (isTemp)
            return "Dear {x}, We regret to inform you that your order for item {x} has been canceled.\n" + "If you have questions, please contact support. Thank you.";
        else{
            return "Dear "+name+", We regret to inform you that your order for the item" + (products.size() == 1 ? " " : "s ")  + productsString  +" has been canceled.\n" +
                    "If you have questions, please contact support. Thank you.";
        }
    }
    @Override
    public String CancelShippingOrderMessage(String name, List<Product> products, boolean isTemp) {
        return "CancelShippingOrderMessage";
    }
}
