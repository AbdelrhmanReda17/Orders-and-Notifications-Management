package Application.APIS.Users.Controller;

import Application.APIS.Users.Model.User;
import Application.APIS.Users.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "api/users")
public class UserController  {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        try {
            userService.updateUser(id, user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User updated successfully");
    }

    @PostMapping("/")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User added successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        try{
            userService.deleteUser(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User deleted successfully");
    }

}
