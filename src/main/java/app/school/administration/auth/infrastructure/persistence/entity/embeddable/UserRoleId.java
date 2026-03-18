package app.school.administration.auth.infrastructure.persistence.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserRoleId implements Serializable {

    @Column(name = "user_id", nullable = false)
    private UUID userId;
    @Column(name = "role_id", nullable = false)
    private UUID roleId;

}