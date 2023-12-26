package Application.APIS.Orders.Model.OrderProcessors;

import Application.APIS.Orders.Model.IOrder;

public class OrderProcessorFactory {
    public static IOrderProcessor CreateOrderProcessor(IOrder order) {
        return switch (order.getClass().getSimpleName()) {
            case "SimpleOrder" -> new SimpleOrderProcessor();
            case "CompoundOrder" -> new CompoundOrderProcessor();
            default -> null;
        };
    }
}
