package Application.Utilities.Template.PhoneTemplate;

import Application.APIS.Products.Model.Product;
import Application.Utilities.Template.ITemplate;

import java.util.List;

public abstract class PhoneTemplate implements ITemplate {

    protected StringBuilder GetProductList(List<Product> products) {
        StringBuilder productsString = new StringBuilder();
        for (Product product : products) {
            productsString.append(product.getName()).append(", ");
        }
        productsString.deleteCharAt(productsString.length() - 1);
        productsString.deleteCharAt(productsString.length() - 1);
        return productsString;
    }


}
