package app.school.administration.auth.infrastructure.persistence.projection;

import app.school.administration.common.infrastucture.persistence.projection.AuditableProjectionDTO;

import java.util.Set;

public interface TenantProjectionDTO extends AuditableProjectionDTO {

    String getTenantName();

    String getDescription();

    Set<TenantSchoolProjectionDTO> getTenantSchoolEntities();

    interface TenantSchoolProjectionDTO extends AuditableProjectionDTO {
        SchoolProjectionDTO getSchool();
    }

    interface SchoolProjectionDTO {
        String getSchoolName();
    }

}
