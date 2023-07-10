package hospital.userservice.mapper;

import hospital.userservice.dto.request.CreateUserRequest;
import hospital.userservice.model.Department;
import hospital.userservice.model.Permission;
import hospital.userservice.model.User;
import hospital.userservice.model.enums.Profession;
import hospital.userservice.model.enums.Title;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

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
}
