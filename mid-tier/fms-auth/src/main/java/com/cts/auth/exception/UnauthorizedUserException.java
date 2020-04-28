package com.cts.auth.exception;

public class UnauthorizedUserException extends ObjectNotFoundException {
    public UnauthorizedUserException(String userId) {
        super(String.format("The unauthorized user cannot be accessible. (userId: %s)", userId));
    }
}
