package com.medislot.appointment.Controller;

import com.medislot.appointment.Dto.UserDto;
import com.medislot.appointment.Dto.UserLoginDto;
import com.medislot.appointment.Entity.User;
import com.medislot.appointment.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    //  Register User
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto dto) {
        return ResponseEntity.ok(userService.registerUser(dto));
    }

    //  Login (basic version)
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDto dto) {
        try {
            User user = userService.login(dto.getEmail(), dto.getPassword());
            return ResponseEntity.ok(user);  // or return a token or success message
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }
    }

        // Get User by ID
        @GetMapping("/{id}")
        public ResponseEntity<User> getUserById (@PathVariable Long id){
            return ResponseEntity.ok(userService.getUserById(id));
        }


}
