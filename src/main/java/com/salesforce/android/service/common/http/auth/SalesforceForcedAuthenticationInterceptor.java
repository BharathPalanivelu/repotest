package com.salesforce.android.service.common.http.auth;

import com.salesforce.android.service.common.http.AuthTokenProvider;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class SalesforceForcedAuthenticationInterceptor implements Interceptor {
    private final AuthTokenProvider mAuthTokenProvider;

    public SalesforceForcedAuthenticationInterceptor(AuthTokenProvider authTokenProvider) {
        this.mAuthTokenProvider = authTokenProvider;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().addHeader(AuthHelper.getAuthHeaderKey(), AuthHelper.getAuthHeaderValue(this.mAuthTokenProvider)).build());
    }
}
