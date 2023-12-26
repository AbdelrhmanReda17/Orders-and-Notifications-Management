package Application.APIS.Orders.Model.OrderProcessors;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;

public interface IOrderProcessor {
    UserRepository userRepository = new UserRepository();
    public void Process(IOrder newOrder);
}