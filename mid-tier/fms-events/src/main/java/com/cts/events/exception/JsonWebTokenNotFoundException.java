package com.cts.events.exception;

public class JsonWebTokenNotFoundException extends ObjectNotFoundException {
    public JsonWebTokenNotFoundException(String token) {
        super(String.format("The Json Web Token cannot be found: %s", token));
    }
}
