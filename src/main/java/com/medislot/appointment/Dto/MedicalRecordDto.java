package com.medislot.appointment.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class MedicalRecordDto {
    private Long patientId;
    private String fileUrl;
    private String description;

}
//    public Long id;
//    public Long patientId;
//    public String description;
//    public String fileUrl;
//    public LocalDate uploadedAt;
////    public String recordType;

