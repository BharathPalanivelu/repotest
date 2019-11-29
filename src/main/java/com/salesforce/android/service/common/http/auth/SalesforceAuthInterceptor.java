package com.salesforce.android.service.common.http.auth;

import com.salesforce.android.service.common.http.AuthTokenProvider;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class SalesforceAuthInterceptor implements Interceptor {
    private final AuthTokenProvider mAuthProvider;
    private final ServiceLogger mServiceLogger = ServiceLogging.getLogger(SalesforceAuthInterceptor.class);

    private boolean shouldAuthenticate(int i) {
        return i == 401 || i == 403;
    }

    public SalesforceAuthInterceptor(AuthTokenProvider authTokenProvider) {
        this.mAuthProvider = authTokenProvider;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        if (shouldAuthenticate(proceed.code())) {
            proceed = sendWithBearerIfAble(chain, proceed);
        }
        return shouldAuthenticate(proceed.code()) ? sendWithRefreshIfAble(chain, proceed) : proceed;
    }

    private Response sendWithBearerIfAble(Interceptor.Chain chain, Response response) throws IOException {
        if (isAuthTokenExpired(response.request().header(AuthHelper.getAuthHeaderKey()))) {
            this.mServiceLogger.debug("Http error {}. Auth challenge from {}, Retrying with customer {} token ", Integer.valueOf(response.code()), response.request().url(), this.mAuthProvider.getTokenType());
            return chain.proceed(buildRequestWithNewToken(response));
        }
        this.mServiceLogger.debug("Delaying sending request due to stale bearer token. Recieved {} from {}. Refreshing {} token ", Integer.valueOf(response.code()), response.request().url(), this.mAuthProvider.getTokenType());
        return response;
    }

    private Response sendWithRefreshIfAble(Interceptor.Chain chain, Response response) throws IOException {
        if (this.mAuthProvider.canRefresh()) {
            this.mServiceLogger.debug("Auth token rejected with code {} from {}, Refreshing {} token ", Integer.valueOf(response.code()), response.request().url(), this.mAuthProvider.getTokenType());
            this.mAuthProvider.refreshToken(new AuthResponseSummary(response));
            return chain.proceed(buildRequestWithNewToken(response));
        }
        this.mServiceLogger.warn("Failed sending request, cannot refresh token. Received {} from {}.", Integer.valueOf(response.code()), response.request().url(), this.mAuthProvider.getTokenType());
        return response;
    }

    /* access modifiers changed from: package-private */
    public Request buildRequestWithNewToken(Response response) {
        if (this.mAuthProvider.getTokenType() == null || this.mAuthProvider.getToken() == null) {
            return response.request();
        }
        return response.request().newBuilder().header(AuthHelper.getAuthHeaderKey(), AuthHelper.getAuthHeaderValue(this.mAuthProvider)).build();
    }

    private boolean isAuthTokenExpired(String str) {
        return str == null || !AuthHelper.getAuthHeaderValue(this.mAuthProvider).equals(str);
    }
}
