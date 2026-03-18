package app.school.administration.common.api.response;

public record FieldErrorResponse(String field, Object rejectedValue, String error) {
}
