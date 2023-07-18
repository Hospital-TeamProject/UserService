package hospital.userservice.bootstrap;

import hospital.userservice.model.Permission;
import hospital.userservice.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final PermissionRepository permissionsRepository;

    @Override
    public void run(String... args) throws Exception {

        Permission adminPermission = addPermission("ROLE_ADMIN");
    }

    private Permission addPermission(String role) {
        Permission permission = new Permission();
        permission.setName(role);
        permissionsRepository.save(permission);

        return permission;
    }
}
