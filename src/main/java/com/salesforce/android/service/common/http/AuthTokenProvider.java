package com.salesforce.android.service.common.http;

public interface AuthTokenProvider {
    boolean canRefresh();

    String getToken();

    String getTokenType();

    void refreshToken(ResponseSummary responseSummary);
}
