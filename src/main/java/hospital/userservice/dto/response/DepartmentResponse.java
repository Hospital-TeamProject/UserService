package hospital.userservice.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class DepartmentResponse {

    private UUID departmentCode;
    private String name;
    private HospitalResponse hospitalResponse;
}
