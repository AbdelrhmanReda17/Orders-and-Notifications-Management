package Application.Managers.OrderManager.OrderCommands.Factory;

import Application.APIS.Orders.Model.OrderState;
import Application.Managers.OrderManager.OrderCommands.*;

public class OrderCommandFactory {

    public static OrderCommand CreateCommand(OrderState state) {
        return switch (state) {
            case Placed -> new PlaceOrderCommand();
            case Cancelled -> new CancelOrderCommand();
            case Shipping -> new ShippingOrderCommand();
            case CancelShipping -> new CancelShipmentOrder();
            case Shipped -> new ShippedOrderCommand();
            default -> null;
        };
    }
}
