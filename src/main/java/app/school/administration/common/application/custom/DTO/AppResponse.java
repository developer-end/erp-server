package app.school.administration.common.application.custom.DTO;

import java.time.LocalDateTime;
import java.util.List;

public record AppResponse(int status, String message, String requestURL,
                          List<FieldErrorResponse> errors,
                          LocalDateTime timestamp,
                          String detailMessage
) {
}
