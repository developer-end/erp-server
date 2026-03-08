package app.school.administration.auth.infrastructure.persistence.repository;

import app.school.administration.common.domain.model.repository.AppBaseRepository;
import app.school.administration.auth.infrastructure.persistence.entity.TenantEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TenantRepository extends AppBaseRepository<TenantEntity, UUID> {

}
