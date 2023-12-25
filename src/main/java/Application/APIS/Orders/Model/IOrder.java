package Application.APIS.Orders.Model;

import Application.Utilities.Database.IModel;

import java.util.Date;

public abstract class IOrder implements IModel {
    protected int id = 0;
    private Date date;
    private String status;
    protected int userId;
    public IOrder(int id, Date date, String status, int userId) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.userId = userId;
    }
    public abstract Double getTotalCost();
    public abstract void copy(IOrder newOrder);
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
}
