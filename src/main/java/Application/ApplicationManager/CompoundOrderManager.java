package Application.ApplicationManager;

import Application.APIS.Orders.Model.CompoundOrder;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Users.Model.User;
import java.util.concurrent.TimeUnit;

public class CompoundOrderManager extends ApplicationManager {
    @Override
    public void VerifyOrder(IOrder newOrder, User user) {
        if (newOrder.getPrice() > user.getPayment().getBalance()) {
            throw new IllegalStateException("Insufficient Funds for " + user.getUserCredentials().getUsername() + " who has id (" + user.getId() + ")");
        }
        for (IOrder order : ((CompoundOrder) newOrder).getOrderList()) {
            User dummmyUser = userRepository.findById(order.getUserId());
            if (dummmyUser.getPayment().getBalance() < order.getPrice()) {
                throw new IllegalStateException("Insufficient Funds for " + dummmyUser.getUserCredentials().getUsername() + " who has id (" + dummmyUser.getId() + ")");
            }
            if (!dummmyUser.getUserCredentials().getCountry().equals(user.getUserCredentials().getCountry())) {
                throw new IllegalStateException("Orders in compound order must be from the same country");
            }
            if (!dummmyUser.getUserCredentials().getCity().equals(user.getUserCredentials().getCity())) {
                throw new IllegalStateException("Orders in compound order must be from the same city");
            }
        }
    }

    @Override
    public void CancelHandler(IOrder order, boolean isCompound) {
        try {
            if(order.getStatus() == OrderState.Placement){ return; }
            User user = userRepository.findById(order.getUserId());
            user.getPayment().Deposit(order.getPrice());
            for (IOrder o : ((CompoundOrder) order).getOrderList()) {
                OrderProcessorFactory.CreateOrderProcessor(o).ManageOrder(o, true,OrderState.Cancelled);
            }

            order.setStatus(OrderState.Cancelled);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    @Override
    public void Process(IOrder newOrder, boolean isCompound, User user) {
        try {
            VerifyOrder(newOrder, user);
            newOrder.setPrice(newOrder.getPrice() + (OrderFees / (((CompoundOrder) newOrder).getOrderList().size() + 1)));
            user.getPayment().WithDraw(user, newOrder.getPrice());
            for (IOrder order : ((CompoundOrder) newOrder).getOrderList()) {
                order.setPrice(order.getPrice() + (OrderFees / (((CompoundOrder) newOrder).getOrderList().size() + 1)));
                OrderProcessorFactory.CreateOrderProcessor(order).ManageOrder(order, true,OrderState.Placed);
            }
            executorService.schedule(()->ApplicationManager.shipOrder(newOrder), 10, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

}
