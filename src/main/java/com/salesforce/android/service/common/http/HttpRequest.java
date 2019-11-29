package com.salesforce.android.service.common.http;

import java.util.List;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;

public interface HttpRequest {
    HttpRequestBody body();

    CacheControl cacheControl();

    String header(String str);

    List<String> headers(String str);

    Headers headers();

    boolean isHttps();

    String method();

    HttpRequestBuilder newBuilder();

    Object tag();

    Request toOkHttpRequest();

    HttpUrl url();
}
