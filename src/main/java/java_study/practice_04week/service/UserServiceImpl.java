package java_study.practice_04week.service;

import java_study.practice_04week.dto.UserLoginRequestDto;
import java_study.practice_04week.dto.UserSignupRequestDto;
import java_study.practice_04week.dto.UserSignupResponseDto;
import java_study.practice_04week.repository.UserRepository;
import java_study.practice_04week.user.UserEntity;
import java_study.practice_04week.validate.UserValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserValidate userValidate;

    @Override
    public UserSignupResponseDto signUpUser(UserSignupRequestDto request) {

        String name = request.getName();
        String email = request.getEmail();

        userValidate.UserValidateName(name);
        userValidate.UserValidateEmail(email);

        UserEntity user = request.SignUpToUserEntity();

        userRepository.save(user);

        return UserSignupResponseDto.SignUpToUserEntity(user);
    }

    @Override
    public UserSignupResponseDto changeName(Long id, String name) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        userValidate.UserValidateName(name);

        user.changeName(name);

        userRepository.save(user);

        return new UserSignupResponseDto(user.getName(), user.getEmail(), user.getPassword());
    }

    @Override
    public UserSignupResponseDto changeEmail(Long id, String email) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        userValidate.UserValidateEmail(email);

        user.changeEmail(email);

        userRepository.save(user);

        return new UserSignupResponseDto(user.getName(), user.getEmail(), user.getPassword());
    }

    @Override
    public UserSignupResponseDto changePassword(Long id, String password) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        user.changePassword(password);

        userRepository.save(user);

        return new UserSignupResponseDto(user.getName(), user.getEmail(), user.getPassword());
    }

    @Override
    public void deleteInfo(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public String loginUser(UserLoginRequestDto request) {
        UserEntity user = userValidate.findByNameAndPassword(request.getName(), request.getPassword());

        String token = UUID.randomUUID().toString();

        userRepository.save(user);

        return token;
    }

    @Override
    public void logout(String token) {
        UserEntity user = userRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("유효하지 않은 토큰입니다."));

        user.giveToken(null);

        userRepository.save(user);
    }
}
