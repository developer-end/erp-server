package app.school.administration.utils;

public final class AppCommonEndPoint {

    public static final String FIND_BY_ID = "/findById/{uuid}";
    public static final String CREATE = "/create";
    public static final String UPDATE = "/update";
    public static final String DE_ACTIVATE = "/deActivate/{uuid}";
    public static final String ACTIVATE = "/activate/{uuid}";

    private AppCommonEndPoint() {
    }

}
