package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.HttpResponse;
import com.salesforce.android.service.common.http.HttpResponseBody;
import java.io.IOException;
import java.util.List;
import okhttp3.CacheControl;
import okhttp3.Challenge;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Response;

public class SalesforceOkHttpResponse implements HttpResponse {
    private final Response mResponse;

    public static HttpResponse wrap(Response response) {
        return new SalesforceOkHttpResponse(response);
    }

    SalesforceOkHttpResponse(Response response) {
        this.mResponse = response;
    }

    public HttpResponseBody body() {
        return SalesforceOkHttpResponseBody.wrap(this.mResponse.body());
    }

    public HttpRequest request() {
        return SalesforceOkHttpRequest.wrap(this.mResponse.request());
    }

    public Protocol protocol() {
        return this.mResponse.protocol();
    }

    public int code() {
        return this.mResponse.code();
    }

    public boolean isSuccessful() {
        return this.mResponse.isSuccessful();
    }

    public String message() {
        return this.mResponse.message();
    }

    public Handshake handshake() {
        return this.mResponse.handshake();
    }

    public List<String> headers(String str) {
        return this.mResponse.headers(str);
    }

    public String header(String str) {
        return this.mResponse.header(str);
    }

    public String header(String str, String str2) {
        return this.mResponse.header(str, str2);
    }

    public Headers headers() {
        return this.mResponse.headers();
    }

    public HttpResponseBody peekBody(long j) throws IOException {
        return SalesforceOkHttpResponseBody.wrap(this.mResponse.peekBody(j));
    }

    public boolean isRedirect() {
        return this.mResponse.isRedirect();
    }

    public HttpResponse networkResponse() {
        return wrap(this.mResponse.networkResponse());
    }

    public HttpResponse cacheResponse() {
        return wrap(this.mResponse.cacheResponse());
    }

    public HttpResponse priorResponse() {
        return wrap(this.mResponse.priorResponse());
    }

    public List<Challenge> challenges() {
        return this.mResponse.challenges();
    }

    public CacheControl cacheControl() {
        return this.mResponse.cacheControl();
    }

    public long sentRequestAtMillis() {
        return this.mResponse.sentRequestAtMillis();
    }

    public long receivedResponseAtMillis() {
        return this.mResponse.receivedResponseAtMillis();
    }

    public void close() {
        this.mResponse.close();
    }

    public String toString() {
        return this.mResponse.toString();
    }
}
