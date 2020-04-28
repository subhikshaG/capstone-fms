package com.cts.events.exception;

public class FailureToIssueTokenException extends ObjectNotFoundException {
    public FailureToIssueTokenException() {
        super("Fail to issue the token for authorization.");
    }
}
