package com.medislot.appointment.Dto;

import com.medislot.appointment.Enum.Gender;
import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;
    private String password;
    private Gender gender;
    private int age;
    private String role;
    private String contactInfo;
    private String address;
    private String profilePicture;
    private String phoneNumber;
}

