package Application.APIS.Orders.Model;


import java.util.Date;
import java.util.List;

public class Order extends IOrder {
    private double price;
    private Date date;
    private String status;
    private List<ShoppingCartItem> products;

    public Order(int id ,double price, Date date, String status, int userId, List<ShoppingCartItem> products) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.status = status;
        this.userId = userId;
        this.products = products;
    }
    @Override
    public void copy(IOrder order) {
        Order simpleOrder = (Order) order;
        this.price = simpleOrder.getPrice();
        this.date = simpleOrder.getDate();
        this.status = simpleOrder.getStatus();
        this.userId = simpleOrder.getUserId();
        this.products = simpleOrder.getProducts();
    }
    public double getPrice() {
        return price;
    }
    public Date getDate() {
        return date;
    }
    public String getStatus() {
        return status;
    }
    public List<ShoppingCartItem> getProducts() {
        return products;
    }
    @Override
    public String toString() {
        return "Order [date=" + date + ", id=" + id + ", items=" + products + ", price=" + price + ", status=" + status
                + ", userId=" + userId + "]";
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
