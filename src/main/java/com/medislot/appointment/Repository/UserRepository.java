package com.medislot.appointment.Repository;

import com.medislot.appointment.Entity.Appointment;
import com.medislot.appointment.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//    List<Appointment> findByDoctorId(Long doctor_id);
User findByEmail(String email);
}
