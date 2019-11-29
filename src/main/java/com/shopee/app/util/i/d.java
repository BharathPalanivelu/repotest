package com.shopee.app.util.i;

public enum d {
    NFC_SUPPORTED_AND_ON(0),
    NFC_NOT_SUPPORTED(1),
    NFC_SUPPORTED_BUT_OFF(2),
    USER_DENIED(3),
    WAIT_FOR_NEXT_VIEW_WILL_REAPPEAR(4);
    
    private final int errorCode;

    private d(int i) {
        this.errorCode = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
