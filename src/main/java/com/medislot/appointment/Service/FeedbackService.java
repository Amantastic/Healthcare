package com.medislot.appointment.Service;

import com.medislot.appointment.Entity.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback submitFeedback(Feedback feedback);
    List<Feedback> getFeedbackByDoctorId(Long doctorId);
    void deleteFeedback(Long id);
}
