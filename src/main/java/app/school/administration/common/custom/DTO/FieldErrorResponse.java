package app.school.administration.common.custom.DTO;

public record FieldErrorResponse(String field, Object rejectedValue, String error) {
}
