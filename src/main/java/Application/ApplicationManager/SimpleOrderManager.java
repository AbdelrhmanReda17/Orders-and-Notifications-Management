package Application.ApplicationManager;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Users.Model.User;

public class SimpleOrderManager extends ApplicationManager {

    @Override
    public void Process(IOrder newOrder , boolean isCompound) {
        try {
            User user = userRepository.findById(newOrder.getUserId());
            user.getPayment().WithDraw(user,newOrder.getPrice() + (isCompound ? 0 : OrderFees));
        }
        catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
