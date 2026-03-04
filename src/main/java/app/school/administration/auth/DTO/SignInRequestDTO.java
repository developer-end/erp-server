package app.school.administration.auth.DTO;

import jakarta.validation.constraints.NotBlank;

public record SignInRequestDTO(@NotBlank String username, @NotBlank String password) {
}
