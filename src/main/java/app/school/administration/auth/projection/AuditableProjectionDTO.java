package app.school.administration.auth.projection;

import java.time.Instant;
import java.util.UUID;

public interface AuditableProjectionDTO {

    UUID getId();

    Instant getCreatedAt();

    Instant getUpdatedAt();

}
