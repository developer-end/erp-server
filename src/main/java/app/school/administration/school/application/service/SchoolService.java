package app.school.administration.school.application.service;

import app.school.administration.school.infrastructure.persistance.entity.SchoolEntity;
import app.school.administration.school.infrastructure.persistance.projection.SchoolProjectionDTO;

import java.util.UUID;

public interface SchoolService {

    SchoolEntity deActivate(UUID uuid);

    SchoolEntity activate(UUID uuid);

    SchoolEntity save(SchoolEntity schoolEntity);

    SchoolEntity update(SchoolProjectionDTO dto, UUID uuid);

    SchoolProjectionDTO findByIdProjection(UUID uuid);

}
