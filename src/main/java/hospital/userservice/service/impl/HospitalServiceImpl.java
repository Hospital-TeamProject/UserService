package hospital.userservice.service.impl;

import hospital.userservice.dto.response.HospitalResponse;
import hospital.userservice.mapper.DepartmentMapper;
import hospital.userservice.repository.HospitalRepository;
import hospital.userservice.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public List<HospitalResponse> getAllHospitals() {
        return hospitalRepository.findAll()
                .stream()
                .map(departmentMapper::modelToHospitalResponse)
                .collect(Collectors.toList());
    }
}
