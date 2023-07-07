package hospital.userservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserRequest {
    @NotEmpty(message = "Field first name shouldn't be empty")
    private String firstName;
    @NotEmpty(message = "Field last name shouldn't be empty")
    private String lastName;
    @NotEmpty(message = "Field date of birth shouldn't be empty")
    private Date dateOfBirth;
    @NotEmpty(message = "Field gender shouldn't be empty")
    private String gender;
    @NotEmpty(message = "Field jmbg shouldn't be empty")
    private String jmbg;
    @NotEmpty(message = "Field residential address shouldn't be empty")
    private String residentialAddress;
    @NotEmpty(message = "Field place of living shouldn't be empty")
    private String placeOfLiving;
    private String phone;
    @NotEmpty(message = "Field email shouldn't be empty")
    @Email(message = "Email should be in correct format")
    private String email;
    @NotEmpty(message = "Field title shouldn't be empty")
    private String title;
    @NotEmpty(message = "Field profession shouldn't be empty")
    private String profession;
    @NotEmpty(message = "Field department id shouldn't be empty")
    private Long departmentId;
    @NotEmpty(message = "Field permissions shouldn't be empty")
    private String[] permissions;
}
