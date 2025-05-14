package com.medislot.appointment.Repository;

import com.medislot.appointment.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByUserId(Long userId);
}
