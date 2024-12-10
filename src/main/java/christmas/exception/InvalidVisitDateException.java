package christmas.exception;

import christmas.exception.constants.ErrorConstants;

public class InvalidVisitDateException extends IllegalArgumentException {

    private static final String message = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public InvalidVisitDateException() {
        super(ErrorConstants.ERROR_PREFIX.getValue() + message);
    }
}
