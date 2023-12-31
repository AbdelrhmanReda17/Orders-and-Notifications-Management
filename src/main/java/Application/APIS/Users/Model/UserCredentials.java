package Application.APIS.Users.Model;

public class UserCredentials {
    String username;
    String email;
    String password;
    String phoneNumber;
    String address;
    String city;
    String country;

    public UserCredentials(String username, String password, String phoneNumber, String country ,String city ,  String address , String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.country = country;
        this.city = city;
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

    public String getCity() {
        return city;
    }
}
