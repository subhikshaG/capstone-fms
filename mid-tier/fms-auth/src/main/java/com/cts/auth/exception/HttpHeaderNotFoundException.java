package com.cts.auth.exception;


public class HttpHeaderNotFoundException extends ObjectNotFoundException {
    public HttpHeaderNotFoundException(String headerName) {
        super(String.format("The http header %s is not found.", headerName));
    }
}
