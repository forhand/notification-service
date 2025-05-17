package org.example.notification_service.listener.subscription;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.notification_service.client.UserServiceClient;
import org.example.notification_service.dto.subscription.UnsubscribedEvent;
import org.example.notification_service.listener.AbstractEventListener;
import org.example.notification_service.messaging.impl.UnsubscribedEventMessageBuilder;
import org.example.notification_service.service.NotificationService;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UnsubscribedEventListener extends AbstractEventListener<UnsubscribedEvent> {

  public UnsubscribedEventListener(ObjectMapper objectMapper,
                                    List<NotificationService> notificationServices,
                                    UserServiceClient userServiceClient,
                                    ChannelTopic unsubscribedEventChannel,
                                    UnsubscribedEventMessageBuilder messageBuilder) {
    super(objectMapper, notificationServices, userServiceClient, unsubscribedEventChannel, messageBuilder, UnsubscribedEvent.class);
  }


  @Override
  protected long getReceiverId(UnsubscribedEvent event) {
    return event.getFollowerId();
  }

  @Override
  protected long getActorId(UnsubscribedEvent event) {
    return event.getFolloweeId();
  }
}
