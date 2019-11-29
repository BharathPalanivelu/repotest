package com.shopee.app.tracking;

public enum g {
    WRONG_FORMAT_EMAIL(1),
    WRONG_FORMAT_USERNAME(2),
    WRONG_EMPTY_CAPTCHA(3),
    WRONG_FORMAT_PASSWORD(4),
    PASSWORD_MISMATCH(5),
    WRONG_FORMAT_OTP(6);
    
    private final int value;

    private g(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
