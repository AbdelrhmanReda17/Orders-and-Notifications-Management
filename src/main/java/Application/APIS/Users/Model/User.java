package Application.APIS.Users.Model;

import Application.Database.IModel;

public class User implements IModel {
    int id;
    UserCredentials userCredentials;
    IWallet userWallet;
    String language;
    String template;

    public User(int id,UserCredentials userCredentials,IWallet userWallet, String language , String template) {
        this.id = id;
        this.userCredentials = userCredentials;
        this.userWallet = userWallet;
        this.language = language;
        this.template = template;
    }
    public int getId() {
        return id;
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
}
