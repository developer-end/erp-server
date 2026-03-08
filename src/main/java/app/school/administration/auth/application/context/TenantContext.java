package app.school.administration.auth.application.context;

public final class TenantContext {

    private static final ThreadLocal<String> TENANT_NAME = new ThreadLocal<>();

    private TenantContext() {
    }

    public static String getTenant() {
        return TENANT_NAME.get();
    }

    public static void setTenant(String tenant) {
        TENANT_NAME.set(tenant);
    }

    public static void clear() {
        TENANT_NAME.remove();
    }

}
