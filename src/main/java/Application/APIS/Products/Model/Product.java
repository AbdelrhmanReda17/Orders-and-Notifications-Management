package Application.APIS.Products.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Product {
    @Id
    String id;
    String name;
    double price;
    int quantity;
    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public String getId() {
        return id;
    }

    public void copy(Product newProduct) {
        this.name = newProduct.getName();
        this.price = newProduct.getPrice();
        this.quantity = newProduct.getQuantity();
    }

    private String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
