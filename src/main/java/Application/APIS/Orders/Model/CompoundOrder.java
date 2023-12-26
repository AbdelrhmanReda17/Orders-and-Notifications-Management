package Application.APIS.Orders.Model;

import Application.APIS.Products.Model.Product;

import java.util.Date;
import java.util.List;

public class CompoundOrder extends IOrder{
    private final double price;
    private final List<ShoppingCartItem> products;
    public List<IOrder> orderList;
    public CompoundOrder(double price ,int userId , List<ShoppingCartItem> products , List<IOrder> orderList) {
        super( userId);
        this.price = price;
        this.products = products;
        this.userId = userId;
        this.orderList = orderList;
    }

    public List<ShoppingCartItem> getProducts() {
        return products;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public List<IOrder> getOrderList() {
        return orderList;
    }


    @Override
    public void copy(IOrder newOrder) {
        CompoundOrder complexOrder = (CompoundOrder) newOrder;
        this.id = complexOrder.getId();
        this.userId = complexOrder.getUserId();
        for (IOrder order: orderList) {
            complexOrder.copy(order);
        }
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
    public String toString() {
        String result = "CompoundOrder : "+
                "id = " + id +
                ", price = " + price +
                ", date = " + getDate() +
                ", status = " + getStatus() +
                ", userId = " + userId +
                ", products = " + products + '\n' +
                "orderList = " + orderList;
            return result;
    }
}
