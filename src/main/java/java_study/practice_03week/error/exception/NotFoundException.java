package java_study.practice_03week.error.exception;

import java_study.practice_03week.error.ErrorCode;

public class NotFoundException extends BusinessException {
    public NotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
