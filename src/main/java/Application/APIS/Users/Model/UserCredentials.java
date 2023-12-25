package Application.APIS.Users.Model;

public class UserCredentials {
    String username;
    String email;
    String password;
    String phoneNumber;
    String address;
    public UserCredentials(String username, String password, String phoneNumber, String address , String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void copy(UserCredentials newUserCredentials) {
        this.username = newUserCredentials.getUsername();
        this.password = newUserCredentials.getPassword();
        this.phoneNumber = newUserCredentials.getPhoneNumber();
        this.address = newUserCredentials.getAddress();
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }
}
