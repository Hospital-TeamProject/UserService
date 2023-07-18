package hospital.userservice.repository;

import hospital.userservice.dto.response.DepartmentResponse;
import hospital.userservice.model.Department;
import hospital.userservice.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByHospital(Hospital hospital);

    List<Department> findDepartmentsByName(String name);

    Optional<Department> findDepartmentByDepartmentCode(UUID departmentCode);
}
