package java_study.practice_03week.service;

import java_study.practice_03week.dto.UserLoginRequestDto;
import java_study.practice_03week.dto.UserSignupRequestDto;
import java_study.practice_03week.dto.UserSignupResponseDto;
import java_study.practice_03week.repository.UserRepository;
import java_study.practice_03week.user.UserEntity;
import java_study.practice_03week.validate.UserValidate;
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
    public UserEntity updateUser(UserEntity user) {

        UserEntity userEntity = userValidate.UserValidateId(user.getId());

        userValidate.UserValidateName(userEntity.getName());
        userEntity.changeName(user.getName());

        userValidate.UserValidateEmail(userEntity.getEmail());
        userEntity.changeEmail(user.getEmail());

        userEntity.changePassword(user.getPassword());

        userRepository.save(userEntity);

        return userEntity;
    }

    @Override
    public UserSignupResponseDto changeName(Long id, String name) {

        UserEntity user = userValidate.UserValidateId(id);

        userValidate.UserValidateName(name);
        user.changeName(name);

        userRepository.save(user);

        return UserSignupResponseDto.SignUpToUserEntity(user);
    }

    @Override
    public UserSignupResponseDto changeEmail(Long id, String email) {

        UserEntity user = userValidate.UserValidateId(id);

        userValidate.UserValidateEmail(email);

        user.changeEmail(email);

        userRepository.save(user);

        return UserSignupResponseDto.SignUpToUserEntity(user);
    }

    @Override
    public UserSignupResponseDto changePassword(Long id, String password) {

        UserEntity user = userValidate.UserValidateId(id);

        user.changePassword(password);

        userRepository.save(user);

        return UserSignupResponseDto.SignUpToUserEntity(user);
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
