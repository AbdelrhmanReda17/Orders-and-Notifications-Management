package Application.Managers.NotificationManager;

import Application.APIS.Notifications.Model.Notification;
import Application.APIS.Notifications.Model.NotificationFactory;
import Application.APIS.Notifications.NotificationsRepository;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Products.Model.Product;
import Application.APIS.Users.Model.User;

import java.util.List;

public class NotificationManager {
    static NotificationsRepository notificationsRepository = new NotificationsRepository();
    public static void createOrderNotification(OrderState Type, List<Product> products, User user) {
        Notification notification = NotificationFactory.CreateNotification(Type , products , user);
        user.addNotification(notification.getId());
        notificationsRepository.save(notification);
    }

}
