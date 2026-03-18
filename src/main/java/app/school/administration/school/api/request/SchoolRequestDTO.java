package app.school.administration.school.api.request;

import app.school.administration.auth.api.request.TenantRequestDTO;

import java.util.Set;
import java.util.UUID;

public record SchoolRequestDTO(UUID id, String schoolName, Set<TenantRequestDTO> requestDTOSet) {
}
