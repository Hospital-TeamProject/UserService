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
public class HospitalResponse {

    private UUID hospitalCode;
    private String fullName;
    private String shortName;
    private String place;
    private String address;
}
