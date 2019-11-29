package com.shopee.react.sdk.bridge.protocol;

public class ShareResult {
    public static int SHARE_RESULT_APP_NOT_INSTALL = 2;
    public static int SHARE_RESULT_APP_UNKNOWN_ERROR = -1;
    public static int SHARE_RESULT_INVALID_SHARING_DATA = 1;
    public static int SHARE_RESULT_SUCCESS = 0;
    public static int SHARE_RESULT_UNSUPPORTED_APP = 3;
    private final int errorCode;
    private final String errorMessage;

    public ShareResult(int i, String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
