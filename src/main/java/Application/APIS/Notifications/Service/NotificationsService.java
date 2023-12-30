package Application.APIS.Notifications.Service;

import Application.APIS.Notifications.Model.Notification;
import Application.APIS.Notifications.Model.NotificationFactory;
import Application.APIS.Notifications.NotificationsRepository;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Products.Model.Product;
import Application.APIS.Users.Model.User;
import Application.Utilities.Database.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class NotificationsService {
    private static DataRepository<Notification, Integer> notificationsRepository;
    public static void createOrderNotification(OrderState Type, List<Product> products, User user) {
        Notification notification = NotificationFactory.CreateNotification(Type , products , user);
        user.addNotification(notification.getId());
        ((NotificationsRepository)notificationsRepository).save(notification);
    }

    @Autowired
    public NotificationsService(NotificationsRepository notificationsRepository) {
        NotificationsService.notificationsRepository = notificationsRepository;
    }
    public Map<String, Integer> getNotifications() {
        return ((NotificationsRepository) notificationsRepository).getAll();
    }
    public Notification getMostNotifications() {
        Notification ntf = ((NotificationsRepository)notificationsRepository).getMostNotification();
        if(ntf == null){
            throw new IllegalArgumentException("No notifications found");
        }else{
            return ntf;
        }
    }
}

