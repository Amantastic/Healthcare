package com.medislot.appointment.Entity;

import com.medislot.appointment.Enum.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String password;
    private String profilePicture;


//    private String role = "ADMIN";

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.ADMIN;

//    private String permissions;
//    private LocalDateTime lastLogin;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
