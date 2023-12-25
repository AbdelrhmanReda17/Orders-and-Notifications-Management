package Application.APIS.Orders.Model;

import java.util.List;

public class ComponentOrder extends IOrder{
    public List<IOrder> orderList;
    public ComponentOrder(int id, List<IOrder> orderList) {
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
        ComponentOrder complexOrder = (ComponentOrder) newOrder;
        this.id = complexOrder.getId();
        this.userId = complexOrder.getUserId();
        for (IOrder order: orderList) {
            complexOrder.copy(order);
        }
    }
}
