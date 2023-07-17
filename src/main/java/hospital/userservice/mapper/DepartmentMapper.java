package hospital.userservice.mapper;

import hospital.userservice.dto.response.DepartmentResponse;
import hospital.userservice.dto.response.HospitalResponse;
import hospital.userservice.model.Department;
import hospital.userservice.model.Hospital;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
    public DepartmentResponse modelToDepartmentResponse(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();

        departmentResponse.setDepartmentCode(department.getDepartmentCode());
        departmentResponse.setName(department.getName());
        departmentResponse.setHospitalResponse(modelToHospitalResponse(department.getHospital()));

        return departmentResponse;
    }

    public HospitalResponse modelToHospitalResponse(Hospital hospital) {
        HospitalResponse hospitalResponse = new HospitalResponse();

        hospitalResponse.setHospitalCode(hospital.getHospitalCode());
        hospitalResponse.setAddress(hospital.getAddress());
        hospitalResponse.setPlace(hospital.getPlace());
        hospitalResponse.setFullName(hospital.getFullName());
        hospitalResponse.setShortName(hospital.getShortName());

        return hospitalResponse;
    }
}
