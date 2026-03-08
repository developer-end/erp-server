package app.school.administration.common.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface AppBaseRepository<T, UUID> extends JpaRepository<T, UUID> {

    <P> Optional<P> findById(UUID uuid, Class<P> projection);

}
