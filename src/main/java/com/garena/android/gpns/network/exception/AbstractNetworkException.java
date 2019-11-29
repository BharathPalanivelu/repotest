package com.garena.android.gpns.network.exception;

public class AbstractNetworkException extends Exception {
    private final String mMessage;

    public AbstractNetworkException(Exception exc, String str) {
        super(exc);
        this.mMessage = str;
    }

    public String getMessage() {
        return this.mMessage;
    }
}
