package com.medislot.appointment.Service;

import com.medislot.appointment.Dto.UserDto;
import com.medislot.appointment.Entity.User;

public interface UserService {
    User registerUser(UserDto dto);
    User getUserById(Long id);
    User login(String email, String password); // optional
}
