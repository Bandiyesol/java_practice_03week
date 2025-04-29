package java_study.practice_04week.service;

import java_study.practice_04week.dto.UserSignupRequestDto;
import java_study.practice_04week.dto.UserSignupResponseDto;
import java_study.practice_04week.repository.UserRepository;
import java_study.practice_04week.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserSignupResponseDto signUpUser(UserSignupRequestDto signUpRequestDto) {
        UserEntity user = signUpRequestDto.toUserEntity();

        userRepository.save(user);

        return null;
    }
}
