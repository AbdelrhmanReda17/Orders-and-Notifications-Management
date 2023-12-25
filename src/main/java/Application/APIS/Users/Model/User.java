package Application.APIS.Users.Model;

import Application.APIS.Database.IModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User implements IModel {
    @Id
    int id;
    String username;
    String password;
    String phoneNumber;
    String address;

    public User(int id, String username, String password, String phoneNumber, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    public void copy(User newUser) {
        this.username = newUser.getUsername();
        this.password = newUser.getPassword();
        this.phoneNumber = newUser.getPhoneNumber();
        this.address = newUser.getAddress();
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
