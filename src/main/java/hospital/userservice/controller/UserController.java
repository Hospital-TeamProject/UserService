package hospital.userservice.controller;

import hospital.userservice.dto.request.CreateUserRequest;
import hospital.userservice.dto.request.UpdateUserRequest;
import hospital.userservice.dto.response.UserResponse;
import hospital.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<UserResponse> getUserByEmployeeId(@PathVariable UUID employeeId) {
        return ResponseEntity.ok(userService.getUserByEmployeeId(employeeId));
    }

//    @PutMapping("/{employeeId}")
//    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID employeeId, @Valid UpdateUserRequest updateUserRequest) {
//        return ResponseEntity.ok(userService.updateUser(employeeId,updateUserRequest));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

}
