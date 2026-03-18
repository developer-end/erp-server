package app.school.administration.auth.api.request;

import java.util.UUID;

public record TenantRequestDTO(UUID id, String tenantName, String description) {
}
