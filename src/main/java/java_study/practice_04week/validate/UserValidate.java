package java_study.practice_04week.validate;

import java_study.practice_04week.repository.UserRepository;
import java_study.practice_04week.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class UserValidate {

    private final UserRepository userRepository;

    public void UserValidateName(String name) {
        if (StringUtils.isNotBlank(name) && userRepository.existsByName(name)) {
            throw new IllegalArgumentException("이미 등록된 이름입니다.");
        }
    }

    public void UserValidateEmail(String email) {
        if (StringUtils.isNotBlank(email) && userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
    }

    public UserEntity findByNameAndPassword(String name, String password) {
        userRepository
                .findByNameAndPassword(name, password)
                .orElseThrow(
                        () -> new IllegalArgumentException("잘못된 정보입니다.")
                );
        return null;
    }
}
