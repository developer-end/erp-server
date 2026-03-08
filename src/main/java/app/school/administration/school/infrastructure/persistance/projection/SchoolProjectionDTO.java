package app.school.administration.school.infrastructure.persistance.projection;

import app.school.administration.common.infrastucture.persistence.projection.AuditableProjectionDTO;

import java.util.Set;

public interface SchoolProjectionDTO extends AuditableProjectionDTO {
    String getSchoolName();

    Set<TenantSchoolProjectionDTO> getTenantSchoolEntities();

    InstitutionProjectionDTO getInstitution();

    interface InstitutionProjectionDTO extends AuditableProjectionDTO {
        String getInstitutionName();

        String getInstitutionCode();

        String getDescription();

    }

    interface TenantSchoolProjectionDTO extends AuditableProjectionDTO {
        TenantProjectionDTO getTenant();
    }

    interface TenantProjectionDTO extends AuditableProjectionDTO {
        String getTenantName();

        String getDescription();
    }
}
