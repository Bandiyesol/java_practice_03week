package java_study.practice_03week.dto;

import java_study.practice_03week.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserSignupRequestDto {

    private String name;
    private String email;
    private String password;

    public UserEntity SignUpToUserEntity() {

        return UserEntity.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();

    }

}
