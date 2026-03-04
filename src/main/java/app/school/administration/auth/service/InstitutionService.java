package app.school.administration.auth.service;

import app.school.administration.auth.entity.InstitutionEntity;
import app.school.administration.auth.projection.InstitutionProjectionDTO;

import java.util.UUID;

public interface InstitutionService {

    InstitutionProjectionDTO findByIdProjection(UUID uuid);

    InstitutionEntity save(InstitutionEntity institution);

    InstitutionEntity update(InstitutionProjectionDTO institution, UUID uuid);

    InstitutionEntity activate(UUID uuid);

    InstitutionEntity deActivate(UUID uuid);


}
