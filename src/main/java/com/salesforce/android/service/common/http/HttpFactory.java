package com.salesforce.android.service.common.http;

import com.salesforce.android.service.common.http.okhttp.SalesforceHttpUrl;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpClient;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpMediaType;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpMultipartBody;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpRequest;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpRequestBody;
import e.f;
import java.io.File;

public class HttpFactory {
    public static HttpClientBuilder client() {
        return SalesforceOkHttpClient.builder();
    }

    public static HttpRequestBuilder request() {
        return SalesforceOkHttpRequest.builder();
    }

    public static HttpRequestBody requestBody(HttpMediaType httpMediaType, String str) {
        return SalesforceOkHttpRequestBody.create(httpMediaType, str);
    }

    public static HttpRequestBody requestBody(HttpMediaType httpMediaType, f fVar) {
        return SalesforceOkHttpRequestBody.create(httpMediaType, fVar);
    }

    public static HttpRequestBody requestBody(HttpMediaType httpMediaType, byte[] bArr, int i, int i2) {
        return SalesforceOkHttpRequestBody.create(httpMediaType, bArr, i, i2);
    }

    public static HttpRequestBody requestBody(HttpMediaType httpMediaType, File file) {
        return SalesforceOkHttpRequestBody.create(httpMediaType, file);
    }

    public static HttpMultipartBodyBuilder multipartBody() {
        return new SalesforceOkHttpMultipartBody.Builder();
    }

    public static HttpUrlBuilder url() {
        return new SalesforceHttpUrl.Builder();
    }

    public static HttpMediaType mediaType(String str) {
        return SalesforceOkHttpMediaType.parse(str);
    }
}
