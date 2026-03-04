package app.school.administration.auth.service;

import app.school.administration.auth.entity.SchoolEntity;
import app.school.administration.auth.projection.SchoolProjectionDTO;

import java.util.UUID;

public interface SchoolService {

    SchoolEntity deActivate(UUID uuid);

    SchoolEntity activate(UUID uuid);

    SchoolEntity save(SchoolEntity schoolEntity);

    SchoolEntity update(SchoolProjectionDTO dto, UUID uuid);

    SchoolProjectionDTO findByIdProjection(UUID uuid);

}
