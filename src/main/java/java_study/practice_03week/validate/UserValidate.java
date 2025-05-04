package java_study.practice_03week.validate;

import java_study.practice_03week.error.ErrorCode;
import java_study.practice_03week.error.exception.BadRequestException;
import java_study.practice_03week.error.exception.NotFoundException;
import java_study.practice_03week.repository.UserRepository;
import java_study.practice_03week.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class UserValidate {

    private final UserRepository userRepository;

    public UserEntity UserValidateId(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException(
                                "사용자를 찾을 수 없습니다.",
                                ErrorCode.NOT_FOUND_EXCEPTION
                        )
                );
    }

    public void UserValidateName(String name) {
        if (StringUtils.isNotBlank(name) && userRepository.existsByName(name)) {
            throw new BadRequestException(
                    "이미 등록된 이름입니다.",
                    ErrorCode.DUPLICATE_NAME_EXCEPTION
            );
        }
    }

    public void UserValidateEmail(String email) {
        if (StringUtils.isNotBlank(email) && userRepository.existsByEmail(email)) {
            throw new BadRequestException(
                    "이미 사용 중인 이메일입니다.",
                    ErrorCode.DUPLICATE_EMAIL_EXCEPTION
            );
        }
    }

    public UserEntity findByNameAndPassword(String name, String password) {
        return userRepository
                .findByNameAndPassword(name, password)
                .orElseThrow(
                        () -> new BadRequestException(
                                "잘못된 정보입니다.",
                                ErrorCode.BAD_REQUEST_EXCEPTION
                        )
                );
    }
}
