package com.medislot.appointment.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class FeedbackDto {
    private Long doctorId;
    private Long patientId;
    private int rating;
    private String comment;
}
