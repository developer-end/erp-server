package app.school.administration.auth.projection;

import java.util.Set;

public interface InstitutionProjectionDTO extends AuditableProjectionDTO {

    String getInstitutionName();

    String getInstitutionCode();

    String getDescription();

    Set<SchoolProjectionDTO> getSchools();

    interface SchoolProjectionDTO extends AuditableProjectionDTO {
        String getSchoolName();

        Set<TenantSchoolProjectionDTO> getTenantSchoolEntities();
    }

    interface TenantSchoolProjectionDTO extends AuditableProjectionDTO {
        TenantProjectionDTO getTenant();
    }

    interface TenantProjectionDTO extends AuditableProjectionDTO {
        String getTenantName();

        String getDescription();
    }

}
