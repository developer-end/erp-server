package app.school.administration.institution.application.serviceimpl;

import app.school.administration.common.domain.model.repository.AppBaseRepository;
import app.school.administration.common.application.serviceimpl.AppBaseService;
import app.school.administration.institution.infrastructure.persistance.entity.InstitutionEntity;
import app.school.administration.institution.infrastructure.persistance.projection.InstitutionProjectionDTO;
import app.school.administration.institution.infrastructure.persistance.repository.InstitutionRepository;
import app.school.administration.institution.application.service.InstitutionService;
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
