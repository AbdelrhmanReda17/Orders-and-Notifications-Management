package Application.APIS.Notifications.Model;

import Application.APIS.Users.Model.User;
import Application.Utilities.Database.IModel;

public class Notification  {
    private String notificationMessage;
    private static int notificationNumber = 0;
    private final String notificationMessageTemplate;
    public Notification(String message, String notificationMessageTemplate, User user) {
        this.notificationMessage = message;
        this.notificationMessageTemplate = notificationMessageTemplate;
        user.setNotificationCount(user.getNotificationCount() + 1);
        notificationNumber++;
    }
    public String getNotificationMessage() {
        return notificationMessageTemplate;
    }
    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }
}
