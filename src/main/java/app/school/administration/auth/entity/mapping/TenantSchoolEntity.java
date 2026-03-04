package app.school.administration.auth.entity.mapping;

import app.school.administration.auth.entity.SchoolEntity;
import app.school.administration.auth.entity.TenantEntity;
import app.school.administration.auth.entity.embeddable.TenantSchoolId;
import app.school.administration.common.base.entity.AuditableBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tenant_school", schema = "master",
        indexes = {@Index(name = "idx_tenant_school_active", columnList = "is_active")})
public class TenantSchoolEntity extends AuditableBaseEntity {

    @EmbeddedId
    private TenantSchoolId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tenantId")
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantEntity tenant;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("schoolId")
    @JoinColumn(name = "school_id", nullable = false)
    private SchoolEntity school;
    @CreatedDate
    @Column(name = "assigned_at", nullable = false, updatable = false)
    private Instant assignedAt;

    protected TenantSchoolEntity() {
    }

    public TenantSchoolEntity(TenantEntity tenant, SchoolEntity school) {
        this.tenant = tenant;
        this.school = school;
        this.id = new TenantSchoolId(school.getId(), tenant.getId());
    }
}
