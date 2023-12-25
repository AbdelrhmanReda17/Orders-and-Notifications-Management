package Application.Utilities.Notification;

public class Notification {
    private final int notificationCounter;
    static int notificationNumber = 0;
    private final String notificationMessage;

    public Notification(int notificationCounter, String message) {
        this.notificationCounter = notificationCounter;
        this.notificationMessage = message;
        notificationNumber++;
    }
    public int getNotificationCounter() {
        return notificationCounter;
    }
    public static int getNotificationNumber() {
        return notificationNumber;
    }
    public String getNotificationMessage() {
        return notificationMessage;
    }
}
