package app.school.administration.auth.projection;

import java.util.Set;

public interface TenantProjectionDTO extends AuditableProjectionDTO {

    String getTenantName();

    String getDescription();

    Set<SchoolProjectionDTO> getSchools();

    interface SchoolProjectionDTO extends AuditableProjectionDTO {
        String getSchoolName();
    }

}
