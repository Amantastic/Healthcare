package com.medislot.appointment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor     {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;
    private String Qualification;
    private double consultationFee;
    private int PhoneNumber;
    private String email;
    private String clinicAddress;
    private String profileImageUrl;
    private  String availableDays;
    private  String availableTime;

//    private String licenseNumber;
//    private int experienceYears;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "doctor")
    private List<Feedback> feedbacks;
}
