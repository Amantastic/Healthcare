package com.medislot.appointment.Service;

import com.medislot.appointment.Entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment makePayment(Payment payment);
    List<Payment> getPaymentsByUserId(Long userId);
    void deletePayment(Long id);
}
