package hospital.userservice.controller;

import hospital.userservice.model.User;
import hospital.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    public ResponseEntity<User> createUser(User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}
