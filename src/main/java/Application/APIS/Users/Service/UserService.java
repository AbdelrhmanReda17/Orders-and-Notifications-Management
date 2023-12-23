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

    public void deleteUser(String id) {
        if(!userRepository.existsById(id)) {
            throw new IllegalStateException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }

    public void updateUser(String id, User newUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User with id " + id + " does not exist"));
        existingUser.copy(newUser);
        userRepository.save(existingUser);
    }

    public void addUser(User newUser) {
        try {
            userRepository.save(newUser);
        } catch (Exception e) {
            throw new IllegalStateException("User with id " + newUser.getId() + " already exists");
        }
    }

    public User getUser(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User with id " + id + " does not exist"));
    }

}
