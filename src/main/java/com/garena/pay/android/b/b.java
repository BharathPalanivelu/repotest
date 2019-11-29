package com.garena.pay.android.b;

public class b extends RuntimeException {
    private String message;

    public b(String str) {
        super(str);
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }
}
