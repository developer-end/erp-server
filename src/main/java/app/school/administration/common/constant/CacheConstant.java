package app.school.administration.common.constant;

import app.school.administration.auth.context.TenantContext;

public interface CacheConstant {

    String UNLESS_RESULT_IS_NULL = "#result == null";

    String CURRENT_TENANT_NAME = TenantContext.getTenant() + ":";

}
