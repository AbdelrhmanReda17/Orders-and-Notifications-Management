package Application.Managers.OrderManager;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class OrderManager {
    static UserRepository userRepository = new UserRepository();
    protected final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    double orderFee = 120;
    int numberOfOrders = 1;
    public OrderManager(int numberOfOrders){
        this.numberOfOrders = numberOfOrders;
    }
    public abstract void CancelOrder(IOrder newOrder, User user);
    public abstract void PlaceOrder(IOrder newOrder, User user);
    public abstract void CancelShipmentOrder(IOrder newOrder, User user);
    public abstract void VerifyOrder(IOrder order, User user);
    public void PlacementOrder(IOrder order , User user){
        if(order.getStatus() != OrderState.Placed) throw new IllegalStateException("Order is already " + order.getStatus().toString() + " and can't be placed");
        order.setStatus(OrderState.Shipping);
        executorService.schedule(() -> {
            if (order.getStatus().equals(OrderState.Shipping)) {
                order.setStatus(OrderState.Shipped);
            }
        }, 4, TimeUnit.SECONDS);
    }
}
