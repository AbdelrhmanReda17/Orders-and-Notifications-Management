package Application.APIS.Users.Service;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;
import Application.Utilities.Database.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static DataRepository<User, Integer> userRepository;

    @Autowired
    public UserService(UserRepository userRepository ) {
        UserService.userRepository = userRepository;
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public static User getUser(IOrder order){
        return userRepository.findById(order.getUserId());
    }
    public void deleteUser(int id) {
        if(!userRepository.existsById(id)) {
            throw new IllegalStateException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }

    public void updateUser(int id, User newUser) {
        try{
            User existingUser = userRepository.findById(id);
            existingUser.copy(newUser);
            userRepository.update(existingUser);
        }catch (Exception e){
            throw new IllegalStateException("User with id " + id + " does not exist");
        }

    }

    public void addUser(User newUser) {
        try {
            newUser.setId(((UserRepository)userRepository).getNextId());
            userRepository.save(newUser);
        } catch (Exception e) {
            throw new IllegalStateException("User with id " + newUser.getId() + " already exists");
        }
    }

    public User getUser(int id) {
        try {
            return userRepository.findById(id);
        }catch(Exception e){
              throw new IllegalStateException("User with id " + id + " does not exist");
        }
    }

}
