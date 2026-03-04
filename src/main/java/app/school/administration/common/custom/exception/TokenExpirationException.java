package app.school.administration.common.custom.exception;

public class TokenExpirationException extends RuntimeException {

    public TokenExpirationException() {
        super("Authorization Token Expired");
    }

    public TokenExpirationException(String message) {
        super(message);
    }

}
