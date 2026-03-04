package app.school.administration.auth.repository;

import app.school.administration.auth.entity.UserEntity;
import app.school.administration.common.base.repository.AppBaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends AppBaseRepository<UserEntity, UUID> {

    @Transactional(readOnly = true)
    Optional<UserEntity> findByUsernameIgnoreCase(String username);

    @Transactional(readOnly = true)
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

}
