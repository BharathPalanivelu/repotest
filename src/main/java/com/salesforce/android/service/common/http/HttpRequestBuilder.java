package com.salesforce.android.service.common.http;

import java.net.URL;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;

public interface HttpRequestBuilder {
    HttpRequestBuilder addHeader(String str, String str2);

    HttpRequest build();

    HttpRequestBuilder cacheControl(CacheControl cacheControl);

    HttpRequestBuilder delete();

    HttpRequestBuilder delete(HttpRequestBody httpRequestBody);

    HttpRequestBuilder delete(RequestBody requestBody);

    HttpRequestBuilder get();

    HttpRequestBuilder head();

    HttpRequestBuilder header(String str, String str2);

    HttpRequestBuilder headers(Headers headers);

    HttpRequestBuilder method(String str, HttpRequestBody httpRequestBody);

    HttpRequestBuilder method(String str, RequestBody requestBody);

    HttpRequestBuilder patch(HttpRequestBody httpRequestBody);

    HttpRequestBuilder patch(RequestBody requestBody);

    HttpRequestBuilder post(HttpRequestBody httpRequestBody);

    HttpRequestBuilder post(RequestBody requestBody);

    HttpRequestBuilder put(HttpRequestBody httpRequestBody);

    HttpRequestBuilder put(RequestBody requestBody);

    HttpRequestBuilder removeHeader(String str);

    HttpRequestBuilder tag(Object obj);

    HttpRequestBuilder url(HttpUrl httpUrl);

    HttpRequestBuilder url(String str);

    HttpRequestBuilder url(URL url);

    HttpRequestBuilder url(HttpUrl httpUrl);
}
