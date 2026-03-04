package app.school.administration.auth.service;

import app.school.administration.auth.entity.UserEntity;
import app.school.administration.auth.projection.UserProjectionDTO;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserEntity findByUsernameIgnoreCase(String userName);

    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    UserProjectionDTO findByIdProjection(UUID uuid);

    UserEntity deActivate(UUID uuid);

    UserEntity activate(UUID uuid);

    UserEntity save(UserEntity user);

    UserEntity update(UserProjectionDTO dto, UUID uuid);

}
