package com.medislot.appointment.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PatientDto {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String gender;
    private int age;
}
