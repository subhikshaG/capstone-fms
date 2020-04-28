package com.cts.events.exception;

public class InvalidAuthTokenException extends ObjectNotFoundException {
    public InvalidAuthTokenException(String token) {
        super(String.format("Invalid token: %s", token));
    }
}
