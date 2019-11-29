package com.garena.pay.android.a;

public enum d {
    WEB_VIEW(1),
    NATIVE(2);
    
    private int value;

    private d(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
