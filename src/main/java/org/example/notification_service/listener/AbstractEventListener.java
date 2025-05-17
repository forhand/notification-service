package org.example.notification_service.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.notification_service.client.UserServiceClient;
import org.example.notification_service.dto.user.UserDto;
import org.example.notification_service.messaging.MessageBuilder;
import org.example.notification_service.service.NotificationService;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Data
@RequiredArgsConstructor
@Slf4j
public abstract class AbstractEventListener<T> implements ChannelAwareListener {

  protected final ObjectMapper objectMapper;
  protected final List<NotificationService> notificationServices;
  protected final UserServiceClient userServiceClient;
  protected final ChannelTopic channelTopic;
  protected final MessageBuilder<T> messageBuilder;
  protected final Class<T> eventType;

  @Override
  public void onMessage(Message message, byte[] pattern) {
    log.info("Received event from channel: " + channelTopic.getTopic());
    T event = parseEvent(message);

    UserDto actor = userServiceClient.getUser(getActorId(event));
    UserDto receiver = userServiceClient.getUser(getReceiverId(event));
    String text = messageBuilder.buildMessage(event, Locale.getDefault());

    notifyUser(actor, text);
    log.info("Notification has been sent");
  }

  public ChannelTopic getChannel() {
    return channelTopic;
  }

  protected abstract long getReceiverId(T event);

  protected abstract long getActorId(T event);

  private T parseEvent(Message message) {
    try {
      return objectMapper.readValue(message.getBody(), eventType);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void notifyUser(UserDto user, String text) {
    notificationServices.stream()
            .filter(service -> service.getPreferredContact().equals(user.getPreferredContact()))
            .findFirst()
            .ifPresent(service -> service.send(user, text));
  }
}
