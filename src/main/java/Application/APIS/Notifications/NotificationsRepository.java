package Application.APIS.Notifications;

import Application.ApplicationManager.ApplicationManager;
import Application.Utilities.Database.DataRepository;
import Application.APIS.Notifications.Model.Notification;
import Application.Utilities.Template.ITemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
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
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private final Map<Notification , Integer> notificationsSentQueue = new HashMap<>();

    public void save(Notification notification) {
        ApplicationManager.AppendToFile(notification);
        data.add(notification);
        executorService.schedule(() -> popNotification(notification), 10, TimeUnit.SECONDS);
    }
    public void popNotification(Notification notification) {
        data.remove(notification);
        notification.setNotificationMessage(null);
        notification.setId(0);
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
    public Map<String , Integer> getAll() {
        Map<String , Integer> notificationsSent = new HashMap<>();
        for (Notification n :  notificationsSentQueue.keySet()){
            notificationsSent.put(n.getNotificationMessage() , notificationsSentQueue.get(n));
        }
        return notificationsSent;
    }

}
