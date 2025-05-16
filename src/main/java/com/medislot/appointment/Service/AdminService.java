package com.medislot.appointment.Service;


import com.medislot.appointment.Dto.AdminDto;
import com.medislot.appointment.Entity.Admin;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;


public interface AdminService {
    Admin registerAdmin(AdminDto adminDto);
    boolean loginAdmin(String email, String rawPassword);
    Admin getAdminById(Long id);
    List<Admin> getAllAdmins();
    void deleteAdmin(Long id);
}
