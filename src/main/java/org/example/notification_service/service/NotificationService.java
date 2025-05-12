package org.example.notification_service.service;

import org.example.notification_service.dto.contact.PreferredContact;
import org.example.notification_service.dto.user.UserDto;

public interface NotificationService {
    void send(UserDto user, String message);
    PreferredContact getPreferredContact();
}
