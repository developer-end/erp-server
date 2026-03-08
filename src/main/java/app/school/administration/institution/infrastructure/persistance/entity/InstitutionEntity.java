package app.school.administration.institution.infrastructure.persistance.entity;

import app.school.administration.common.infrastucture.persistence.entity.AuditableBaseEntity;
import app.school.administration.school.infrastructure.persistance.entity.SchoolEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "institution_table", schema = "master")
@DynamicUpdate
@DynamicInsert
public class InstitutionEntity extends AuditableBaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "institution_id", nullable = false, updatable = false, unique = true)
    private UUID id;
    @Column(name = "institution_name", nullable = false, unique = true)
    private String institutionName;
    @Column(name = "institution_code", nullable = false, unique = true)
    private String institutionCode;
    @Column(name = "description")
    private String description;
    @OneToMany(
            mappedBy = "institution",
            fetch = FetchType.LAZY
    )
    @Where(clause = "is_active = true")
    private Set<SchoolEntity> schools = new HashSet<>();

    protected InstitutionEntity() {
    }

}
