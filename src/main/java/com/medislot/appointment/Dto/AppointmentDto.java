package com.medislot.appointment.Dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AppointmentDto {
    private Long doctorId;
    private String patientName;
    private int patientAge;
    private String issue;
    private String bookingTimeSlot;
    private String phoneNumber;
    private String email;
}
