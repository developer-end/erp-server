package app.school.administration.common.infrastucture.persistence.projection;

import java.time.Instant;
import java.util.UUID;

public interface AuditableProjectionDTO {

    UUID getId();

    Instant getCreatedAt();

    Instant getUpdatedAt();

}
