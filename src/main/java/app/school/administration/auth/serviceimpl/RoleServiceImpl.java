package app.school.administration.auth.serviceimpl;

import app.school.administration.auth.entity.RoleEntity;
import app.school.administration.auth.projection.RoleProjectionDTO;
import app.school.administration.auth.repository.RoleRepository;
import app.school.administration.auth.service.RoleService;
import app.school.administration.common.base.repository.AppBaseRepository;
import app.school.administration.common.base.service.AppBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends AppBaseService<RoleEntity, UUID> implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    protected AppBaseRepository<RoleEntity, UUID> getJpaRepository() {
        return this.roleRepository;
    }

    @Override
    public RoleProjectionDTO findByIdProjection(UUID id) {
        return appFindByIdProjection(id, RoleProjectionDTO.class);
    }

    /**
     * @param roleEntity
     * @return
     */
    @Override
    public RoleEntity save(RoleEntity roleEntity) {
        return null;
    }

    /**
     * @param dto
     * @param uuid
     * @return
     */
    @Override
    public RoleEntity update(RoleProjectionDTO dto, UUID uuid) {
        RoleEntity roleEntity = appFindByIdWithDirtyCheck(uuid);
        BeanUtils.copyProperties(dto, roleEntity);
        return roleEntity;
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public RoleEntity activate(UUID uuid) {
        return appActivate(uuid);
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public RoleEntity deActivate(UUID uuid) {
        return appDeActivate(uuid);
    }

}
