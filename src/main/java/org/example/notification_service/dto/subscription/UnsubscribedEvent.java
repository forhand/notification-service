package org.example.notification_service.dto.subscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UnsubscribedEvent {
  private long followerId;
  private long followeeId;
  private LocalDateTime eventAt;
}
