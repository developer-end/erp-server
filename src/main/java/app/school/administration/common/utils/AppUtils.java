package app.school.administration.common.utils;

import app.school.administration.common.base.DTO.AppResponse;

import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class AppUtils {

    public static <T> void setValueOrElseDefault(Supplier<T> getter, Consumer<T> setter, T defaultValue) {
        T value = getter.get();
        if (value == null) {
            setter.accept(defaultValue);
        } else {
            setter.accept(value);
        }
    }

    public AppResponse buildResponse() {
        return null;
    }

}
