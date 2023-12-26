package Application.APIS.Users.Model.Payment;

import Application.APIS.Users.Model.User;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "paymentType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DummyWallet.class , name = "DummyWallet"),
})
public abstract class IPayment {
    double balance = 0f;
    public abstract void Deposit(double amount);
    public abstract void WithDraw(User user, double amount);
    public String getPaymentType() {
        return this.getClass().getSimpleName();
    }
    public double getBalance() {
        return balance;
    }
}
