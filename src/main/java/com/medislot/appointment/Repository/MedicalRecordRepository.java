package com.medislot.appointment.Repository;

import com.medislot.appointment.Entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {
    List<MedicalRecord> findByPatientId(Long patientId);
}
