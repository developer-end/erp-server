package app.school.administration.school.infrastructure.persistance.projection;

import app.school.administration.auth.infrastructure.persistence.projection.TenantProjectionDTO;
import app.school.administration.common.infrastucture.persistence.projection.AuditableProjectionDTO;

public interface TenantSchoolProjectionDTO extends AuditableProjectionDTO {
    TenantProjectionDTO getTenantDto();

    SchoolProjectionDTO getSchoolDto();
}
