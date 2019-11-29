package com.salesforce.android.service.common.http;

import java.util.List;
import java.util.Map;

public class HttpResponseParseResult<T> {
    private T mBody;
    private Map<String, List<String>> mResponseHeaders;
    private int mStatusCode;

    public HttpResponseParseResult(Map<String, List<String>> map, int i, T t) {
        this.mResponseHeaders = map;
        this.mStatusCode = i;
        this.mBody = t;
    }

    public String getResponseHeaderValue(String str) {
        if (!this.mResponseHeaders.containsKey(str)) {
            return null;
        }
        List list = this.mResponseHeaders.get(str);
        if (!list.isEmpty()) {
            return (String) list.get(0);
        }
        return null;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public T getBody() {
        return this.mBody;
    }
}
