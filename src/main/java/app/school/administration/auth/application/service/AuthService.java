package app.school.administration.auth.application.service;

import app.school.administration.auth.api.request.SignInRequestDTO;
import app.school.administration.auth.api.request.SignUpRequestDTO;
import app.school.administration.auth.api.response.SignInResponseDTO;
import app.school.administration.auth.api.response.SignUpResponseDTO;

public interface AuthService {

    SignInResponseDTO signIn(SignInRequestDTO dto);

    SignUpResponseDTO signUp(SignUpRequestDTO dto);

}
