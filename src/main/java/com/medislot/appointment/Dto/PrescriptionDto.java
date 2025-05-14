package com.medislot.appointment.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PrescriptionDto {
    public Long appointmentId;
    public String medications;
    public String dosageInstructions;
    public LocalDate issuedDate;
}
