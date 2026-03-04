package app.school.administration.auth.repository;

import app.school.administration.auth.entity.OAuthAccountEntity;
import app.school.administration.common.base.repository.AppBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OAuthUserRepository extends AppBaseRepository<OAuthAccountEntity, UUID> {

}
