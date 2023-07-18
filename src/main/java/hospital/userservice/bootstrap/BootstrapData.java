package hospital.userservice.bootstrap;

import hospital.userservice.model.Department;
import hospital.userservice.model.Hospital;
import hospital.userservice.model.Permission;
import hospital.userservice.repository.DepartmentRepository;
import hospital.userservice.repository.HospitalRepository;
import hospital.userservice.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final PermissionRepository permissionsRepository;
    private final HospitalRepository hospitalRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Hospital kbcZvezdara = addHospital("Kliničko bolnički centar \"Zvezdara\"","KBC Zvezdara","Beograd","Dimitrija Tucovića 161");


        Hospital ukcSrbija = addHospital("Univerzitetski klinički centar Srbije","UKC Srbije","Beograd","Pasterova 2");


        Hospital kbcBezanijskaKosa = addHospital("Kliničko bolnički centar \"Bežanijska kosa\"", "KBC Bežanijska kosa","Beograd", "Bezanijska kosa bb");


        Hospital kbcZemun = addHospital("Kliničko bolnički centar \"Zemun\"", "KBC Zemun","Beograd", "Vukova 9");

        Permission adminPermission = addPermission("ROLE_ADMIN");
    }

    private Permission addPermission(String role) {
        Permission permission = new Permission();
        permission.setName(role);
        permissionsRepository.save(permission);

        return permission;
    }

    private Hospital addHospital(String fullName, String shortName, String place, String address) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Hospital hospital = new Hospital();

        hospital.setHospitalCode(UUID.randomUUID());
        hospital.setFullName(fullName);
        hospital.setShortName(shortName);
        hospital.setPlace(place);
        hospital.setAddress(address);

        return hospitalRepository.save(hospital);
    }

    private void addDepartmentToHospital(List<String> departmentNames, List<String> uuids, Hospital hospital) {
        for(int i = 0; i < departmentNames.size(); i++) {
            Department department = new Department();
            department.setName(departmentNames.get(i));
            department.setDepartmentCode(UUID.fromString(uuids.get(i)));
            department.setHospital(hospital);

            departmentRepository.save(department);
        }
    }
}
