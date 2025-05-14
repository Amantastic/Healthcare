package com.medislot.appointment.Controller;

import com.medislot.appointment.Dto.AdminDto;
import com.medislot.appointment.Entity.Admin;
import com.medislot.appointment.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    // ✅ Register new admin (open only for existing admin later)
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody AdminDto dto) {
        return ResponseEntity.ok(adminService.registerAdmin(dto));
    }

    // ✅ Get a single admin (admin-only)
    @GetMapping("/{id}")

    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getAdminById(id));
    }

    // ✅ List all admins
    @GetMapping("/all")

    public ResponseEntity<List<Admin>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    // ✅ Delete an admin
    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully");
    }

    // ✅ Admin dashboard or test
    @GetMapping("/dashboard")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> dashboard() {
        return ResponseEntity.ok("Welcome to Admin Dashboard 🚀");
    }

}
