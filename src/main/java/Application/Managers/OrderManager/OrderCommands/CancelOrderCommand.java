package Application.Managers.OrderManager.OrderCommands;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Users.Model.User;
import Application.Managers.OrderManager.OrderManager;

public class CancelOrderCommand implements OrderCommand {
    @Override
    public void execute(OrderManager orderManager, IOrder newOrder, User user) {
        orderManager.CancelOrder(newOrder, user);
    }
}
