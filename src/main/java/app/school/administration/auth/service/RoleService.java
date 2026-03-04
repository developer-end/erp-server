package app.school.administration.auth.service;

import app.school.administration.auth.entity.RoleEntity;
import app.school.administration.auth.projection.RoleProjectionDTO;

import java.util.UUID;

public interface RoleService {

    RoleProjectionDTO findByIdProjection(UUID uuid);

    RoleEntity save(RoleEntity roleEntity);

    RoleEntity update(RoleProjectionDTO dto, UUID uuid);

    RoleEntity activate(UUID uuid);

    RoleEntity deActivate(UUID uuid);

}
