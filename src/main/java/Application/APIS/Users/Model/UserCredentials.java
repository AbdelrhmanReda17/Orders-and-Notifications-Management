package Application.APIS.Users.Model;

public class UserCredentials {
    String username;
    String email;
    String password;
    String phoneNumber;
    String address;
    String country;
    String state;

    public UserCredentials(String username, String password, String phoneNumber, String state , String country , String address , String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.country = country;
        this.state = state;
    }

    public void copy(UserCredentials newUserCredentials) {
        this.username = newUserCredentials.getUsername();
        this.password = newUserCredentials.getPassword();
        this.phoneNumber = newUserCredentials.getPhoneNumber();
        this.address = newUserCredentials.getAddress();
        this.country = newUserCredentials.getCountry();
        this.state = newUserCredentials.getState();
        this.email = newUserCredentials.getEmail();
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

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }
}
