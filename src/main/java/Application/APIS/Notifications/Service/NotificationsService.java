package Application.APIS.Notifications.Service;

import Application.APIS.Notifications.Model.Notification;
import Application.APIS.Notifications.NotificationsRepository;
import Application.Utilities.Template.ITemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;


@Service
public class NotificationsService {
    private final NotificationsRepository notificationsRepository;
    @Autowired
    public NotificationsService(NotificationsRepository notificationsRepository) {
        this.notificationsRepository = notificationsRepository;
    }
    public void addNotification(Notification notification) {
        this.notificationsRepository.save(notification);
    }
    public Map<Notification, Integer> getNotifications() {
        return this.notificationsRepository.getAll();
    }
    public Notification getMostNotifications() {
        Notification ntf = this.notificationsRepository.getMostNotification();
        if(ntf == null){
            throw new IllegalArgumentException("No notifications found");
        }else{
            return ntf;
        }
    }
}

