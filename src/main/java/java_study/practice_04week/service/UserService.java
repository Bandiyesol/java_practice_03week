package java_study.practice_04week.service;

import java_study.practice_04week.dto.UserSignupRequestDto;
import java_study.practice_04week.dto.UserSignupResponseDto;

public interface UserService {
    UserSignupResponseDto signUpUser(UserSignupRequestDto signUpRequestDto);;
}
