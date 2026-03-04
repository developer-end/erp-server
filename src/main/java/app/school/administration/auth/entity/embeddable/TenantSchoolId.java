package app.school.administration.auth.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class TenantSchoolId implements Serializable {

    @Column(name = "school_id", nullable = false)
    private UUID schoolId;
    @Column(name = "tenant_id", nullable = false)
    private UUID tenantId;

}