package com.medislot.appointment.Service;


import com.medislot.appointment.Dto.PatientDto;
import com.medislot.appointment.Entity.Patient;
import com.medislot.appointment.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public Patient addPatient(PatientDto dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setEmail(dto.getEmail());
        patient.setPhone(dto.getPhone());
        patient.setGender(dto.getGender());
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

}
