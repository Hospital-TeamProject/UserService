package hospital.userservice.mapper;

import hospital.userservice.dto.request.CreateUserRequest;
import hospital.userservice.dto.response.UserResponse;
import hospital.userservice.model.Department;
import hospital.userservice.model.Permission;
import hospital.userservice.model.User;
import hospital.userservice.model.enums.Profession;
import hospital.userservice.model.enums.Title;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserMapper {

    public User requestToModel(CreateUserRequest createUserRequest, Department department, List<Permission> permissions) {
        User user = new User();
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setDateOfBirth(createUserRequest.getDateOfBirth());
        user.setGender(createUserRequest.getGender());
        user.setJmbg(createUserRequest.getJmbg());
        user.setResidentialAddress(createUserRequest.getResidentialAddress());
        user.setPlaceOfLiving(createUserRequest.getPlaceOfLiving());
        user.setEmail(createUserRequest.getEmail());
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(createUserRequest.getPassword());
        user.setDepartment(department);
        user.setPermissions(permissions);

        if(createUserRequest.getPhone() != null) {
            user.setPhone(createUserRequest.getPhone());
        }

        Title title = Title.ValueOfNotation(createUserRequest.getTitle());
        Profession profession = Profession.ValueOfNotation(createUserRequest.getProfession());

        user.setProfession(profession);
        user.setTitle(title);

        return user;

    }

    public UserResponse modelToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmployeeId(user.getEmployeeId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setGender(user.getGender());
        userResponse.setJmbg(user.getJmbg());
        userResponse.setResidentialAddress(user.getResidentialAddress());
        userResponse.setPlaceOfLiving(user.getPlaceOfLiving());
        userResponse.setPhone(user.getPhone());
        userResponse.setEmail(user.getEmail());
        userResponse.setTitle(user.getTitle());
        userResponse.setProfession(user.getProfession());
        userResponse.setUsername(user.getUsername());
        userResponse.setDepartment(user.getDepartment());
        userResponse.setPermissions(user.getPermissions().stream().map(Permission::getName).collect(Collectors.toList()));

        return userResponse;
    }
}
