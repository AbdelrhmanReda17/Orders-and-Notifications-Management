package Application.Utilities.OrderProcessors;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleOrderProcessor implements IOrderProcessor{

    @Override
    public void Process(IOrder newOrder) {
        SimpleOrder simpleOrder = (SimpleOrder) newOrder;
        try {
            User user = userRepository.findById(newOrder.getUserId());
            user.getWallet().WithDraw(user,newOrder.getPrice());

        }
        catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }

    }
}
