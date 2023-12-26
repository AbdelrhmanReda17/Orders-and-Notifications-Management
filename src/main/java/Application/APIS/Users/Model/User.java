package Application.APIS.Users.Model;

import Application.APIS.Orders.Model.CompoundOrder;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.APIS.Users.Model.Payment.DummyWallet;
import Application.APIS.Users.Model.Payment.IPayment;
import Application.Utilities.Database.IModel;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DummyWallet.class , name = "DummyWallet"),
})
public class User implements IModel{
    int id;
    int NotificationCount = 0;
    UserCredentials userCredentials;
    IPayment payment;
    String language;
    String template;
    public User(int id,UserCredentials userCredentials,IPayment payment, String language , String template) {
        this.id = id;
        this.userCredentials = userCredentials;
        this.payment = payment;
        this.language = language;
        this.template = template;
    }
    public int getId() {
        return id;
    }
    public void setNotificationCount(int notificationCount) {
        NotificationCount = notificationCount;
    }
    public int getNotificationCount() {
        return NotificationCount;
    }
    @Override
    public void setId(int id) {
        this.id=id;
    }
    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }
    public UserCredentials getUserCredentials() {
        return userCredentials;
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
