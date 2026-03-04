package app.school.administration.auth.repository;

import app.school.administration.auth.entity.RoleEntity;
import app.school.administration.common.base.repository.AppBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends AppBaseRepository<RoleEntity, UUID> {

}
