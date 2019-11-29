package com.beetalk.sdk;

public enum m {
    CREATED(1),
    OPENING(2),
    TOKEN_AVAILABLE(3),
    CLOSED(4),
    CLOSED_WITH_ERROR(5),
    INSPECTION_WITH_ERROR(6),
    CLOSED_WITH_BIND_FAIL(7);
    
    private int value;

    private m(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
