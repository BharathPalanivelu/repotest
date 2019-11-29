package com.google.b.a;

public class g extends Exception {
    private a errorType;
    private String message;

    public enum a {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public g(a aVar, String str) {
        super(str);
        this.message = str;
        this.errorType = aVar;
    }

    public a a() {
        return this.errorType;
    }

    public String toString() {
        return "Error type: " + this.errorType + ". " + this.message;
    }
}
