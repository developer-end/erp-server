package app.school.administration.auth.application.context;

import app.school.administration.school.infrastructure.persistance.projection.SchoolProjectionDTO;

public final class SchoolContext {

    private static final ThreadLocal<SchoolProjectionDTO> CURRENT_SCHOOL = new ThreadLocal<>();

    private SchoolContext() {
    }

    public static SchoolProjectionDTO getSchool() {
        return CURRENT_SCHOOL.get();
    }

    public static void setSchool(SchoolProjectionDTO school) {
        CURRENT_SCHOOL.set(school);
    }

    public static void clear() {
        CURRENT_SCHOOL.remove();
    }

}
