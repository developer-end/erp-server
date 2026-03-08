package app.school.administration.auth.application.service;

import app.school.administration.auth.infrastructure.persistence.entity.OAuthAccountEntity;
import app.school.administration.auth.infrastructure.persistence.projection.OAuthAccountProjectionDTO;

import java.util.UUID;

public interface OAuthUserService {

    OAuthAccountProjectionDTO findByIdProjection(UUID uuid);

    OAuthAccountEntity save(OAuthAccountEntity oAuthAccountEntity);

    OAuthAccountEntity update(OAuthAccountEntity oAuthAccountEntity, UUID uuid);

    OAuthAccountEntity activate(UUID uuid);

    OAuthAccountEntity deActivate(UUID uuid);

}
