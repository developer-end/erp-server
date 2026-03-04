package app.school.administration.auth.serviceimpl;

import app.school.administration.auth.DTO.SignInRequestDTO;
import app.school.administration.auth.DTO.SignInResponseDTO;
import app.school.administration.auth.DTO.SignUpRequestDTO;
import app.school.administration.auth.DTO.SignUpResponseDTO;
import app.school.administration.auth.entity.UserEntity;
import app.school.administration.auth.service.AuthService;
import app.school.administration.common.jwt.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserServiceImpl userService;
    private final JWTService jwtService;

    /**
     * @param dto
     * @return
     */
    @Override
    public SignInResponseDTO signIn(SignInRequestDTO dto) {
        UserEntity user = userService.findByUsernameAndPassword(dto.username(), dto.password())
                .orElseThrow(() -> new BadCredentialsException("Username or password mismatch"));
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        return new SignInResponseDTO(accessToken, refreshToken);
    }

    /**
     * @param dto
     * @return
     */
    @Override
    public SignUpResponseDTO signUp(SignUpRequestDTO dto) {
        return null;
    }

}
