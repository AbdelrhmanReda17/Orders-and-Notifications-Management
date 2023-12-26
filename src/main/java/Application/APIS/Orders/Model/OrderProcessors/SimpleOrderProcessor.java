package Application.APIS.Orders.Model.OrderProcessors;

import Application.APIS.Notifications.Controller.NotificationsController;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Notifications.Service.NotificationsService;
import Application.APIS.Users.Model.User;
import Application.APIS.Notifications.Model.Notification;
import Application.Utilities.Template.ITemplate;
import Application.Utilities.Template.TemplateFactory;

public class SimpleOrderProcessor extends IOrderProcessor{

    @Override
    public void Process(IOrder newOrder , boolean isCompound) {
        try {
            User user = userRepository.findById(newOrder.getUserId());
            user.getPayment().WithDraw(user,newOrder.getPrice() + (isCompound ? 0 : OrderFees));
            createOrderNotification(newOrder, user);
        }
        catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
