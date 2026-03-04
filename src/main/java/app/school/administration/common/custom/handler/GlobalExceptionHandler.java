package app.school.administration.common.custom.handler;

import app.school.administration.common.base.DTO.AppResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private String getExceptionMessage(Throwable throwable) {
        return throwable.getMessage();
    }

    private ResponseEntity<AppResponse> builder(HttpStatus httpStatus, Exception exception, HttpServletRequest request) {
        return ResponseEntity
                .status(httpStatus)
                .body(new AppResponse(
                        httpStatus.value(),
                        httpStatus.name(),
                        httpStatus.getReasonPhrase(),
                        request.getRequestURL().toString(),
                        null,
                        LocalDateTime.now(),
                        getExceptionMessage(exception)
                ));
    }

    private ResponseEntity<AppResponse> builder(HttpStatus httpStatus, String message, HttpServletRequest request) {
        return ResponseEntity
                .status(httpStatus)
                .body(new AppResponse(
                        httpStatus.value(),
                        httpStatus.name(),
                        httpStatus.getReasonPhrase(),
                        request.getRequestURL().toString(),
                        null, LocalDateTime.now(),
                        message
                ));
    }

    private ResponseEntity<AppResponse> builder(HttpStatus httpStatus, Exception exception, Map<String, String> errors, HttpServletRequest request) {
        return ResponseEntity
                .status(httpStatus)
                .body(new AppResponse(
                        httpStatus.value(),
                        httpStatus.name(),
                        httpStatus.getReasonPhrase(),
                        request.getRequestURL().toString(),
                        errors,
                        LocalDateTime.now(),
                        getExceptionMessage(exception)
                ));
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<AppResponse> badCredentialsExceptionHandler(BadCredentialsException badCredentialsException, HttpServletRequest request) {
        return builder(HttpStatus.BAD_REQUEST, badCredentialsException, request);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<AppResponse> RuntimeExceptionHandler(RuntimeException runtimeException, HttpServletRequest request) {
        return builder(HttpStatus.INTERNAL_SERVER_ERROR, runtimeException, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppResponse> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (existing, replacement) -> existing, // handle duplicate keys
                        LinkedHashMap::new
                ));

        return builder(HttpStatus.BAD_REQUEST, ex, errors, request);
    }

}
