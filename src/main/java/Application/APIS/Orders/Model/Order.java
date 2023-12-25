package Application.APIS.Orders.Model;


import Application.APIS.Database.IModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "Orders")
public class Order implements IModel {
    @Id
    private int id;
    @Field("price")
    private double price;
    @Field("date")
    private Date date;
    @Field("status")
    private String status;
    @Field("userId")
    private int userId;
    private List<ShoppingCartItem> products;

    public Order(int id ,double price, Date date, String status, int userId, List<ShoppingCartItem> products) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.status = status;
        this.userId = userId;
        this.products = products;
    }
    public void copy(Order order) {
        this.price = order.getPrice();
        this.date = order.getDate();
        this.status = order.getStatus();
        this.userId = order.getUserId();
        this.products = order.getProducts();
    }
    public Integer getUserId() {
        return userId;
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
}
