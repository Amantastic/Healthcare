package com.medislot.appointment.Controller;

import com.medislot.appointment.Dto.AppointmentDto;
import com.medislot.appointment.Entity.Appointment;
import com.medislot.appointment.Service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")

public class AppointmentController {

    @Autowired
    private  AppointmentService appointmentService;

    // 1. Book Appointment
    @PostMapping
    public ResponseEntity<Appointment> bookAppointment(@RequestBody AppointmentDto dto) {
        Appointment saved = appointmentService.bookAppointment(dto);
        return ResponseEntity.ok(saved);
    }

    //  2. Get Appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(appointment);
    }

    //  3. Get All Appointments (Admin or Doctor View)
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    //  4. Get Appointments by Doctor ID
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctor(doctorId));
    }

    //  5. Get Appointments by Patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatient(patientId));
    }

    //  6. Cancel Appointment
    @PutMapping("/cancel/{id}")
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(id));
    }
}
