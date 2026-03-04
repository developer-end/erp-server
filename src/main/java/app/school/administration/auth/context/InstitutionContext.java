package app.school.administration.auth.context;

import app.school.administration.auth.projection.InstitutionProjectionDTO;

public final class InstitutionContext {

    private static final ThreadLocal<InstitutionProjectionDTO> CURRENT_INSTITUTION = new ThreadLocal<>();

    private InstitutionContext() {
    }

    public static InstitutionProjectionDTO getInstitution() {
        return CURRENT_INSTITUTION.get();
    }

    public static void setInstitution(InstitutionProjectionDTO institution) {
        CURRENT_INSTITUTION.set(institution);
    }

    public static void clear() {
        CURRENT_INSTITUTION.remove();
    }

}
