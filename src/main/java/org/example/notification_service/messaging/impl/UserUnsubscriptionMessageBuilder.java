package org.example.notification_service.messaging.impl;

import org.example.notification_service.dto.subscription.UserUnsubscriptionEvent;
import org.example.notification_service.messaging.AbstractMessageBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UserUnsubscriptionMessageBuilder extends AbstractMessageBuilder<UserUnsubscriptionEvent> {

  public UserUnsubscriptionMessageBuilder(MessageSource messageSource,
                                          @Value("${messages.notification.email.user.unsubscription}") String codeMessage) {
    super(messageSource, codeMessage);
  }

  @Override
  public String buildMessage(UserUnsubscriptionEvent event, Locale locale) {
    return messageSource.getMessage(codeMessage, null, Locale.getDefault());
  }
}
