package app.school.administration.auth.application.context;

import java.util.UUID;

public final class UserContext {

    private static final ThreadLocal<UUID> USER_ID = new ThreadLocal<>();

    private UserContext() {
    }

    public static UUID getUser() {
        return USER_ID.get();
    }

    public static void setUser(UUID userId) {
        USER_ID.set(userId);
    }

    public static void clear() {
        USER_ID.remove();
    }

}
