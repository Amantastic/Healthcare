package com.medislot.appointment.Service;

import com.medislot.appointment.Dto.AppointmentDto;
import com.medislot.appointment.Entity.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(AppointmentDto dto);
    Appointment getAppointmentById(Long id);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByDoctor(Long doctorId);
    List<Appointment> getAppointmentsByPatient(Long patientId);
    Appointment  cancelAppointment(Long id);
}
