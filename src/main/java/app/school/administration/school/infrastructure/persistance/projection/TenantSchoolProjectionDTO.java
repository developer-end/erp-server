package app.school.administration.school.infrastructure.persistance.projection;

import app.school.administration.common.infrastucture.persistence.projection.AuditableProjectionDTO;
import app.school.administration.auth.infrastructure.persistence.projection.TenantProjectionDTO;

public interface TenantSchoolProjectionDTO extends AuditableProjectionDTO {
    TenantProjectionDTO getTenantDto();

    SchoolProjectionDTO getSchoolDto();
}
