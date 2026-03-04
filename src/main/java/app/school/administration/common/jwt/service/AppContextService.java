package app.school.administration.common.jwt.service;

import app.school.administration.auth.context.InstitutionContext;
import app.school.administration.auth.context.SchoolContext;
import app.school.administration.auth.context.TenantContext;
import app.school.administration.auth.context.UserContext;
import app.school.administration.auth.custom.CustomUserDetails;
import org.springframework.stereotype.Service;

@Service
public class AppContextService {

    public void createAuthContexts(CustomUserDetails customUserDetails) {
        UserContext.setUser(customUserDetails.toAuthUser().id());
    }

    public void clearAuthContext() {
        InstitutionContext.clear();
        SchoolContext.clear();
        UserContext.clear();
        TenantContext.clear();
    }

}
