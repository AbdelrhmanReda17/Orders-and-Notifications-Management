package Application.Utilities.OrderProcessors;

import Application.APIS.Orders.Model.CompoundOrder;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;

public class CompoundOrderProcessor implements IOrderProcessor{
    @Override
    public void Process(IOrder newOrder) {
        try {
            CompoundOrder compoundOrder = (CompoundOrder) newOrder;
            User user = userRepository.findById(newOrder.getUserId());
            user.getWallet().WithDraw(user, compoundOrder.getPrice());
            for (IOrder order : compoundOrder.getOrderList()) {
                Process(order);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
