package hospital.userservice.service.impl;

import hospital.userservice.dto.response.DepartmentResponse;
import hospital.userservice.exception.NotFoundException;
import hospital.userservice.mapper.DepartmentMapper;
import hospital.userservice.model.Hospital;
import hospital.userservice.repository.DepartmentRepository;
import hospital.userservice.repository.HospitalRepository;
import hospital.userservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final HospitalRepository hospitalRepository;
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    @Override
    public List<DepartmentResponse> getDepartmentsByHospital(UUID hospitalCode) {
        Hospital hospital = hospitalRepository.findByHospitalCode(hospitalCode).orElseThrow(() -> {
            throw new NotFoundException("Hospital with given hospital code doesn't exist.");
        });

        return departmentRepository.findByHospital(hospital)
                .stream()
                .map(departmentMapper::modelToDepartmentResponse)
                .collect(Collectors.toList());

    }
}
