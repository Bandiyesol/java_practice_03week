package java_study.practice_04week.dto;

import java_study.practice_04week.user.UserEntity;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class RedisUserDto {
    @EqualsAndHashCode.Exclude private Long id;

    private String name;
    private String email;

    public UserEntity toUserEntity() {
        return UserEntity.builder()
                .name(name)
                .email(email)
                .build();
    }
}
