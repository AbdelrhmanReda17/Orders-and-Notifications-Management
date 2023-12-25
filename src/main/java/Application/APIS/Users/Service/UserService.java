package Application.APIS.Users.Service;

import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository ) {
        this.userRepository = userRepository;
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
            existingUser.getUserCredentials().copy(newUser.getUserCredentials());
            userRepository.save(existingUser);
        }catch (Exception e){
            throw new IllegalStateException("User with id " + id + " does not exist");
        }

    }

    public void addUser(User newUser) {
        try {
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
