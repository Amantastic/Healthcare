package com.medislot.appointment.Repository;

import com.medislot.appointment.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
    List<Feedback> findByDoctorId(Long doctorId);
}
