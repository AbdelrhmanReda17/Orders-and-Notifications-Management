package Application.APIS.Orders.Model;

import Application.Utilities.Database.IModel;
import Application.Utilities.Deserializers.OrderDeserializer;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;

@JsonDeserialize(using = OrderDeserializer.class)
public abstract class IOrder implements IModel {
    protected int id;
    private final Date date;
    private final String status;
    protected int userId;
    public IOrder() {
        this.date = new Date();
        this.status = "placed";
    }
    public IOrder(int id ,int userId) {
        this.id = id;
        this.date = new Date();
        this.status = "placed";
        this.userId = userId;
    }
    public abstract double getPrice();
    public abstract void setPrice(double price);
    public abstract void copy(IOrder newOrder);
    public Date getDate() {
        return date;
    }
    public String getStatus() {
        return status;
    }
    public Integer getUserId() {
        return userId;
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
    public abstract String toString();


}
