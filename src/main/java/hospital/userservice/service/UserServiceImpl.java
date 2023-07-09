package hospital.userservice.service;

import hospital.userservice.dto.request.CreateUserRequest;
import hospital.userservice.dto.response.UserResponse;
import hospital.userservice.model.User;
import hospital.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(CreateUserRequest user) {

        return userRepository.save(user);
    }
}
