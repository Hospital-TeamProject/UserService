package hospital.userservice.service;

import hospital.userservice.dto.response.DepartmentResponse;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    List<DepartmentResponse> getDepartmentsByHospital(UUID hospitalCode);

    List<DepartmentResponse> getAllDepartments();

    List<DepartmentResponse> getDepartmentsByName(String name);

    DepartmentResponse getDepartmentByDepartmentCode(UUID departmentCode);
}
