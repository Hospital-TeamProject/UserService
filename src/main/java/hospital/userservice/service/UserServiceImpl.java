package hospital.userservice.service;

import hospital.userservice.dto.request.CreateUserRequest;
import hospital.userservice.dto.response.UserResponse;
import hospital.userservice.exception.NotFoundException;
import hospital.userservice.mapper.UserMapper;
import hospital.userservice.model.Department;
import hospital.userservice.model.Permission;
import hospital.userservice.model.User;
import hospital.userservice.repository.DepartmentRepository;
import hospital.userservice.repository.PermissionRepository;
import hospital.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final PermissionRepository permissionRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        Department department = departmentRepository.findById(createUserRequest.getDepartmentId())
                .orElseThrow(() -> {
                        throw new NotFoundException("Department with given id doesn't exist");
                    }
                );

        List<Permission> permissions = permissionRepository.checkIfPermissionsExist(Arrays.asList(createUserRequest.getPermissions()));

        User user = userRepository.save(userMapper.requestToModel(createUserRequest,department,permissions));

        return userMapper.modelToResponse(user);
    }

    @Override
    public UserResponse getUserByEmployeeId(UUID employeeId) {
        User user = userRepository.findUserByEmployeeId(employeeId).orElseThrow(() -> {
            throw new NotFoundException(String.format("User with employeeId {} doesn't exist.",employeeId));
        });

        return userMapper.modelToResponse(user);
    }
}
