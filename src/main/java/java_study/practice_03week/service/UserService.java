package java_study.practice_03week.service;

import java_study.practice_03week.dto.UserLoginRequestDto;
import java_study.practice_03week.dto.UserSignupRequestDto;
import java_study.practice_03week.dto.UserSignupResponseDto;
import java_study.practice_03week.user.UserEntity;

public interface UserService {
    UserSignupResponseDto signUpUser(UserSignupRequestDto signUpRequestDto);

    UserEntity updateUser(UserEntity userEntity);

    UserSignupResponseDto changeName(Long id, String name);

    UserSignupResponseDto changeEmail(Long id, String email);

    UserSignupResponseDto changePassword(Long id, String password);

    void deleteInfo(Long id);

    String loginUser(UserLoginRequestDto loginRequestDto);

    void logout(String token);
}
