package app.school.administration.common.application.custom.DTO;

public record FieldErrorResponse(String field, Object rejectedValue, String error) {
}
