package com.cts.auth.exception;


public class InvalidAuthTokenException extends ObjectNotFoundException {
    public InvalidAuthTokenException(String token) {
        super(String.format("Invalid token: %s", token));
    }
}
