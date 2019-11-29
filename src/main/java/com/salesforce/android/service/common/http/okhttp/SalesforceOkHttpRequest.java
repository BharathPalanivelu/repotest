package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.HttpRequestBody;
import com.salesforce.android.service.common.http.HttpRequestBuilder;
import com.salesforce.android.service.common.http.HttpUrl;
import java.net.URL;
import java.util.List;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

public class SalesforceOkHttpRequest implements HttpRequest {
    protected Request mRequest;

    public static HttpRequestBuilder builder() {
        return new Builder();
    }

    public static HttpRequest wrap(Request request) {
        return new SalesforceOkHttpRequest(request);
    }

    SalesforceOkHttpRequest(Request request) {
        this.mRequest = request;
    }

    SalesforceOkHttpRequest(Builder builder) {
        this.mRequest = builder.mRequestBuilder.build();
    }

    public HttpRequestBody body() {
        return SalesforceOkHttpRequestBody.wrap(this.mRequest.body());
    }

    public HttpUrl url() {
        return SalesforceHttpUrl.wrap(this.mRequest.url());
    }

    public String method() {
        return this.mRequest.method();
    }

    public Headers headers() {
        return this.mRequest.headers();
    }

    public String header(String str) {
        return this.mRequest.header(str);
    }

    public List<String> headers(String str) {
        return this.mRequest.headers(str);
    }

    public Object tag() {
        return this.mRequest.tag();
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public CacheControl cacheControl() {
        return this.mRequest.cacheControl();
    }

    public boolean isHttps() {
        return this.mRequest.isHttps();
    }

    public Request toOkHttpRequest() {
        return this.mRequest;
    }

    public String toString() {
        return this.mRequest.toString();
    }

    public static class Builder implements HttpRequestBuilder {
        protected final Request.Builder mRequestBuilder;

        public Builder() {
            this.mRequestBuilder = new Request.Builder();
        }

        protected Builder(SalesforceOkHttpRequest salesforceOkHttpRequest) {
            this.mRequestBuilder = salesforceOkHttpRequest.mRequest.newBuilder();
        }

        public HttpRequestBuilder addHeader(String str, String str2) {
            this.mRequestBuilder.addHeader(str, str2);
            return this;
        }

        public HttpRequestBuilder url(HttpUrl httpUrl) {
            this.mRequestBuilder.url(httpUrl.toOkHttpUrl());
            return this;
        }

        public HttpRequestBuilder url(okhttp3.HttpUrl httpUrl) {
            this.mRequestBuilder.url(httpUrl);
            return this;
        }

        public HttpRequestBuilder url(String str) {
            this.mRequestBuilder.url(str);
            return this;
        }

        public HttpRequestBuilder url(URL url) {
            this.mRequestBuilder.url(url);
            return this;
        }

        public HttpRequestBuilder header(String str, String str2) {
            this.mRequestBuilder.header(str, str2);
            return this;
        }

        public HttpRequestBuilder removeHeader(String str) {
            this.mRequestBuilder.removeHeader(str);
            return this;
        }

        public HttpRequestBuilder headers(Headers headers) {
            this.mRequestBuilder.headers(headers);
            return this;
        }

        public HttpRequestBuilder cacheControl(CacheControl cacheControl) {
            this.mRequestBuilder.cacheControl(cacheControl);
            return this;
        }

        public HttpRequestBuilder get() {
            this.mRequestBuilder.get();
            return this;
        }

        public HttpRequestBuilder head() {
            this.mRequestBuilder.head();
            return this;
        }

        public HttpRequestBuilder post(RequestBody requestBody) {
            this.mRequestBuilder.post(requestBody);
            return this;
        }

        public HttpRequestBuilder post(HttpRequestBody httpRequestBody) {
            this.mRequestBuilder.post(httpRequestBody.toOkHttpRequestBody());
            return this;
        }

        public HttpRequestBuilder delete(RequestBody requestBody) {
            this.mRequestBuilder.delete(requestBody);
            return this;
        }

        public HttpRequestBuilder delete(HttpRequestBody httpRequestBody) {
            this.mRequestBuilder.delete(httpRequestBody.toOkHttpRequestBody());
            return this;
        }

        public HttpRequestBuilder delete() {
            this.mRequestBuilder.delete();
            return this;
        }

        public HttpRequestBuilder put(RequestBody requestBody) {
            this.mRequestBuilder.put(requestBody);
            return this;
        }

        public HttpRequestBuilder put(HttpRequestBody httpRequestBody) {
            this.mRequestBuilder.put(httpRequestBody.toOkHttpRequestBody());
            return this;
        }

        public HttpRequestBuilder patch(RequestBody requestBody) {
            this.mRequestBuilder.patch(requestBody);
            return this;
        }

        public HttpRequestBuilder patch(HttpRequestBody httpRequestBody) {
            this.mRequestBuilder.patch(httpRequestBody.toOkHttpRequestBody());
            return this;
        }

        public HttpRequestBuilder method(String str, RequestBody requestBody) {
            this.mRequestBuilder.method(str, requestBody);
            return this;
        }

        public HttpRequestBuilder method(String str, HttpRequestBody httpRequestBody) {
            this.mRequestBuilder.method(str, httpRequestBody.toOkHttpRequestBody());
            return this;
        }

        public HttpRequestBuilder tag(Object obj) {
            this.mRequestBuilder.tag(obj);
            return this;
        }

        public HttpRequest build() {
            return new SalesforceOkHttpRequest(this);
        }
    }
}
