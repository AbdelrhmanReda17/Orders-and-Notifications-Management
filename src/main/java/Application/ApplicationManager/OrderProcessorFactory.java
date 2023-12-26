package Application.ApplicationManager;

import Application.APIS.Orders.Model.IOrder;

public class OrderProcessorFactory {
    public static ApplicationManager CreateOrderProcessor(IOrder order) {
        return switch (order.getClass().getSimpleName()) {
            case "SimpleOrder" -> new SimpleOrderManager();
            case "CompoundOrder" -> new CompoundOrderManager();
            default -> null;
        };
    }
}
