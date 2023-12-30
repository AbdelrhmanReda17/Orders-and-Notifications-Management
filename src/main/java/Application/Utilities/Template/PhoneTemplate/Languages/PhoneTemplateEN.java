package Application.Utilities.Template.PhoneTemplate.Languages;

import Application.APIS.Products.Model.Product;
import Application.Utilities.Template.PhoneTemplate.PhoneTemplate;

import java.util.List;

public class PhoneTemplateEN extends PhoneTemplate {
    @Override
    public String PlaceOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp)
            return "Hello {x}, we inform you that your order for the item {y} is confirmed. Thank you for shopping with us!";
        else
            return "Hello " + name + ", we inform you that your order for the item" + (products.size() == 1 ? "" : "s") +
                    " " + productsString + " is confirmed. Thank you for shopping with us!";
    }

    @Override
    public String ShippingOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp)
            return "Hello {x}, we inform you that your order for the item {y} is in the shipping process. Thank you for shopping with us!";
        else
            return "Hello " + name + ", we inform you that your order for the item" + (products.size() == 1 ? "" : "s") +
                    " " + productsString + " is in the shipping process. Thank you for shopping with us!";
    }
    @Override
    public String CancelOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp)
            return "Hello {x}, we regret to inform you that your order for the item {y} has been canceled. If you have questions, please contact support. Thank you.";
        else
            return "Hello " + name + ", we regret to inform you that your order for the item" + (products.size() == 1 ? "" : "s") +
                    " " + productsString + " has been canceled. If you have questions, please contact support. Thank you.";
    }
    @Override
    public String CancelShippingOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp)
            return "Hello {x}, we inform you that you canceled the shipment process for your order that has the item {y}. Thank you for choosing us!";
        else
            return "Hello " + name + ", we inform you that you canceled the shipment process for your order that has the item" + (products.size() == 1 ? "" : "s") +
                    " " + productsString + ". Thank you for choosing us!";
    }
    @Override
    public String ShippedOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp)
            return "Hello {x}, we inform you that your order for the item {y} is shipped. Thank you for choosing us!";
        else
            return "Hello " + name + ", we inform you that your order for the item" + (products.size() == 1 ? "" : "s") +
                    " " + productsString + " is shipped. Thank you for choosing us!";
    }
}
