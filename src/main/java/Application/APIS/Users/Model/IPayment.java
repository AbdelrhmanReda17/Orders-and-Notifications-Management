package Application.APIS.Users.Model;

public interface IPayment {
    public void Deposit(double amount);
    public void WithDraw(User user,double amount);
}
