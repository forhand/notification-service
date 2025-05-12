package org.example.notification_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
@EnableFeignClients("org.example.notification_service.client")
public class NotificationServiceApp {
  public static void main(String[] args) {
    new SpringApplicationBuilder(NotificationServiceApp.class)
            .bannerMode(Banner.Mode.OFF)
            .run(args);
  }

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
