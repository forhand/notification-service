package org.example.notification_service.listener.subscription;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.notification_service.client.UserServiceClient;
import org.example.notification_service.dto.subscription.UserUnsubscriptionEvent;
import org.example.notification_service.messaging.impl.UserUnsubscriptionMessageBuilder;
import org.example.notification_service.service.NotificationService;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserUnsubscriptionListener extends AbstractEventListener<UserUnsubscriptionEvent> {

  public UserUnsubscriptionListener(ObjectMapper objectMapper,
                                    List<NotificationService> notificationServices,
                                    UserServiceClient userServiceClient,
                                    ChannelTopic userUnubscriptionEventChannel,
                                    UserUnsubscriptionMessageBuilder messageBuilder) {
    super(objectMapper, notificationServices, userServiceClient, userUnubscriptionEventChannel, messageBuilder, UserUnsubscriptionEvent.class);
  }


  @Override
  protected long getUserId(UserUnsubscriptionEvent event) {
    return event.getFolloweeId();
  }
}
