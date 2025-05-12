package org.example.notification_service.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.notification_service.config.EmailConfig;
import org.example.notification_service.dto.contact.PreferredContact;
import org.example.notification_service.dto.user.UserDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EmailService implements NotificationService {

  private JavaMailSender emailSender;
  private final EmailConfig emailConfig;

  @Override
  public void send(UserDto user, String text) {
    SimpleMailMessage message = createSimpleMailMessage(user, text);
    log.info("EmailService: Sending email to {}", user.getEmail());
    emailSender.send(message);
  }

  @Override
  public PreferredContact getPreferredContact() {
    return PreferredContact.EMAIL;
  }

  private SimpleMailMessage createSimpleMailMessage(UserDto user, String text) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(emailConfig.getFrom());
    message.setTo(user.getEmail());
    message.setSubject(emailConfig.getSubject());
    message.setText(text);
    return message;
  }
}
