package app.school.administration.auth.infrastructure.persistence.projection;

import app.school.administration.common.infrastucture.persistence.projection.AuditableProjectionDTO;

public interface RoleProjectionDTO extends AuditableProjectionDTO {
    String getRoleName();

    String getRoleCode();

    String getDescription();

}
