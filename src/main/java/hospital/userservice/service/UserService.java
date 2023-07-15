package hospital.userservice.service;

import hospital.userservice.dto.request.CreateUserRequest;
import hospital.userservice.dto.request.UpdateUserRequest;
import hospital.userservice.dto.response.UserResponse;

import java.util.UUID;

public interface UserService {
    UserResponse createUser(CreateUserRequest user);

    UserResponse getUserByEmployeeId(UUID employeeId);

//    UserResponse updateUser(UUID employeeId, UpdateUserRequest updateUserRequest);

    UserResponse deleteUser(Long id);
}
