package java_study.practice_03week.error.exception;

import java_study.practice_03week.error.ErrorCode;
import lombok.Getter;

@Getter

public class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;

    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
