package org.example.notification_service.client;

import org.example.notification_service.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${client.user-service.name}", url = "${client.user-service.host}:${client.user-service.port}",
path = "${client.user-service.base-path}")
public interface UserServiceClient {

    @GetMapping("/{userId}")
    UserDto getUser(@PathVariable long userId);
}
