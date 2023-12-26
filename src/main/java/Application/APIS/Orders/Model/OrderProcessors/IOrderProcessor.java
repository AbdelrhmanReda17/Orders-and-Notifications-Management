package Application.APIS.Orders.Model.OrderProcessors;

import Application.APIS.Notifications.Controller.NotificationsController;
import Application.APIS.Notifications.Model.Notification;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;
import Application.Utilities.Template.ITemplate;
import Application.Utilities.Template.TemplateFactory;

import java.io.FileNotFoundException;

public abstract class IOrderProcessor {
    double OrderFees = 120;
    UserRepository userRepository = new UserRepository();
    public abstract void Process(IOrder newOrder , boolean isCompound);
    static void createOrderNotification(IOrder newOrder, User user) throws FileNotFoundException {
        ITemplate template = TemplateFactory.createTemplate(user.getTemplate() , user.getLanguage());
        Notification notification = new Notification(
                template.OrderMessage(user.getUserCredentials().getUsername() , newOrder , false),
                template.OrderMessage(user.getUserCredentials().getUsername() , newOrder , true)
        );
        user.addNotification(notification.getId());
        NotificationsController.addNotification(notification);
    }
}
