package app.school.administration.auth.serviceimpl;

import app.school.administration.auth.entity.InstitutionEntity;
import app.school.administration.auth.projection.InstitutionProjectionDTO;
import app.school.administration.auth.repository.InstitutionRepository;
import app.school.administration.auth.service.InstitutionService;
import app.school.administration.common.base.repository.AppBaseRepository;
import app.school.administration.common.base.service.AppBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl extends AppBaseService<InstitutionEntity, UUID> implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    @Override
    protected AppBaseRepository<InstitutionEntity, UUID> getJpaRepository() {
        return this.institutionRepository;
    }

    @Override
    public InstitutionProjectionDTO findByIdProjection(UUID uuid) {
        return appFindByIdProjection(uuid, InstitutionProjectionDTO.class);
    }

    /**
     * @param institution
     * @return
     */
    @Override
    public InstitutionEntity save(InstitutionEntity institution) {
        return appSave(institution);
    }

    /**
     * @param institution
     * @param uuid
     * @return
     */
    @Override
    public InstitutionEntity update(InstitutionProjectionDTO institution, UUID uuid) {
        InstitutionEntity institutionEntity = appFindByIdWithDirtyCheck(uuid);
        BeanUtils.copyProperties(institution, institutionEntity);
        return institutionEntity;
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public InstitutionEntity activate(UUID uuid) {
        return appActivate(uuid);
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public InstitutionEntity deActivate(UUID uuid) {
        return appDeActivate(uuid);
    }

}
