package Application.APIS.Orders.Model;

import Application.Utilities.Database.IModel;
import Application.Utilities.Deserializers.OrderDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;

@JsonDeserialize(using = OrderDeserializer.class)
public abstract class IOrder implements IModel<Integer> {
    protected int id;
    private Date date;
    protected OrderState status;
    protected int userId;
    public IOrder() {
        this.date = new Date();
        this.status = OrderState.Placed;
    }
    public IOrder(int id, int userId) {
        this.id = id;
        this.userId = userId;
        this.date = new Date();
        this.status = OrderState.Placed;
    }
    public IOrder(int userId) {
        this.date = new Date();
        this.status = OrderState.Placed;
        this.userId = userId;
    }

    public abstract List<ShoppingCartItem> getProducts();
    public abstract double getPrice();
    public abstract void setPrice(double price);
    public abstract void copy(IOrder newOrder);
    public Date getDate() {
        return date;
    }
    public OrderState getStatus() {
        return status;
    }
    public abstract void setStatus(OrderState status);
    public Integer getUserId() {
        return userId;
    }
    @Override
    public abstract Integer getId();
    @Override
    public abstract void setId(Integer id);
    @Override
    public abstract String toString();


}
