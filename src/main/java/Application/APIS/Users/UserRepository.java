package Application.APIS.Users;

import Application.APIS.Users.Model.Payment.DummyWallet;
import Application.APIS.Users.Model.UserCredentials;
import Application.Utilities.Database.DataRepository;
import Application.APIS.Users.Model.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository extends DataRepository<User, Integer> {
    public UserRepository() {
        super(User.class);
    }
    public int getNextId() {
        return this.data.size() + 1;
    }

}
