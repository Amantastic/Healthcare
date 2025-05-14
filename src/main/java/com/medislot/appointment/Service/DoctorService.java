package com.medislot.appointment.Service;

import com.medislot.appointment.Dto.DoctorDto;
import com.medislot.appointment.Entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor addDoctor(DoctorDto dto);
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long id);
    Doctor updateDoctor(Long id, DoctorDto dto);
    void deleteDoctor(Long id);
}
