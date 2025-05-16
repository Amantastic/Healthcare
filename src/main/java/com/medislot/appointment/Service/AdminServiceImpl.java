package com.medislot.appointment.Service;

import com.medislot.appointment.Dto.AdminDto;
import com.medislot.appointment.Entity.Admin;
import com.medislot.appointment.Repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Admin registerAdmin(AdminDto dto) {
        Admin admin = new Admin();
        admin.setName(dto.getName());
        admin.setEmail(dto.getEmail());
        admin.setPassword(passwordEncoder.encode(dto.getPassword()));
        return adminRepository.save(admin);
    }

    public boolean loginAdmin(String email, String rawPassword) {
        Optional<Admin> optionalAdmin = adminRepository.findByEmail(email);

        if (optionalAdmin.isEmpty()) {
            return false; // Email not found
        }

        Admin admin = optionalAdmin.get(); // Safe to call now
        return passwordEncoder.matches(rawPassword, admin.getPassword());
    }


    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

//    admin.setPassword(passwordEncoder.encode(dto.getPassword())); //  Hash password
}
