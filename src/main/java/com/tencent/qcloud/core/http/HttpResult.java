package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudServiceException;
import java.util.List;
import java.util.Map;

public final class HttpResult<T> {
    private final int code;
    private final T content;
    private final Map<String, List<String>> headers;
    private final String message;
    private final HttpRequest<T> request;

    HttpResult(HttpResponse<T> httpResponse, T t) {
        this.code = httpResponse.code();
        this.message = httpResponse.message();
        this.headers = httpResponse.response.headers().toMultimap();
        this.content = t;
        this.request = httpResponse.request;
    }

    public T content() {
        return this.content;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public HttpRequest<T> request() {
        return this.request;
    }

    public Map<String, List<String>> headers() {
        return this.headers;
    }

    public final boolean isSuccessful() {
        int i = this.code;
        return i >= 200 && i < 300;
    }

    public QCloudServiceException asException() {
        QCloudServiceException qCloudServiceException = new QCloudServiceException(this.message);
        qCloudServiceException.setStatusCode(this.code);
        return qCloudServiceException;
    }

    public String header(String str) {
        List list = this.headers.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (String) list.get(0);
    }
}
