package hospital.userservice.repository;

import hospital.userservice.dto.response.DepartmentResponse;
import hospital.userservice.model.Department;
import hospital.userservice.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByHospital(Hospital hospital);
}
