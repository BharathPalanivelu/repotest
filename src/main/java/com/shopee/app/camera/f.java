package com.shopee.app.camera;

public class f extends Exception {
    private int errorCode;

    public f(int i) {
        this.errorCode = i;
    }

    public int a() {
        return this.errorCode;
    }
}
