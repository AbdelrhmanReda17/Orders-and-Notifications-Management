package Application.Utilities.Template.PhoneTemplate.Languages;

import Application.APIS.Products.Model.Product;
import Application.Utilities.Template.PhoneTemplate.PhoneTemplate;

import java.util.List;

public class PhoneTemplateEN extends PhoneTemplate {
    @Override
    public String PlaceOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);

        return " your booking of the item" + (products.size() == 1 ? " " : "s ")  + productsString  +" is confirmed.";
    }
    @Override
    public String PlacementOrderMessage(String name, List<Product> products , boolean isTemp) {
        return "Hello " + name + ", your order has been successfully completed. Thank you for shopping with us!";
    }
    @Override
    public String CancelOrderMessage(String name, List<Product> products , boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        return "We regret to inform you that your order for the item" + (products.size() == 1 ? " " : "s ")  + productsString  +" has been canceled. If you have questions, please contact support. Thank you.";
    }
    @Override
    public String CancelShippingOrderMessage(String name, List<Product> products, boolean isTemp) {
        return "CancelShippingOrderMessage";
    }
}
