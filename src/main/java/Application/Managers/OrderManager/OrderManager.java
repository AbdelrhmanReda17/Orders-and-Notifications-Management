package Application.Managers.OrderManager;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class OrderManager {
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
    public abstract void ShippingOrder(IOrder order , User user);
    public abstract void ShippedOrder(IOrder order, User user );
}
