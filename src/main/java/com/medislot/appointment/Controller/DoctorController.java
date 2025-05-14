package com.medislot.appointment.Controller;

import com.medislot.appointment.Dto.DoctorDto;
import com.medislot.appointment.Entity.Doctor;
import com.medislot.appointment.Service.DoctorService;
import com.medislot.appointment.Service.DoctorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")

public class DoctorController {

    @Autowired
    private  DoctorService doctorService;

    //  1. Add New Doctor
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody DoctorDto doctorDto) {
        Doctor savedDoctor = doctorService.addDoctor(doctorDto);
        return ResponseEntity.ok(savedDoctor);
    }


    //  2. Get All Doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    //  3. Get Doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    //  4. Update Doctor
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody DoctorDto doctorDto) {
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctorDto);
        return ResponseEntity.ok(updatedDoctor);
    }

    //  5. Delete Doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted successfully.");
    }
}
