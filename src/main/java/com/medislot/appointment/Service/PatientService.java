package com.medislot.appointment.Service;

import com.medislot.appointment.Dto.PatientDto;
import com.medislot.appointment.Entity.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(PatientDto dto);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
}
