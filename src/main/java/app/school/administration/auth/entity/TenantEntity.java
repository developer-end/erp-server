package app.school.administration.auth.entity;

import app.school.administration.auth.entity.mapping.TenantSchoolEntity;
import app.school.administration.common.base.entity.AuditableBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tenant_table", schema = "master",
        indexes = {@Index(name = "idx_tenant_table_active", columnList = "is_active")})
@Where(clause = "is_active = true")
@DynamicUpdate
public class TenantEntity extends AuditableBaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "tenant_id", nullable = false, updatable = false, unique = true)
    private UUID id;
    @Column(name = "tenant_name", nullable = false, unique = true)
    private String tenantName;
    @Column(name = "description")
    private String description;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "tenant"
    )
    @Where(clause = "is_active = true")
    private Set<TenantSchoolEntity> tenantSchoolEntities = new HashSet<>();

    protected TenantEntity() {
    }

}
