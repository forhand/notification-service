package org.example.notification_service.messaging.impl;

import org.example.notification_service.dto.subscription.UserSubscriptionEvent;
import org.example.notification_service.messaging.AbstractMessageBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UserSubscriptionMessageBuilder extends AbstractMessageBuilder<UserSubscriptionEvent> {

  public UserSubscriptionMessageBuilder(MessageSource messageSource,
                                        @Value("${messages.notification.email.user.subscription}") String codeMessage) {
    super(messageSource, codeMessage);
  }

  @Override
  public String buildMessage(UserSubscriptionEvent event, Locale locale) {
    return messageSource.getMessage(codeMessage, null, Locale.getDefault());
  }
}
