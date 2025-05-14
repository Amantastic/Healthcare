package com.medislot.appointment.Service;

import com.medislot.appointment.Entity.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecord saveRecord(MedicalRecord record);
    List<MedicalRecord> getRecordsByPatientId(Long patientId);
    void deleteRecord(Long id);
}
