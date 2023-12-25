package Application.APIS.Orders.Model;


import java.util.Date;
import java.util.List;

public class SimpleOrder extends IOrder {
    private double price;
    private List<ShoppingCartItem> products;
    public SimpleOrder(int id , double price, Date date, String status, int userId, List<ShoppingCartItem> products) {
        super(id, date, status, userId);
        this.price = price;
        this.userId = userId;
        this.products = products;
    }
    @Override
    public void copy(IOrder order) {
        SimpleOrder simpleOrder = (SimpleOrder) order;
        this.price = simpleOrder.getPrice();
        this.userId = simpleOrder.getUserId();
        this.products = simpleOrder.getProducts();
    }
    public double getPrice() {
        return price;
    }
    public List<ShoppingCartItem> getProducts() {
        return products;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Double getTotalCost() {
        return price;
    }
}
