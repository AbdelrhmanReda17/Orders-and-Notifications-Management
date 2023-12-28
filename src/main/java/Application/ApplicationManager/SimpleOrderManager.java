package Application.ApplicationManager;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Users.Model.User;

import java.util.concurrent.TimeUnit;

public class SimpleOrderManager extends ApplicationManager {

    @Override
    public void CancelHandler(IOrder order, boolean isCompound) {
        try {
            User user = userRepository.findById(order.getUserId());
            user.getPayment().Deposit(order.getPrice());
            order.setStatus(OrderState.Cancelled);
        }
        catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    @Override
    public void VerifyOrder(IOrder order, User user) {
        if (user.getPayment().getBalance() < order.getPrice()) {
            throw new IllegalStateException("Insufficient Funds for " + user.getUserCredentials().getUsername() + " who has id (" + user.getId() + ")");
        }
    }

    @Override
    public void Process(IOrder newOrder , boolean isCompound, User user) {
        try {
            VerifyOrder(newOrder, user);
            user.getPayment().WithDraw(user,newOrder.getPrice() + (isCompound ? 0 : OrderFees));
            executorService.schedule(()->ApplicationManager.shipOrder(newOrder), 10, TimeUnit.SECONDS);
        }
        catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
