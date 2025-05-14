package com.medislot.appointment.Service;

import com.medislot.appointment.Entity.Notification;

import java.util.List;

public interface NotificationService {

    Notification sendNotification(Notification notification);

    List<Notification> getNotificationsByUserId(Long userId);

    void deleteNotification(Long id);
}
