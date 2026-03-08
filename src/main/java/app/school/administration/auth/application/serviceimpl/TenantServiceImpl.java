package app.school.administration.auth.application.serviceimpl;

import app.school.administration.auth.application.service.TenantService;
import app.school.administration.auth.infrastructure.persistence.entity.TenantEntity;
import app.school.administration.auth.infrastructure.persistence.projection.TenantProjectionDTO;
import app.school.administration.auth.infrastructure.persistence.repository.TenantRepository;
import app.school.administration.common.application.serviceimpl.AppBaseService;
import app.school.administration.common.domain.repository.AppBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl extends AppBaseService<TenantEntity, UUID> implements TenantService {

    private final TenantRepository tenantRepository;

    @Override
    protected AppBaseRepository<TenantEntity, UUID> getJpaRepository() {
        return this.tenantRepository;
    }

    @Override
    public TenantProjectionDTO findByIdProjection(UUID id) {
        return appFindByIdProjection(id, TenantProjectionDTO.class);
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public TenantEntity deActivate(UUID uuid) {
        return deActivate(uuid);
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public TenantEntity activate(UUID uuid) {
        return appActivate(uuid);
    }

    /**
     * @param tenant
     * @return
     */
    @Override
    public TenantEntity save(TenantEntity tenant) {
        return appSave(tenant);
    }

    /**
     * @param dto
     * @param uuid
     * @return
     */
    @Override
    public TenantEntity update(TenantProjectionDTO dto, UUID uuid) {
        TenantEntity tenantEntity = appFindByIdWithDirtyCheck(uuid);
        BeanUtils.copyProperties(dto, tenantEntity);
        return tenantEntity;
    }

}
