package org.example.notification_service.messaging.impl;

import org.example.notification_service.dto.subscription.UnsubscribedEvent;
import org.example.notification_service.messaging.AbstractMessageBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UnsubscribedEventMessageBuilder extends AbstractMessageBuilder<UnsubscribedEvent> {

  public UnsubscribedEventMessageBuilder(MessageSource messageSource) {

    super(messageSource, "notification.email.subscription.unsubscribed");
  }

  @Override
  public String buildMessage(UnsubscribedEvent event, Locale locale) {
    return messageSource.getMessage(codeMessage, null, Locale.getDefault());
  }
}
