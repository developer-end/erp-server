package app.school.administration.auth.infrastructure.persistence.projection;

import app.school.administration.common.infrastucture.persistence.projection.AuditableProjectionDTO;

public interface OAuthAccountProjectionDTO extends AuditableProjectionDTO {
    String getInstitutionName();

    String getInstitutionCode();

    String getDescription();

    UserProjectionDTO getUserDto();

    interface UserProjectionDTO extends AuditableProjectionDTO {

        String getFirstName();

        String getLastName();

        String getEmail();

        String getUsername();

        String getMobileNo();

    }
}
