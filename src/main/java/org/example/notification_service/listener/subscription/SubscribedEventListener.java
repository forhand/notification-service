package org.example.notification_service.listener.subscription;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.notification_service.client.UserServiceClient;
import org.example.notification_service.dto.subscription.SubscribedEvent;
import org.example.notification_service.listener.AbstractEventListener;
import org.example.notification_service.messaging.impl.SubscribedEventMessageBuilder;
import org.example.notification_service.service.NotificationService;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubscribedEventListener extends AbstractEventListener<SubscribedEvent> {


  public SubscribedEventListener(ObjectMapper objectMapper,
                                  List<NotificationService> notificationServices,
                                  UserServiceClient userServiceClient,
                                  ChannelTopic subscribedEventChannel,
                                  SubscribedEventMessageBuilder messageBuilder) {
    super(objectMapper, notificationServices, userServiceClient, subscribedEventChannel, messageBuilder, SubscribedEvent.class);
  }

  @Override
  protected long getReceiverId(SubscribedEvent event) {
    return event.getFolloweeId();
  }

  @Override
  protected long getActorId(SubscribedEvent event) {
    return event.getFollowerId();
  }
}
