package app.school.administration.common.application.custom.exception;

public class TokenExpirationException extends RuntimeException {

    public TokenExpirationException() {
        super("Authorization Token Expired");
    }

    public TokenExpirationException(String message) {
        super(message);
    }

}
