package hospital.userservice.dto.response;

import hospital.userservice.model.Department;
import hospital.userservice.model.Permission;
import hospital.userservice.model.enums.Profession;
import hospital.userservice.model.enums.Title;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class UserResponse {

    private Long id;
    private UUID employeeId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String jmbg;
    private String residentialAddress;
    private String placeOfLiving;
    private String phone;
    private String email;
    private Title title;
    private Profession profession;
    private String username;
    private Department department;
    private List<String> permissions;
}
