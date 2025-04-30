package java_study.practice_04week.dto;

import java_study.practice_04week.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserSignupResponseDto {

    private String name;
    private String email;
    private String password;

    public static UserSignupResponseDto SignUpToUserEntity(UserEntity user) {

        return UserSignupResponseDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
