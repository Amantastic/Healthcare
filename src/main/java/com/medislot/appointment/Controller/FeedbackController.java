package com.medislot.appointment.Controller;

import com.medislot.appointment.Entity.Feedback;
import com.medislot.appointment.Service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(@RequestBody Feedback feedback) {
        return ResponseEntity.ok(feedbackService.submitFeedback(feedback));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Feedback>> getFeedbackByDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(feedbackService.getFeedbackByDoctorId(doctorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok("Feedback deleted");
    }
}
