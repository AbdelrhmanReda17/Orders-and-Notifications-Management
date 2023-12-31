package Application.Managers.OrderManager;

import Application.APIS.Orders.Model.CompoundOrder;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Products.Service.ProductService;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.Service.UserService;
import Application.Managers.ApplicationManager;

import java.util.concurrent.TimeUnit;

public class CompoundOrderManager extends OrderManager {

    public CompoundOrderManager(int numberOfOrders) {
        super(numberOfOrders);
    }

    @Override
    public void VerifyOrder(IOrder newOrder, User user) {
        ProductService.ValidateProduct(newOrder);
        if (newOrder.getPrice() > user.getPayment().getBalance()) {
            throw new IllegalStateException("Insufficient Funds for " + user.getUserCredentials().getUsername() + " who has id (" + user.getId() + ")");
        }
        for (IOrder order : ((CompoundOrder) newOrder).getOrderList()) {
            User dummmyUser = UserService.getUser(order);
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
    public void CancelOrder(IOrder order , User user) {
        try {
            if (order.getStatus() != OrderState.Placed) throw new IllegalStateException("Order is already " + order.getStatus().toString() + " and can't be cancelled");
            user.getPayment().Deposit(order.getPrice());
            for (IOrder o : ((CompoundOrder) order).getOrderList()) {
                ApplicationManager.numberOfOrders = ((CompoundOrder) order).getOrderList().size() + 1;
                ApplicationManager.ManageOrder(o, OrderState.Cancelled);
            }
            order.setStatus(OrderState.Cancelled);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
    @Override
    public void PlaceOrder(IOrder newOrder, User user) {
        try {
            if(newOrder.getStatus() != OrderState.Placed) throw new IllegalStateException("Order is already " + newOrder.getStatus().toString() + " and can't be placed");
            newOrder.setPrice(newOrder.getPrice() + (this.orderFee / (((CompoundOrder) newOrder).getOrderList().size() + 1)));
            user.getPayment().WithDraw(user, newOrder.getPrice());
            for (IOrder order : ((CompoundOrder) newOrder).getOrderList()) {
                order.setPrice(order.getPrice() + (this.orderFee / (((CompoundOrder) newOrder).getOrderList().size() + 1)));
                ApplicationManager.numberOfOrders = ((CompoundOrder) newOrder).getOrderList().size() + 1;
                ApplicationManager.ManageOrder(order, OrderState.Placed);
            }
            ProductService.UpdateProducts(newOrder, ProductService.getProducts(newOrder.getProducts()), OrderState.Placed);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    @Override
    public void CancelShipmentOrder(IOrder order, User user) {
        if(order.getStatus() != OrderState.Shipping) throw new IllegalStateException("Order is already " + order.getStatus().toString() + " and can't be cancelled");
        order.setPrice(order.getPrice() - (this.orderFee / (((CompoundOrder) order).getOrderList().size() + 1)));
        user.getPayment().Deposit(this.orderFee / (((CompoundOrder) order).getOrderList().size() + 1));
        for (IOrder o : ((CompoundOrder) order).getOrderList()) {
            o.setPrice(o.getPrice() - (this.orderFee / (((CompoundOrder) order).getOrderList().size() + 1)));
            ApplicationManager.numberOfOrders = ((CompoundOrder) order).getOrderList().size() + 1;
            ApplicationManager.ManageOrder(o, OrderState.CancelShipping);
        }
        order.setStatus(OrderState.CancelShipping);
    }
    @Override
    public void ShippingOrder(IOrder order , User user){
        if(order.getStatus() != OrderState.Placed) throw new IllegalStateException("Order is already " + order.getStatus().toString() + " and can't be placed");
        for (int i = 0; i < ((CompoundOrder) order).getOrderList().size(); i++) {
            ApplicationManager.numberOfOrders = ((CompoundOrder) order).getOrderList().size() + 1;
            ApplicationManager.ManageOrder(((CompoundOrder) order).getOrderList().get(i), OrderState.Shipping);
        }
        order.setStatus(OrderState.Shipping);
        executorService.schedule(() -> {
            if (order.getStatus().equals(OrderState.Shipping)) {
                ApplicationManager.ManageOrder(order, OrderState.Shipped);
            }
        }, 7, TimeUnit.SECONDS);
    }

    @Override
    public void ShippedOrder(IOrder order, User user ){
        if(order.getStatus() != OrderState.Shipping) throw new IllegalStateException("Order is already " + order.getStatus().toString() + " and can't be shipped");
        for (int i = 0; i < ((CompoundOrder) order).getOrderList().size(); i++) {
            ApplicationManager.numberOfOrders = ((CompoundOrder) order).getOrderList().size() + 1;
            ApplicationManager.ManageOrder(((CompoundOrder) order).getOrderList().get(i), OrderState.Shipped);
        }
        order.setStatus(OrderState.Shipped);
    }
}
