package app.school.administration.common.custom.exception;

public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException() {
        super("Invalid Token Expired");
    }

    public InvalidTokenException(String message) {
        super(message);
    }

}
