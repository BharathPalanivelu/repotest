package com.google.firebase.iid;

public final class p extends Exception {
    private final int errorCode;

    public p(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public final int a() {
        return this.errorCode;
    }
}
