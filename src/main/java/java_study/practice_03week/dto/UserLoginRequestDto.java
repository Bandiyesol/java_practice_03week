package java_study.practice_03week.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserLoginRequestDto {
    private String name;
    private String password;
}
