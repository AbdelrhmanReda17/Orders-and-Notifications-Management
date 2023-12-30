package Application.Managers.OrderManager;

import Application.APIS.Orders.Model.CompoundOrder;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Users.Model.User;
import Application.Managers.ProductManager.ProductManager;

public class SimpleOrderManager extends OrderManager {

    public SimpleOrderManager(int numberOfOrders) {
        super(numberOfOrders);
    }
    @Override
    public void CancelOrder(IOrder order, User user) {
        try {
            if ( order.getStatus() != OrderState.Placed) throw new IllegalStateException("Order is already " + order.getStatus().toString() + " and can't be cancelled");
            user.getPayment().Deposit(order.getPrice());
            order.setStatus(OrderState.Cancelled);
        }
        catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    @Override
    public void VerifyOrder(IOrder order, User user) {
        ProductManager.ValidateProduct(order);
        if (user.getPayment().getBalance() < order.getPrice()) {
            throw new IllegalStateException("Insufficient Funds for " + user.getUserCredentials().getUsername() + " who has id (" + user.getId() + ")");
        }
    }

    @Override
    public void PlaceOrder(IOrder newOrder , User user) {
        try {
            if(newOrder.getStatus() != OrderState.Placed) throw new IllegalStateException("Order is already " + newOrder.getStatus().toString() + " and can't be placed");
            VerifyOrder(newOrder, user);
            user.getPayment().WithDraw(user,newOrder.getPrice() + (numberOfOrders != 1 ? 0 : this.orderFee));
            ProductManager.UpdateProducts(newOrder, ProductManager.getProducts(newOrder.getProducts()), OrderState.Placed);
        }
        catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
    @Override
    public void CancelShipmentOrder(IOrder order, User user) {
        if( order.getStatus() != OrderState.Shipping) throw new IllegalStateException("Order is already " + order.getStatus().toString() + " and can't be cancelled");
        order.setStatus(OrderState.CancelShipping);
        user.getPayment().Deposit((numberOfOrders == 1 ? this.orderFee: this.orderFee / numberOfOrders));
    }

}
