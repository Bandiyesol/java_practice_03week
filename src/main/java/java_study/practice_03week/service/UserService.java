package java_study.practice_03week.service;

import java_study.practice_03week.dto.UserLoginRequestDto;
import java_study.practice_03week.dto.UserSignupRequestDto;
import java_study.practice_03week.dto.UserSignupResponseDto;

public interface UserService {
    UserSignupResponseDto signUpUser(UserSignupRequestDto signUpRequestDto);

    UserSignupResponseDto changeName(Long id, String name);

    UserSignupResponseDto changeEmail(Long id, String email);

    UserSignupResponseDto changePassword(Long id, String password);

    void deleteInfo(Long id);

    String loginUser(UserLoginRequestDto loginRequestDto);

    void logout(String token);
}
