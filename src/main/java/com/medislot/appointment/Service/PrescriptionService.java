package com.medislot.appointment.Service;

import com.medislot.appointment.Entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    Prescription createPrescription(Prescription prescription);
    List<Prescription> getPrescriptionsByPatientId(Long patientId);
    void deletePrescription(Long id);
}
