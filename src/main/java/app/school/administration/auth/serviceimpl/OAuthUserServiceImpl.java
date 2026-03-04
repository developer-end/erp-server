package app.school.administration.auth.serviceimpl;

import app.school.administration.auth.entity.OAuthAccountEntity;
import app.school.administration.auth.projection.OAuthAccountProjectionDTO;
import app.school.administration.auth.repository.OAuthUserRepository;
import app.school.administration.auth.service.OAuthUserService;
import app.school.administration.common.base.repository.AppBaseRepository;
import app.school.administration.common.base.service.AppBaseService;
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
