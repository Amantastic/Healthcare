package com.medislot.appointment.Service;

import com.medislot.appointment.Entity.Favorite;
import com.medislot.appointment.Entity.Feedback;
import com.medislot.appointment.Entity.Notification;
import com.medislot.appointment.Repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Override
    public Feedback submitFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getFeedbackByDoctorId(Long doctorId) {
        return feedbackRepository.findByDoctorId(doctorId);
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }


}
