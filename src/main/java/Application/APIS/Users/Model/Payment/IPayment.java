package Application.APIS.Users.Model.Payment;

import Application.APIS.Users.Model.User;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "paymentType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DummyWallet.class , name = "DummyWallet"),
})
public abstract class IPayment {
    double balance = 0f;
    public abstract void Deposit(double amount);
    public abstract void WithDraw(User user, double amount);
    public double getBalance() {
        return balance;
    }
}
