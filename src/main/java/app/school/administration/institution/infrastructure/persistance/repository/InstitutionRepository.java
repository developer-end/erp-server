package app.school.administration.institution.infrastructure.persistance.repository;

import app.school.administration.common.domain.repository.AppBaseRepository;
import app.school.administration.institution.infrastructure.persistance.entity.InstitutionEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstitutionRepository extends AppBaseRepository<InstitutionEntity, UUID> {

}
