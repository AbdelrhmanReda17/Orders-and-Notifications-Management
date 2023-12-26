package Application.APIS.Users.Model.Payment;

import Application.APIS.Users.Model.User;

public class DummyWallet extends IPayment {
    public DummyWallet() {this.balance = 0f;}
    public DummyWallet(double balance) {
        this.balance = balance;
    }
    @Override
    public void Deposit(double amount) {
        balance += amount;
    }
    @Override
    public void WithDraw(User user, double amount) {
        if (balance >= amount) {
            balance -= amount;
            return;
        }
        throw new IllegalStateException("Insufficient Funds for " + user.getUserCredentials().getUsername() + " who has id (" + user.getId() + ")");
    }
}
