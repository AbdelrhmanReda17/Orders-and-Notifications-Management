package Application.APIS.Users;

import Application.APIS.Database.DataRepository;
import Application.APIS.Products.Model.Product;
import Application.APIS.Users.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository extends DataRepository<User, String> {
    public UserRepository() {
        super(User.class);
    }
}