package christmas.exception;

import christmas.exception.constants.ErrorConstants;

public class InvalidOrderMenuException extends IllegalArgumentException {

    private static final String message = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public InvalidOrderMenuException() {
        super(ErrorConstants.ERROR_PREFIX.getValue() + message);
    }
}
