package Application.APIS.Users;

import Application.Database.DataRepository;
import Application.APIS.Users.Model.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository extends DataRepository<User, Integer> {
    public UserRepository() {
        super(User.class);
    }
}