package Application.Managers.UserManager;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;

public class UserManager {
    static UserRepository userRepository = new UserRepository();
    public static User getUser(IOrder order){
        return userRepository.findById(order.getUserId());
    }
}
