package Application.APIS.Notifications;

import Application.Utilities.Database.DataRepository;
import Application.APIS.Notifications.Model.Notification;
import Application.Utilities.Template.ITemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Repository
public class NotificationsRepository extends DataRepository<Notification, Integer>{
    public NotificationsRepository() {
        super(Notification.class);
    }

    private static final Map<Notification , Integer> notificationsSentQueue = new HashMap<>();

    public void save(Notification notification) {
        data.add(notification);
        System.out.println("Notification added");
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(this::popNotification, 10, TimeUnit.SECONDS);
        System.out.println("Notification scheduled to be removed in 10 seconds");
        executorService.shutdown();

    }
    public void popNotification() {
        Notification notification = data.remove(0);
        notification.setNotificationMessage(null);
        for (Notification n : notificationsSentQueue.keySet()){
            if(Objects.equals(n.getNotificationMessage(), notification.getNotificationMessage())) {
                notificationsSentQueue.put(n, notificationsSentQueue.get(n) + 1);
                return;
            }
        }
        notificationsSentQueue.put(notification , 1);
    }
    public Notification getMostNotification() {
        Notification notification = null;
        for (Notification n :  notificationsSentQueue.keySet()){
            if(notification == null){
                notification = n;
            }else{
                if(notificationsSentQueue.get(n) > notificationsSentQueue.get(notification)){
                    notification = n;
                }
            }
        }
        return notification;
    }

}
