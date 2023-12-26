package Application.APIS.Notifications.Model;

import Application.APIS.Users.Model.User;
import Application.Utilities.Database.IModel;

public class Notification implements IModel  {
    public String notificationMessage;
    private static int notificationNumber = 0;
    private final String notificationMessageTemplate;
    private int notificationId = 0;
    public Notification(String message, String notificationMessageTemplate) {
        this.notificationMessage = message;
        this.notificationMessageTemplate = notificationMessageTemplate;
        notificationNumber++;
        notificationId = notificationNumber;
    }

    public String getNotificationMessage() {
        return notificationMessageTemplate;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    @Override
    public int getId() {
        return notificationId;
    }
    @Override
    public void setId(int id) {
        this.notificationId = id;
    }
}
