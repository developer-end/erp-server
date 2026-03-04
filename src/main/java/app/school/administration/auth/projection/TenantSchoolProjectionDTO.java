package app.school.administration.auth.projection;

public interface TenantSchoolProjectionDTO extends AuditableProjectionDTO {
    TenantProjectionDTO getTenantDto();

    SchoolProjectionDTO getSchoolDto();
}
