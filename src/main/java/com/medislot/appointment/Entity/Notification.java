package com.medislot.appointment.Entity;

import com.medislot.appointment.Enum.NotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    private String message;
    @Enumerated(EnumType.STRING)
    private NotificationType type;
    private boolean seen = false;
    private LocalDate sentDate;
}
