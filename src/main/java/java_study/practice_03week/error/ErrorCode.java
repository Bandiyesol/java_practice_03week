package java_study.practice_03week.error;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

public enum ErrorCode {

    NOT_FOUND_EXCEPTION("404", HttpStatus.NOT_FOUND, "Not Found"),
    BAD_REQUEST_EXCEPTION("400", HttpStatus.BAD_REQUEST, "Bad Request"),
    DUPLICATE_NAME_EXCEPTION("409", HttpStatus.CONFLICT, "이미 사용 중인 이름입니다."),
    DUPLICATE_EMAIL_EXCEPTION("409", HttpStatus.CONFLICT, "이미 사용 중인 이메일입니다.");

    private final String code;
    private final HttpStatus status;
    private final String message;

    ErrorCode (String code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
