package com.beetalk.sdk.h;

public enum d {
    CODE("code"),
    TOKEN("token");
    
    String mValue;

    private d(String str) {
        this.mValue = str;
    }

    public String getStringValue() {
        return this.mValue;
    }
}
