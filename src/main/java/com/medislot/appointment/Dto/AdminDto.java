package com.medislot.appointment.Dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AdminDto {
    private String email;
    private String name;
    private String password;
}
