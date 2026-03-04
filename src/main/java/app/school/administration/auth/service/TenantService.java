package app.school.administration.auth.service;

import app.school.administration.auth.entity.TenantEntity;
import app.school.administration.auth.projection.TenantProjectionDTO;

import java.util.UUID;

public interface TenantService {

    TenantProjectionDTO findByIdProjection(UUID uuid);

    TenantEntity deActivate(UUID uuid);

    TenantEntity activate(UUID uuid);

    TenantEntity save(TenantEntity tenantEntity);

    TenantEntity update(TenantProjectionDTO dto, UUID uuid);

}
