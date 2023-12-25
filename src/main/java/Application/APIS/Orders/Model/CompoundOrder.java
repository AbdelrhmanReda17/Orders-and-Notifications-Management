package Application.APIS.Orders.Model;

import Application.APIS.Products.Model.Product;

import java.util.Date;
import java.util.List;

public class CompoundOrder extends IOrder{
    private double price;
    private List<ShoppingCartItem> products;
    public List<IOrder> orderList;
    public CompoundOrder(int id,double price , Date date, String status, int userId , List<ShoppingCartItem> products , List<IOrder> orderList) {
        super(id, date, status, userId);
        this.price = price;
        this.products = products;
        this.userId = userId;
        this.orderList = orderList;
    }
    public List<IOrder> getOrderList() {
        return orderList;
    }
    public void addOrder(IOrder order) {
        orderList.add(order);
    }
    public void removeOrder(IOrder order) {
        orderList.remove(order);
    }
//    public void editOrder(IOrder order) {
//        for (IOrder o : orderList) {
//            if (o.getId() == order.getId()) {
//                o.copy(order);
//            }
//        }
//    }
    @Override
    public Double getTotalCost() {
        double totalCost = 0f;
        for (IOrder order : orderList) {
            totalCost += order.getTotalCost();
        }
        return totalCost;
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
}
