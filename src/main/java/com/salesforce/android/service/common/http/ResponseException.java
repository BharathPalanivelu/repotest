package com.salesforce.android.service.common.http;

public class ResponseException extends Exception {
    final int mErrorCode;
    final String mResponseBody;

    public ResponseException(String str, int i, String str2) {
        super(str);
        this.mErrorCode = i;
        this.mResponseBody = str2;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getResponseBody() {
        return this.mResponseBody;
    }
}
