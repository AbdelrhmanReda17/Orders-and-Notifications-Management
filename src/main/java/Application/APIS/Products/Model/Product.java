package Application.APIS.Products.Model;
import Application.Database.IModel;


public class Product implements IModel {
    int serialNumber;
    String name;
    String vendor;
    double price;
    int quantity;
    public Product(int serialNumber, String name, String vendor, double price, int quantity) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.vendor = vendor;
        this.price = price;
        this.quantity = quantity;
    }

    public void copy(Product newProduct) {
        this.vendor = newProduct.getVendor();
        this.name = newProduct.getName();
        this.price = newProduct.getPrice();
        this.quantity = newProduct.getQuantity();
    }
    public String getVendor() {
        return vendor;
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
    @Override
    public int getId() {
        return serialNumber;
    }
    @Override
    public void setId(int id) {
        this.serialNumber = id;
    }
}
