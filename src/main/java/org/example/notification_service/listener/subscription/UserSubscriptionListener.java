package org.example.notification_service.listener.subscription;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.notification_service.client.UserServiceClient;
import org.example.notification_service.dto.subscription.UserSubscriptionEvent;
import org.example.notification_service.messaging.impl.UserSubscriptionMessageBuilder;
import org.example.notification_service.service.NotificationService;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSubscriptionListener extends AbstractEventListener<UserSubscriptionEvent> {


  public UserSubscriptionListener(ObjectMapper objectMapper,
                                  List<NotificationService> notificationServices,
                                  UserServiceClient userServiceClient,
                                  ChannelTopic userSubscriptionEventChannel,
                                  UserSubscriptionMessageBuilder messageBuilder) {
    super(objectMapper, notificationServices, userServiceClient, userSubscriptionEventChannel, messageBuilder, UserSubscriptionEvent.class);
  }

  @Override
  protected long getUserId(UserSubscriptionEvent event) {
    return event.getFolloweeId();
  }
}
