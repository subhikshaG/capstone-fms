package com.cts.auth.exception;


public class InvalidAuthRequestException extends ObjectNotFoundException {
    public InvalidAuthRequestException(){
        super("Invalid AuthRequest is found.");
    }
}
