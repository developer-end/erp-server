package app.school.administration.auth.projection;

public interface UserRoleProjectionDTO extends AuditableProjectionDTO {

    UserProjectionDTO getUser();

    RoleProjectionDTO getRole();

}
