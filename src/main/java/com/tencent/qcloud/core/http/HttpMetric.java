package com.tencent.qcloud.core.http;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpMetric {
    public static final String ATTR_EXCEPTION = "exception";
    public static final String ATTR_HTTP_TOOK_TIME = "http_took_time";
    public static final String ATTR_REQUEST_CONTENT_LENGTH = "request_content_length";
    public static final String ATTR_REQUEST_CONTENT_TYPE = "request_content_type";
    public static final String ATTR_REQUEST_METHOD = "request_method";
    public static final String ATTR_REQUEST_URL = "request_url";
    public static final String ATTR_RESPONSE_CONTENT_LENGTH = "response_content_type";
    public static final String ATTR_RESPONSE_CONTENT_TYPE = "response_content_length";
    public static final String ATTR_RESPONSE_STATUS_CODE = "response_status_code";
    private Throwable exception;
    private Map<String, String> mAttributes = new HashMap(16);
    private long mStartNs;
    private long mTookTime;
    private String requestMethod;
    private String requestUrl;
    private int statusCode;

    public String getAttribute(String str) {
        return this.mAttributes.get(str);
    }

    public Map<String, String> getAttributes() {
        return this.mAttributes;
    }

    public void putAttribute(String str, String str2) {
        this.mAttributes.put(str, str2);
    }

    public void removeAttribute(String str) {
        this.mAttributes.remove(str);
    }

    public void setRequestUrl(String str) {
        this.requestUrl = str;
        this.mAttributes.put(ATTR_REQUEST_URL, str);
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public void setRequestMethod(String str) {
        this.requestMethod = str;
        this.mAttributes.put(ATTR_REQUEST_METHOD, str);
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
        this.mAttributes.put(ATTR_RESPONSE_STATUS_CODE, String.valueOf(this.statusCode));
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setRequestPayloadSize(long j) {
        this.mAttributes.put(ATTR_REQUEST_CONTENT_LENGTH, String.valueOf(j));
    }

    public void setRequestContentType(String str) {
        this.mAttributes.put(ATTR_REQUEST_CONTENT_TYPE, str);
    }

    public void setResponseContentType(String str) {
        this.mAttributes.put(ATTR_RESPONSE_CONTENT_TYPE, str);
    }

    public void setResponsePayloadSize(long j) {
        this.mAttributes.put(ATTR_RESPONSE_CONTENT_LENGTH, String.valueOf(j));
    }

    public void traceException(Throwable th) {
        this.exception = th;
        this.mAttributes.put(ATTR_EXCEPTION, th.toString());
    }

    public Throwable getError() {
        return this.exception;
    }

    public void start() {
        this.mStartNs = System.nanoTime();
    }

    public void stop() {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.mStartNs);
        Map<String, String> map = this.mAttributes;
        map.put(ATTR_HTTP_TOOK_TIME, String.valueOf(millis) + "ms");
        this.mTookTime = millis;
    }

    public boolean isStoped() {
        return this.mAttributes.containsKey(ATTR_HTTP_TOOK_TIME);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(this.requestMethod);
        sb.append(' ');
        sb.append(this.requestUrl);
        sb.append("  (");
        sb.append(this.mTookTime);
        sb.append("ms)\n<-- ");
        sb.append(this.statusCode);
        sb.append(" Attributes = ");
        sb.append(this.mAttributes.toString());
        if (this.exception == null) {
            str = "";
        } else {
            str = "\n<-- Exception: " + Log.getStackTraceString(this.exception);
        }
        sb.append(str);
        return sb.toString();
    }
}
