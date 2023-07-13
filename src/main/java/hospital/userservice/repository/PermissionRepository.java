package hospital.userservice.repository;

import hospital.userservice.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    @Query("SELECT p FROM permissions p WHERE p.name IN :permissionsList")
    List<Permission> checkIfPermissionsExist(List<String> permissionsList);
}
