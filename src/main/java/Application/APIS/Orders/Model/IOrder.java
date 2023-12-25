package Application.APIS.Orders.Model;

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
    protected int id = 0;
    private Date date;
    private String status;
    protected int userId;
    public IOrder(int id,int userId) {
        this.id = id;
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
