package app.school.administration.common.base.DTO;

import java.time.LocalDateTime;
import java.util.Map;

public record AppResponse(int code, String status, String message, String requestURL,
                          Map<String, String> errors,
                          LocalDateTime timestamp,
                          String detailMessage
) {
}
