package app.school.administration.auth.application.serviceimpl;

import app.school.administration.auth.application.service.OAuthUserService;
import app.school.administration.auth.infrastructure.persistence.entity.OAuthAccountEntity;
import app.school.administration.auth.infrastructure.persistence.projection.OAuthAccountProjectionDTO;
import app.school.administration.auth.infrastructure.persistence.repository.OAuthUserRepository;
import app.school.administration.common.application.serviceimpl.AppBaseService;
import app.school.administration.common.domain.repository.AppBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OAuthUserServiceImpl extends AppBaseService<OAuthAccountEntity, UUID> implements OAuthUserService {

    private final OAuthUserRepository oAuthUserRepository;

    @Override
    protected AppBaseRepository<OAuthAccountEntity, UUID> getJpaRepository() {
        return this.oAuthUserRepository;
    }

    @Override
    public OAuthAccountProjectionDTO findByIdProjection(UUID id) {
        OAuthAccountProjectionDTO dto = appFindByIdProjection(id, OAuthAccountProjectionDTO.class);
        return dto;
    }

    /**
     * @param oAuthAccountEntity
     * @return
     */
    @Override
    public OAuthAccountEntity save(OAuthAccountEntity oAuthAccountEntity) {
        return appSave(oAuthAccountEntity);
    }

    /**
     * @param oAuthAccountEntity
     * @param uuid
     * @return
     */
    @Override
    public OAuthAccountEntity update(OAuthAccountEntity oAuthAccountEntity, UUID uuid) {
        OAuthAccountEntity school = appFindByIdWithDirtyCheck(uuid);
        BeanUtils.copyProperties(oAuthAccountEntity, school);
        return school;
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public OAuthAccountEntity activate(UUID uuid) {
        return appActivate(uuid);
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public OAuthAccountEntity deActivate(UUID uuid) {
        return appDeActivate(uuid);
    }


}
