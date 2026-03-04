package app.school.administration.auth.entity;

import app.school.administration.auth.entity.mapping.TenantSchoolEntity;
import app.school.administration.common.base.entity.AuditableBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "school_table", schema = "master",
        indexes = {@Index(name = "idx_school_table_active", columnList = "is_active")})
public class SchoolEntity extends AuditableBaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "school_id", nullable = false, updatable = false, unique = true)
    private UUID id;
    @Column(name = "school_name", nullable = false, unique = true)
    private String schoolName;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "school"
    )
    @Where(clause = "is_active = true")
    private Set<TenantSchoolEntity> tenantSchoolEntities = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id", nullable = false)
    private InstitutionEntity institution;

    protected SchoolEntity() {
    }

    public void assignTenant(TenantEntity tenant) {
        tenantSchoolEntities.add(new TenantSchoolEntity(tenant, this));
    }

    public void revokeTenant(TenantEntity tenant) {
        tenantSchoolEntities.removeIf(ur -> ur.getTenant().equals(tenant));
    }


}
