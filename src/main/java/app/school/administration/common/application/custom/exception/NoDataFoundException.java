package app.school.administration.common.application.custom.exception;

import app.school.administration.common.application.constant.AppMessages;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(String message) {
        super(message);
    }

    public NoDataFoundException() {
        super(AppMessages.NOT_FOUNDED);
    }
}
