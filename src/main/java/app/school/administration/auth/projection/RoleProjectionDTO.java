package app.school.administration.auth.projection;

public interface RoleProjectionDTO extends AuditableProjectionDTO {
    String getRoleName();

    String getRoleCode();

    String getDescription();

}
