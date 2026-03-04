package app.school.administration.common.jwt.component;

import app.school.administration.auth.constant.AuthConstant;
import app.school.administration.auth.custom.CustomUserDetails;
import app.school.administration.auth.custom.service.CustomUserDetailsService;
import app.school.administration.common.custom.exception.InvalidTokenException;
import app.school.administration.common.jwt.service.AppContextService;
import app.school.administration.common.jwt.service.JWTService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final CustomUserDetailsService userDetailsService;
    private final AppContextService appContextService;

    @Override
    protected boolean shouldNotFilter(@NonNull HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return AuthConstant.PUBLIC_ENDPOINTS.stream().anyMatch(requestURI::startsWith);
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        final String ACCESS_TOKEN = jwtService.tokenResolver(request);

        if (ACCESS_TOKEN == null) {
            filterChain.doFilter(request, response);
            return;
        }
        String username = jwtService.extractAllClaims(ACCESS_TOKEN).getSubject();

        try {
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                CustomUserDetails customUserDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(username);
                if (jwtService.isTokenValid(ACCESS_TOKEN)) {
                    var authToken = new UsernamePasswordAuthenticationToken(
                            customUserDetails, null, customUserDetails.getAuthorities()
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    appContextService.createAuthContexts(customUserDetails);
                } else {
                    throw new InvalidTokenException();
                }
            }
        } catch (JwtException e) {
            SecurityContextHolder.clearContext();
            appContextService.clearAuthContext();
            throw new BadCredentialsException("Invalid token");
        }

        filterChain.doFilter(request, response);
    }
}
