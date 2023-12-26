package Application.APIS.Orders.Model;

import Application.APIS.Users.Model.User;
import Application.Utilities.Database.IModel;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CompoundOrder.class , name = "CompoundOrder"),
        @JsonSubTypes.Type(value = SimpleOrder.class , name = "SimpleOrder")
})
public abstract class IOrder implements IModel {
    private static int counter = 0;
    protected int id;
    private Date date;
    private String status;
    protected int userId;
    public IOrder(int userId) {
        id = counter;
        counter++;
        this.date = new Date();
        this.status = "placed";
        this.userId = userId;
    }
    public abstract double getPrice();
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
