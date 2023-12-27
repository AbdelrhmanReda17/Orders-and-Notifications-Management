package Application.APIS.Orders.Model;


import java.util.List;

public class SimpleOrder extends IOrder {
    private double price;
    private List<ShoppingCartItem> products;
    public SimpleOrder(int id , double price, int userId, List<ShoppingCartItem> products) {
        super(id , userId);
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
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public List<ShoppingCartItem> getProducts() {
        return products;
    }

    @Override
    public void setStatus(OrderState status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n" + "SimpleOrder : "  +
                "price= " + price +
                ", userId= " + userId +
                ", date = " + getDate() +
                ", status = " + getStatus() +
                ", id= " + id+
                ", products= " + products;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProducts(List<ShoppingCartItem> products) {
        this.products = products;
    }

}
