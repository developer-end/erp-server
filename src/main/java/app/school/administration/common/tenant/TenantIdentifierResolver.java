package app.school.administration.common.tenant;

import app.school.administration.auth.context.TenantContext;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    private static final String DEFAULT_SCHEMA = "master, public";

    @Override
    public Object resolveCurrentTenantIdentifier() {
        String tenant = TenantContext.getTenant();
        return Objects.nonNull(tenant) ? tenant : DEFAULT_SCHEMA;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

}
