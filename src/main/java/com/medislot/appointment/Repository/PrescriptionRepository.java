package com.medislot.appointment.Repository;

import com.medislot.appointment.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
    List<Prescription> findByPatientId(Long patientId);
}
