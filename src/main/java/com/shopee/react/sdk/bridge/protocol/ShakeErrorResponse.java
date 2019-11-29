package com.shopee.react.sdk.bridge.protocol;

public class ShakeErrorResponse {
    private final int error;
    private final String errorMessage;

    public ShakeErrorResponse(int i, String str) {
        this.error = i;
        this.errorMessage = str;
    }

    public ShakeErrorResponse(int i) {
        this.error = i;
        this.errorMessage = null;
    }

    public int getError() {
        return this.error;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
