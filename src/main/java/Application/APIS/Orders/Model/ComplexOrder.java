package Application.APIS.Orders.Model;

import java.util.List;

public class ComplexOrder extends IOrder{
    public List<IOrder> orderList;
    public ComplexOrder(int id,List<IOrder> orderList) {
        this.id = id;
        this.orderList = orderList;
    }

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
        ComplexOrder complexOrder = (ComplexOrder) newOrder;
        this.id = complexOrder.getId();
        this.userId = complexOrder.getUserId();
        for (IOrder order: orderList) {
            complexOrder.copy(order);
        }
    }
}
