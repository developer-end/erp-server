package app.school.administration.auth.service;

import app.school.administration.auth.DTO.SignInRequestDTO;
import app.school.administration.auth.DTO.SignInResponseDTO;
import app.school.administration.auth.DTO.SignUpRequestDTO;
import app.school.administration.auth.DTO.SignUpResponseDTO;

public interface AuthService {

    SignInResponseDTO signIn(SignInRequestDTO dto);

    SignUpResponseDTO signUp(SignUpRequestDTO dto);

}
