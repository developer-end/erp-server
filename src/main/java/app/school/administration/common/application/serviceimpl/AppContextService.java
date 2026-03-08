package app.school.administration.common.application.serviceimpl;

import app.school.administration.auth.application.context.InstitutionContext;
import app.school.administration.auth.application.context.SchoolContext;
import app.school.administration.auth.application.context.TenantContext;
import app.school.administration.auth.application.context.UserContext;
import app.school.administration.auth.domain.model.CustomUserDetails;
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
