package Application.APIS.Products.Model;
import Application.Utilities.Database.IModel;


public class Product implements IModel {
    static int idCounter = 0;
    int serialNumber;
    String name;
    String vendor;
    double price;
    int quantity;
    public Product() {
        this.serialNumber = idCounter++;
    }
    public Product( String name, String vendor, double price, int quantity) {
        this.serialNumber = idCounter++;
        this.name = name;
        this.vendor = vendor;
        this.price = price;
        this.quantity = quantity;
    }
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

    public String getName() {
        return name;
    }
    public String getVendor() {
        return vendor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public void setId(int id) {
        this.serialNumber = id;
    }
    @Override
    public int getId() {
        return serialNumber;
    }

}
