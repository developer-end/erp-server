package app.school.administration.common.application.constant;

import app.school.administration.auth.application.context.TenantContext;

public interface CacheConstant {

    String UNLESS_RESULT_IS_NULL = "#result == null";

    String CURRENT_TENANT_NAME = TenantContext.getTenant() + ":";

}
