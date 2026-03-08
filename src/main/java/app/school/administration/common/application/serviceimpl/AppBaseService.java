package app.school.administration.common.application.serviceimpl;

import app.school.administration.common.infrastucture.persistence.entity.AuditableBaseEntity;
import app.school.administration.common.domain.model.repository.AppBaseRepository;
import app.school.administration.common.application.custom.exception.EntityNotFoundedException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public abstract class AppBaseService<T extends AuditableBaseEntity, UUID> {

    protected abstract AppBaseRepository<T, UUID> getJpaRepository();

    @Transactional(readOnly = true)
    public T appFindById(@Validated @NotNull UUID uuid) {
        return this.getJpaRepository().findById(uuid).orElseThrow(() -> new EntityNotFoundedException((java.util.UUID) uuid));
    }

    @Transactional(readOnly = true)
    public <P> P appFindByIdProjection(@Validated @NotNull UUID uuid, Class<P> projection) {
        return getJpaRepository().findById(uuid, projection).orElseThrow(() -> new EntityNotFoundedException((java.util.UUID) uuid));
    }

    public T appFindByIdWithDirtyCheck(@Validated @NotNull UUID uuid) {
        return this.getJpaRepository().findById(uuid).orElseThrow(() -> new EntityNotFoundedException((java.util.UUID) uuid));
    }

    @Transactional
    public T appSave(@Validated @NotNull T t) {
        return this.getJpaRepository().save(t);
    }

    @Transactional
    public List<T> appSaveAll(@Validated @NotNull List<T> t) {
        return this.getJpaRepository().saveAll(t);
    }

    @Transactional
    public T appUpdate(@Validated @NotNull T t, @NotNull UUID uuid) {
        T t1 = appFindByIdWithDirtyCheck(uuid);
        BeanUtils.copyProperties(t, t1);
        return t1;
    }

    @Transactional
    public T appDeActivate(@Validated @NotNull UUID uuid) {
        T t = appFindByIdWithDirtyCheck(uuid);
        t.setActive(false);
        return t;
    }

    @Transactional
    public T appActivate(@Validated @NotNull UUID uuid) {
        T t = appFindByIdWithDirtyCheck(uuid);
        t.setActive(true);
        return t;
    }


}
