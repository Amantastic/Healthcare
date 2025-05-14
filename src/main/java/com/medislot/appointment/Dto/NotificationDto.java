package com.medislot.appointment.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class NotificationDto {

    private Long userId;
    private String message;
    private String notificationType;
    private Boolean isRead;
    private LocalDate sentDate;
}
