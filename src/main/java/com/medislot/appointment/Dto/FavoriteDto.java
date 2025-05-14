package com.medislot.appointment.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class FavoriteDto {
    private Long patientId;
    private Long doctorId;
//    public String hospitalName; // optional, if favorite is a hospital
//    public String hospitalAddress;
//    public LocalDate addedDate;
}
