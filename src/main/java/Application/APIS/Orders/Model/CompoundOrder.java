package Application.APIS.Orders.Model;

import java.util.List;

public class CompoundOrder extends IOrder{
    public List<IOrder> orderList;
    public CompoundOrder(int id, List<IOrder> orderList) {
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
        CompoundOrder complexOrder = (CompoundOrder) newOrder;
        this.id = complexOrder.getId();
        this.userId = complexOrder.getUserId();
        for (IOrder order: orderList) {
            complexOrder.copy(order);
        }
    }
}
