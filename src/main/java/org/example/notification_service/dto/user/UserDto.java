package org.example.notification_service.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notification_service.dto.contact.PreferredContact;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

  private Long id;
  @NotBlank
  private String username;
  private int age;
  @NotBlank
  private String email;
  private PreferredContact preferredContact;
  @NotNull
  private Boolean active;
  private List<Long> followerIds;
  private List<Long> followeeIds;

}
