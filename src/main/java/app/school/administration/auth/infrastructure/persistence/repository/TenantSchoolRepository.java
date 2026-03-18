package app.school.administration.auth.infrastructure.persistence.repository;

import app.school.administration.auth.infrastructure.persistence.entity.TenantEntity;
import app.school.administration.common.domain.repository.AppBaseRepository;
import app.school.administration.school.infrastructure.persistance.entity.embeddable.TenantSchoolId;
import app.school.administration.school.infrastructure.persistance.entity.mapping.TenantSchoolEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TenantSchoolRepository extends AppBaseRepository<TenantSchoolEntity, TenantSchoolId> {

}
