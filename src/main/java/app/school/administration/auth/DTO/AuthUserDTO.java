package app.school.administration.auth.DTO;

import java.util.Set;
import java.util.UUID;

public record AuthUserDTO(UUID id, String username, String email, Set<String> roles) {
}
