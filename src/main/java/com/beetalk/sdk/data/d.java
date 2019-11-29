package com.beetalk.sdk.data;

public enum d {
    BEETALK_NATIVE_ANDROID(1),
    BEETALK_OTHERS_ANDROID(2),
    GARENA_NATIVE_ANDROID(3),
    GARENA_WEB_ANDROID(4),
    GARENA_OTHERS(5),
    FACEBOOK(6),
    OTHERS(7),
    GUEST(8);
    
    private int value;

    private d(int i) {
        this.value = i;
    }

    public static d valueOf(int i) {
        for (d dVar : values()) {
            if (dVar.getValue() == i) {
                return dVar;
            }
        }
        return OTHERS;
    }

    public int getValue() {
        return this.value;
    }
}
