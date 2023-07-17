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
    @GetMapping("/{hospitalId}")
    public ResponseEntity<List<DepartmentResponse>> getDepartmentsByHospital(@PathVariable UUID hospitalId) {
        return ResponseEntity.ok(departmentService.getDepartmentsByHospital(hospitalId));
    }
}
