package Application.APIS.Users.Model;

public class DummyWallet implements IPayment {
    double balance = 0f;
    public DummyWallet(double balance) {
        this.balance = balance;
    }
    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public void WithDraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalStateException("Insufficient Funds!");
        }
    }
}
