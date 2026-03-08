package app.school.administration.auth.infrastructure.persistence.projection;

import app.school.administration.common.infrastucture.persistence.projection.AuditableProjectionDTO;

public interface UserRoleProjectionDTO extends AuditableProjectionDTO {

    UserProjectionDTO getUser();

    RoleProjectionDTO getRole();

}
