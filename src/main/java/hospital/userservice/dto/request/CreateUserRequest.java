package hospital.userservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotNull(message = "Field date of birth shouldn't be empty")
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
    @NotEmpty(message = "Field username shouldn't be empty")
    private String username;
    @NotEmpty(message = "Field password shouldn't be empty")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$",
             message = "Password should be between 8 and 20 characters," +
                       " contain at least 1 uppercase character," +
                       "digit and special character.")
    private String password;
    @NotEmpty(message = "Field title shouldn't be empty")
    private String title;
    @NotEmpty(message = "Field profession shouldn't be empty")
    private String profession;
    @NotNull(message = "Field department id shouldn't be empty")
    private Long departmentId;
    @NotNull(message = "Field permissions shouldn't be empty")
    private String[] permissions;

}
