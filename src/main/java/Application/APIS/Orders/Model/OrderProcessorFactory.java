package Application.APIS.Orders.Model;

import Application.Utilities.OrderProcessors.CompoundOrderProcessor;
import Application.Utilities.OrderProcessors.IOrderProcessor;
import Application.Utilities.OrderProcessors.SimpleOrderProcessor;

public class OrderProcessorFactory {
    public static IOrderProcessor CreateOrderProcessor(IOrder order) {
        return switch (order.getClass().getSimpleName()) {
            case "SimpleOrder" -> new SimpleOrderProcessor();
            case "CompoundOrder" -> new CompoundOrderProcessor();
            default -> null;
        };

    }
}
