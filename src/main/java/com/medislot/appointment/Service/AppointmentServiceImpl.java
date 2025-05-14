package com.medislot.appointment.Service;

import com.medislot.appointment.Dto.AppointmentDto;
import com.medislot.appointment.Entity.Appointment;
import com.medislot.appointment.Entity.Doctor;
import com.medislot.appointment.Entity.Patient;
import com.medislot.appointment.Repository.AppointmentRepository;
import com.medislot.appointment.Repository.DoctorRepository;
import com.medislot.appointment.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;


    @Override
    public Appointment bookAppointment(AppointmentDto dto) {
        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // You can reuse or create a patient here
        Patient patient = new Patient();
        patient.setName(dto.getPatientName());
        patient.setAge(dto.getPatientAge());
        patient.setPhone("N/A");
        patient.setEmail("N/A");
        patientRepository.save(patient);

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setIssue(dto.getIssue());
        appointment.setAppointmentDateTime(LocalDateTime.now().plusDays(1)); // placeholder
        appointment.setBookingTimeSlot(dto.getBookingTimeSlot());
        appointment.setStatus("BOOKED");
        appointment.setAppointmentDateTime(LocalDateTime.now());

        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }


    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findAll().stream()
                .filter(a -> a.getDoctor().getId().equals(doctorId))
                .toList();
    }

    @Override
    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findAll().stream()
                .filter(a -> a.getPatient().getId().equals(patientId))
                .toList();
    }

    @Override
    public Appointment  cancelAppointment(Long id) {
        Appointment appointment = getAppointmentById(id);
        appointment.setStatus("CANCELLED");
        appointment.setIsCancelled(true);
        return appointmentRepository.save(appointment);
    }
}
