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
    public UserSignupResponseDto signUpUser(UserSignupRequestDto request) {

        UserEntity user = request.SignUpToUserEntity();

        userRepository.save(user);

        return null;
    }

    @Override
    public UserSignupResponseDto changeName(Long id, String name) {

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userEntity.SetName(name);

        userRepository.save(userEntity);

        return null;
    }

    @Override
    public UserSignupResponseDto changeEmail(Long id, String email) {

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userEntity.SetEmail(email);

        userRepository.save(userEntity);

        return null;
    }

    @Override
    public UserSignupResponseDto changePassword(Long id, String password) {

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userEntity.SetPassword(password);

        userRepository.save(userEntity);

        return null;
    }

    @Override
    public void deleteInfo(Long id) {
        userRepository.deleteById(id);

    }
}
