package app.school.administration.common.application.custom.exception;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super("Unauthorized Request");
    }

    public UnauthorizedException(String message) {
        super(message);
    }

}
