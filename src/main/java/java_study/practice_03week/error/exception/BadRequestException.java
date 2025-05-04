package java_study.practice_03week.error.exception;

import java_study.practice_03week.error.ErrorCode;

public class BadRequestException extends BusinessException {
    public BadRequestException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
