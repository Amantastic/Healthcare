package com.medislot.appointment.Controller;

import com.medislot.appointment.Dto.PatientDto;
import com.medislot.appointment.Entity.Patient;
import com.medislot.appointment.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")

public class PatientController {
    @Autowired
    private  PatientService patientService;

    //  Add Patient (optional registration or for booking)
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody PatientDto dto) {
        return ResponseEntity.ok(patientService.addPatient(dto));
    }

    //  Get All Patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    //  Get Patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }
}
