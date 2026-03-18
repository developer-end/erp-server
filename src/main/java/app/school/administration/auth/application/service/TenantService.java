package app.school.administration.auth.application.service;

import app.school.administration.auth.infrastructure.persistence.entity.TenantEntity;
import app.school.administration.auth.infrastructure.persistence.projection.TenantProjectionDTO;
import app.school.administration.school.infrastructure.persistance.entity.embeddable.TenantSchoolId;

import java.util.UUID;

public interface TenantService {

    TenantProjectionDTO findByIdProjection(UUID uuid);

    TenantEntity deActivate(UUID uuid);

    Void tenantSchoolMappingDeActivate(TenantSchoolId uuid);

    TenantEntity activate(UUID uuid);

    TenantEntity save(TenantEntity tenantEntity);

    TenantEntity update(TenantProjectionDTO dto, UUID uuid);

}
