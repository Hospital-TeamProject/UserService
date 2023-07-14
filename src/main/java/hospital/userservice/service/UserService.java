package hospital.userservice.service;

import hospital.userservice.dto.request.CreateUserRequest;
import hospital.userservice.dto.response.UserResponse;
import hospital.userservice.model.User;

import java.util.UUID;

public interface UserService {
    UserResponse createUser(CreateUserRequest user);

    UserResponse getUserByEmployeeId(UUID employeeId);
}
