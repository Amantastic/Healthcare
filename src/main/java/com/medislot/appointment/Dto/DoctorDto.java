package com.medislot.appointment.Dto;

import lombok.Data;

@Data
public class DoctorDto {
    private String name;
    private String specialization;
    private int phoneNumber;
    private String email;
    private String location;
    private String profileImageUrl;
    private String qualification;
    private String clinicAddress;
    private double consultationFee;
    private String availableDays;
    private String availableTime;
}

