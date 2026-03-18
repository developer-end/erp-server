package app.school.administration.auth.infrastructure.persistence.repository;

import app.school.administration.auth.infrastructure.persistence.entity.embeddable.UserRoleId;
import app.school.administration.auth.infrastructure.persistence.entity.mapping.UserRoleEntity;
import app.school.administration.common.domain.repository.AppBaseRepository;
import app.school.administration.school.infrastructure.persistance.entity.embeddable.TenantSchoolId;
import app.school.administration.school.infrastructure.persistance.entity.mapping.TenantSchoolEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends AppBaseRepository<UserRoleEntity, UserRoleId> {

}
