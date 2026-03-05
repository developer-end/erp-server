package app.school.administration.common.custom.exception;

public class CustomNullPointerException extends NullPointerException {
    public CustomNullPointerException(String message) {
        super(message);
    }

    public CustomNullPointerException() {
        super("Null Pointer Exception");
    }
}
