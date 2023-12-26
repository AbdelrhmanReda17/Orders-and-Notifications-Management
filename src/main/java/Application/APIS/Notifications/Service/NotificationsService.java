package Application.APIS.Notifications.Service;

import Application.APIS.Notifications.Model.Notification;
import Application.APIS.Notifications.NotificationsRepository;
import Application.Utilities.Template.ITemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class NotificationsService {
    private static NotificationsRepository notificationsRepository;
    @Autowired
    public NotificationsService(NotificationsRepository notificationsRepository) {
        NotificationsService.notificationsRepository = notificationsRepository;
    }
    public static void addNotification(Notification notification) {
        notificationsRepository.save(notification);
        AppendToFile(notification);
    }
    public static Notification getMostNotifications() {
        Notification ntf = notificationsRepository.getMostNotification();
        if(ntf == null){
            throw new IllegalArgumentException("No notifications found");
        }else{
            return ntf;
        }
    }
    public static void AppendToFile(Notification notification) {
        try {
            FileWriter fw = new FileWriter("notifications.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(notification.getNotificationMessage());
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void RemoveFromFile(Notification notificationToRemove) {
        try {
            File inputFile = new File("notifications.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

            String lineToRemove = notificationToRemove.getNotificationMessage();
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.equals(lineToRemove)) continue;
                writer.println(currentLine);
            }

            writer.close();
            reader.close();

            tempFile.renameTo(inputFile);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

