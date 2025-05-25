package com.medislot.appointment.Controller;

import com.medislot.appointment.Entity.Admin;
import com.medislot.appointment.Entity.Doctor;
import com.medislot.appointment.Entity.MedicalRecord;
import com.medislot.appointment.Entity.User;
import com.medislot.appointment.Repository.AdminRepository;
import com.medislot.appointment.Repository.DoctorRepository;
import com.medislot.appointment.Repository.MedicalRecordRepository;
import com.medislot.appointment.Repository.UserRepository;
import com.medislot.appointment.Service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/uploads")
@RequiredArgsConstructor
public class ImageUploadController {

    private final ImageUploadService imageUploadService;

    //
    @PostMapping("/upload")
    public ResponseEntity<String> uploadGenericFile(@RequestParam("file") MultipartFile file) {
        try {
            String url = imageUploadService.uploadFile(file);
            return ResponseEntity.ok("File uploaded successfully ✅ URL: " + url);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed ❌");
        }
    }

    @PostMapping
    public ResponseEntity<Map> uploadImage(@RequestParam("Image") MultipartFile file){
       Map data =  this.imageUploadService.upload(file);
       return  new ResponseEntity<>(data,HttpStatus.OK);
    }
}
