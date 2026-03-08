package app.school.administration.institution.application.service;

import app.school.administration.institution.infrastructure.persistance.entity.InstitutionEntity;
import app.school.administration.institution.infrastructure.persistance.projection.InstitutionProjectionDTO;

import java.util.UUID;

public interface InstitutionService {

    InstitutionProjectionDTO findByIdProjection(UUID uuid);

    InstitutionEntity save(InstitutionEntity institution);

    InstitutionEntity update(InstitutionProjectionDTO institution, UUID uuid);

    InstitutionEntity activate(UUID uuid);

    InstitutionEntity deActivate(UUID uuid);


}
