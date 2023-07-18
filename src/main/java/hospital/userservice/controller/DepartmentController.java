package hospital.userservice.controller;

import hospital.userservice.dto.response.DepartmentResponse;
import hospital.userservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping("/{hospitalCode}")
    public ResponseEntity<List<DepartmentResponse>> getDepartmentsByHospital(@PathVariable UUID hospitalCode) {
        return ResponseEntity.ok(departmentService.getDepartmentsByHospital(hospitalCode));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<DepartmentResponse>> getDepartmentsByName(@PathVariable String name) {
        return ResponseEntity.ok(departmentService.getDepartmentsByName(name));
    }

    @GetMapping("/departmentCode/{departmentCode}")
    public ResponseEntity<DepartmentResponse> getDepartmentByDepartmentCode(@PathVariable UUID departmentCode) {
        return ResponseEntity.ok(departmentService.getDepartmentByDepartmentCode(departmentCode));
    }
}
