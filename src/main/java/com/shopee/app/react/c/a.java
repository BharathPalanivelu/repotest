package com.shopee.app.react.c;

public class a extends Exception {
    public a() {
        super("This function should not be called while the current activity in not in foreground.");
    }
}
