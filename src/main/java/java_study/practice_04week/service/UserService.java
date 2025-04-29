package java_study.practice_04week.service;

import java_study.practice_04week.dto.UserSignupRequestDto;
import java_study.practice_04week.dto.UserSignupResponseDto;

public interface UserService {
    UserSignupResponseDto signUpUser(UserSignupRequestDto signUpRequestDto);

    UserSignupResponseDto changeName(Long id, String name);

    UserSignupResponseDto changeEmail(Long id, String email);

    UserSignupResponseDto changePassword(Long id, String password);

    void deleteInfo(Long id);
}
