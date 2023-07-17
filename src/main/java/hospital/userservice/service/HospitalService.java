package hospital.userservice.service;

import hospital.userservice.dto.response.HospitalResponse;

import java.util.List;

public interface HospitalService {
    public List<HospitalResponse> getAllHospitals();
}
