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

        addDepartmentsToHospital(
                List.of("Ginekologija", "Hirurgija", "Interne bolesti",
                        "Pedijatrija", "Psihijatrija", "Očne bolesti",
                        "Laboratorija", "Dijagnostika", "Stacionar"),
                List.of("0475d06f-c43d-4cf2-828e-f1545e15f768", "b259d83b-e6fb-4b8b-8104-d96a6ad1ad5a",
                        "be7fed71-9a96-4644-8d0e-f80a216f77d6", "8436ec8b-19de-4d18-bd5c-469bd3512396",
                        "620763b5-a3f7-449f-86d9-fcff72aeaf32", "f8894d56-1263-4a9f-85a5-9e17dc9351ce",
                        "92c471d0-3980-41fb-a2bd-6a3e0e63e5e2", "29dde67e-d3a6-4983-babe-0a7b33c62608",
                        "c0979e25-2bb1-4582-87a9-aa175777a65d"),
                kbcZvezdara
        );

        addDepartmentsToHospital(
                List.of("Infektivne i tropske bolesti", "Interne bolesti",
                        "Psihijatrija", "Neurologija", "Hirurgija",
                        "Ginekologija i akušerstvo", "Očne bolesti",
                        "Dermatovenerologija", "Onkologija",
                        "Laboratorija", "Dijagnostika", "Stacionar"),
                List.of("a8b47778-52c2-4b02-9554-53e0196840ea", "50e3684b-e7d2-47c5-aa5d-0402f57ebe8d",
                        "72d0a198-5267-42f6-afc9-59d906bfe9c0","d8764da4-a048-4ed5-9efe-ae7ebb700a47",
                        "f3a3635d-f0d2-44c2-af25-06f18c72740c", "6d5ca2f5-6f71-462d-80c9-131ce39e8124",
                        "4eefde68-24f3-4492-b1ed-e0a70bc2e14e", "ec047d3c-fbac-4276-a526-7d353964bf96",
                        "fc39d46d-6662-42e8-80ca-9226eed4534d", "8c9169e8-01ff-4172-b537-9e816f102750",
                        "3f12eda8-5af1-45a1-9a2f-eff348fcf8b9", "a4e94a9a-d4cb-4323-831a-da823bf8ff7a"
                ),
                ukcSrbija
        );

        addDepartmentsToHospital(
                List.of("Interne bolesti", "Hirurgija",
                        "Onkologija", "Laboratorija", "Dijagnostika", "Stacionar"),
                List.of("baeeee67-231a-40e3-9f8f-7b0a609e25f1", "1647332e-2740-4839-adb7-762d8be6ac32",
                        "ed2245ca-a66b-4402-a654-ca2ec5926480", "ccbba084-b9f3-4fe5-bf90-714795b735ad",
                        "46f9e670-401d-4147-aab7-719d0047a941", "3e6eba4c-40a6-45d5-b20e-f4338c1c74d2"),
                kbcBezanijskaKosa
        );

        addDepartmentsToHospital(
                List.of("Interne bolesti", "Neurologija",
                        "Hirurgija", "Ginekologija i akušerstvo",
                        "Onkologija","Laboratorija", "Dijagnostika", "Stacionar", "Covid odsek"),
                List.of("4349eb95-d671-41c6-8cb1-389a45466cde", "c2de9275-ee7d-4994-85e7-ab433c843529",
                        "4260b200-9abf-42c5-acdf-8050fd55783e", "bf027665-8d73-4ec1-8f05-9e73ca4434a0",
                        "73e69114-7e40-4bd9-a69d-1599ba011baf", "13531c13-ac0b-465c-9b2c-56ecd5bf3474",
                        "4812d5d8-f43c-432a-a12c-7ff88c28fd4d", "49f62e58-d996-4f7d-bded-965a8719454f", "50869452-02f6-4ef7-8592-24d342cd70d1"),
                kbcZemun
        );

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

    private void addDepartmentsToHospital(List<String> departmentNames, List<String> uuids, Hospital hospital) {
        for(int i = 0; i < departmentNames.size(); i++) {
            Department department = new Department();
            department.setName(departmentNames.get(i));
            department.setDepartmentCode(UUID.fromString(uuids.get(i)));
            department.setHospital(hospital);

            departmentRepository.save(department);
        }
    }
}
