package com.medislot.appointment.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PaymentDto {
    private Long appointmentId;
    private double amount;
    private String status;
//    public Long id;
//    public Long appointmentId;
//    public Double amount;
//    public LocalDate paymentDate;
//    public String paymentMethod;
//    public String paymentStatus;

}
