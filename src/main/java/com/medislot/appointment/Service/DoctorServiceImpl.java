package com.medislot.appointment.Service;

import com.medislot.appointment.Dto.DoctorDto;
import com.medislot.appointment.Entity.Doctor;
import com.medislot.appointment.Repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(DoctorDto dto) {
        Doctor doctor = new Doctor();
        mapDtoToEntity(dto, doctor);
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
    }

    @Override
    public Doctor updateDoctor(Long id, DoctorDto dto) {
        Doctor doctor = getDoctorById(id);
        mapDtoToEntity(dto, doctor);
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor doctor = getDoctorById(id);
        doctorRepository.delete(doctor);
    }

    // Utility method to map DTO to Entity
    private void mapDtoToEntity(DoctorDto dto, Doctor doctor) {
        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setEmail(dto.getEmail());
        doctor.setClinicAddress(dto.getClinicAddress());
        doctor.setPhoneNumber(dto.getPhoneNumber());
        doctor.setQualification(dto.getQualification());
        doctor.setProfileImageUrl(dto.getProfileImageUrl());
        doctor.setConsultationFee(dto.getConsultationFee());
        doctor.setAvailableDays(dto.getAvailableDays());
        doctor.setAvailableTime(dto.getAvailableTime());
    }
}

