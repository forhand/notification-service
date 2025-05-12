package org.example.notification_service.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;

@RequiredArgsConstructor
public abstract class AbstractMessageBuilder<T> implements MessageBuilder<T>{
  protected final MessageSource messageSource;
  protected final String codeMessage;
}
