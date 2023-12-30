package Application.Managers.OrderManager.Factory;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.Managers.OrderManager.CompoundOrderManager;
import Application.Managers.OrderManager.OrderCommands.*;
import Application.Managers.OrderManager.OrderManager;
import Application.Managers.OrderManager.SimpleOrderManager;

public class OrderManagerFactory {
    public static OrderManager CreateOrderProcessor(IOrder order , int numberOfOrders){
        return switch (order.getClass().getSimpleName()) {
            case "SimpleOrder" -> new SimpleOrderManager(numberOfOrders);
            case "CompoundOrder" -> new CompoundOrderManager(numberOfOrders);
            default -> null;
        };
    }
    public static OrderCommand CreateCommand(OrderState state) {
        return switch (state) {
            case Placed -> new PlaceOrderCommand();
            case Cancelled -> new CancelOrderCommand();
            case Shipping -> new PlacementOrderCommand();
            case CancelShipping -> new CancelShipmentOrder();
            default -> null;
        };
    }
}
