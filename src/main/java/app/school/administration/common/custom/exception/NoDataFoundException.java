package app.school.administration.common.custom.exception;

import app.school.administration.common.constant.AppMessages;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(String message) {
        super(message);
    }
    public NoDataFoundException() {
        super(AppMessages.NOT_FOUNDED);
    }
}
