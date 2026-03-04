package app.school.administration.common.custom.exception;

import app.school.administration.common.constant.AppMessages;

import java.util.NoSuchElementException;
import java.util.UUID;

public class EntityNotFoundedException extends NoSuchElementException {

    public EntityNotFoundedException(UUID uuid) {
        super(AppMessages.ENTITY_NOT_FOUNDED + " for the given id : " + uuid);
    }

    public EntityNotFoundedException() {
        super(AppMessages.ENTITY_NOT_FOUNDED);
    }

    public EntityNotFoundedException(String message) {
        super(message);
    }
}
