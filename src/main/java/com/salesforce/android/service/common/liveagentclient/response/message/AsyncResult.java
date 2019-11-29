package com.salesforce.android.service.common.liveagentclient.response.message;

import com.google.a.a.c;

public class AsyncResult {
    public static final String TYPE = "AsyncResult";
    @c(a = "error")
    private String mErrorMessage;
    @c(a = "isSuccess")
    private boolean mIsSuccess;

    public AsyncResult(String str) {
        this.mErrorMessage = str;
    }

    public boolean isError() {
        return this.mErrorMessage != null;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }
}
