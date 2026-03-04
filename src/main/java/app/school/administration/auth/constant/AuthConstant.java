package app.school.administration.auth.constant;

import app.school.administration.auth.utils.AppModuleApi;

import java.util.Set;

public interface AuthConstant {

    Set<String> PUBLIC_ENDPOINTS = Set.of(
            AppModuleApi.AUTH,
            AppModuleApi.O_AUTH
            , AppModuleApi.SCHOOL
            , AppModuleApi.INSTITUTION
    );

}
