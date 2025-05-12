package org.example.notification_service.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;

@Configuration
public class ChannelConfig {

  @Bean
  public ChannelTopic userSubscriptionEventChannel(@Value("${spring.data.redis.channels.subscription.user_subscription.name}") String topicName) {
    return new ChannelTopic(topicName);
  }

  @Bean
  public ChannelTopic userUnubscriptionEventChannel(@Value("${spring.data.redis.channels.subscription.user_unsubscription.name}") String topicName) {
    return new ChannelTopic(topicName);
  }

}
