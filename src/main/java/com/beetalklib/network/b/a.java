package com.beetalklib.network.b;

public class a extends Exception {
    private final String mMessage;

    public a(Exception exc, String str) {
        super(exc);
        this.mMessage = str;
    }

    public String getMessage() {
        return this.mMessage;
    }
}
