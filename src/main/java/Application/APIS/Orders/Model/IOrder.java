package Application.APIS.Orders.Model;

import Application.APIS.Database.IModel;

public abstract class IOrder implements IModel {
    protected int id = 0;
    protected int userId;
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
