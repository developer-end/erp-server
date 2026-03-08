package app.school.administration.school.application.serviceimpl;

import app.school.administration.common.application.serviceimpl.AppBaseService;
import app.school.administration.common.domain.repository.AppBaseRepository;
import app.school.administration.school.application.service.SchoolService;
import app.school.administration.school.infrastructure.persistance.entity.SchoolEntity;
import app.school.administration.school.infrastructure.persistance.projection.SchoolProjectionDTO;
import app.school.administration.school.infrastructure.persistance.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl extends AppBaseService<SchoolEntity, UUID> implements SchoolService {

    private final SchoolRepository schoolRepository;

    @Override
    protected AppBaseRepository<SchoolEntity, UUID> getJpaRepository() {
        return schoolRepository;
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public SchoolEntity deActivate(UUID uuid) {
        return appDeActivate(uuid);
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public SchoolEntity activate(UUID uuid) {
        return appActivate(uuid);
    }

    /**
     * @param schoolEntity
     * @return
     */
    @Override
    public SchoolEntity save(SchoolEntity schoolEntity) {
        return appSave(schoolEntity);
    }

    /**
     * @param dto
     * @param uuid
     * @return
     */
    @Override
    public SchoolEntity update(SchoolProjectionDTO dto, UUID uuid) {
        SchoolEntity school = appFindByIdWithDirtyCheck(uuid);
        BeanUtils.copyProperties(dto, school);
        return school;
    }

    @Override
    public SchoolProjectionDTO findByIdProjection(UUID uuid) {
        return appFindByIdProjection(uuid, SchoolProjectionDTO.class);
    }


}
