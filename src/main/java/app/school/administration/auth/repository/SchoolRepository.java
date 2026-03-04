package app.school.administration.auth.repository;

import app.school.administration.auth.entity.SchoolEntity;
import app.school.administration.common.base.repository.AppBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SchoolRepository extends AppBaseRepository<SchoolEntity, UUID> {

}
