package com.salesforce.android.chat.core.exception;

public class SessionDoesNotExistException extends RuntimeException {
    public SessionDoesNotExistException() {
        super("Unable to send message because chat session does not exist");
    }
}
