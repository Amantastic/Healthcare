package com.medislot.appointment.Entity;

import com.medislot.appointment.Enum.Gender;
import com.medislot.appointment.Enum.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private int contactInfo;
    private String address;
    private String profilePicture;
    private String phoneNumber;

    @OneToOne(mappedBy = "user" ,cascade = CascadeType.ALL)
    private Admin admin;
    @OneToOne(mappedBy = "user" ,cascade = CascadeType.ALL)
    private Doctor doctor;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Patient patient;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;
}
