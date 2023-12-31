package Application.APIS.Users.Model;


import Application.APIS.Users.Model.Payment.IPayment;
import Application.Utilities.Database.IModel;


import java.util.LinkedList;
import java.util.List;



public class User implements IModel<Integer>{
    int id;
    List<Integer> notifications;
    UserCredentials userCredentials;
    IPayment payment;
    String language;
    String template;
    public User(){}
    public User(UserCredentials userCredentials,IPayment payment, String language , String template) {
        this.userCredentials = userCredentials;
        this.payment = payment;
        this.language = language;
        this.template = template;
        this.notifications = new LinkedList<>();
    }
    public User(int id ,UserCredentials userCredentials,IPayment payment, String language , String template) {
        this.id = id;
        this.userCredentials = userCredentials;
        this.payment = payment;
        this.language = language;
        this.template = template;
        this.notifications = new LinkedList<>();
    }
    @Override
    public Integer getId() {
        return id;
    }
    public List<Integer> getNotifications() {
        return notifications;
    }
    public void setNotifications(List<Integer> notifications) {
        this.notifications = notifications;
    }
    public void addNotification(int notificationId) {
        this.notifications.add(notificationId);
    }
    @Override
    public void setId(Integer id) {
        this.id=id;
    }
    public UserCredentials getUserCredentials() {
        return userCredentials;
    }
    public void copy(User newUser) {
        this.notifications = newUser.getNotifications();
        this.userCredentials = newUser.getUserCredentials();
        this.payment = newUser.getPayment();
        this.language = newUser.getLanguage();
        this.template = newUser.getTemplate();
    }
    public IPayment getPayment() {
        return payment;
    }
    public String getLanguage() {
        return language;
    }
    public String getTemplate() {
        return template;
    }
}
