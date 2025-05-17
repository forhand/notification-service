package org.example.notification_service.messaging.impl;

import org.example.notification_service.dto.subscription.SubscribedEvent;
import org.example.notification_service.messaging.AbstractMessageBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class SubscribedEventMessageBuilder extends AbstractMessageBuilder<SubscribedEvent> {

  public SubscribedEventMessageBuilder(MessageSource messageSource) {
    super(messageSource, "notification.email.subscription.subscribed");
  }

  @Override
  public String buildMessage(SubscribedEvent event, Locale locale) {
    return messageSource.getMessage(codeMessage, null, Locale.getDefault());
  }
}
