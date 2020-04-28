package com.cts.events.exception;
public class InvalidAuthRequestException extends ObjectNotFoundException {
    public InvalidAuthRequestException(){
        super("Invalid AuthRequest is found.");
    }
}
