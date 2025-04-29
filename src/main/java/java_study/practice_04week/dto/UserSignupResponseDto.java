package java_study.practice_04week.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserSignupResponseDto {
    private String name;
    private String email;

}
