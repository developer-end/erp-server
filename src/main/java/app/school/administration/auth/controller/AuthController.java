package app.school.administration.auth.controller;

import app.school.administration.auth.DTO.SignInRequestDTO;
import app.school.administration.auth.DTO.SignInResponseDTO;
import app.school.administration.auth.serviceimpl.AuthServiceImpl;
import app.school.administration.auth.utils.AppAuthEndPoints;
import app.school.administration.auth.utils.AppModuleApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppModuleApi.AUTH)
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping(AppAuthEndPoints.SIGN_IN)
    public ResponseEntity<SignInResponseDTO> signIn(@Validated @RequestBody SignInRequestDTO dto) {
        return ResponseEntity.ok(authService.signIn(dto));
    }

}
