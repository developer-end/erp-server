package app.school.administration.auth.service;

import app.school.administration.auth.entity.OAuthAccountEntity;
import app.school.administration.auth.projection.OAuthAccountProjectionDTO;

import java.util.UUID;

public interface OAuthUserService {

    OAuthAccountProjectionDTO findByIdProjection(UUID uuid);

    OAuthAccountEntity save(OAuthAccountEntity oAuthAccountEntity);

    OAuthAccountEntity update(OAuthAccountEntity oAuthAccountEntity, UUID uuid);

    OAuthAccountEntity activate(UUID uuid);

    OAuthAccountEntity deActivate(UUID uuid);

}
