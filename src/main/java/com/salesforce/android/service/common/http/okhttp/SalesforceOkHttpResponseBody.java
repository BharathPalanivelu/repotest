package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpResponseBody;
import e.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

public class SalesforceOkHttpResponseBody implements HttpResponseBody {
    private final ResponseBody mResponseBody;

    public static HttpResponseBody wrap(ResponseBody responseBody) {
        return new SalesforceOkHttpResponseBody(responseBody);
    }

    SalesforceOkHttpResponseBody(ResponseBody responseBody) {
        this.mResponseBody = responseBody;
    }

    public byte[] bytes() throws IOException {
        return this.mResponseBody.bytes();
    }

    public MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    public InputStream byteStream() {
        return this.mResponseBody.byteStream();
    }

    public e source() {
        return this.mResponseBody.source();
    }

    public Reader charStream() {
        return this.mResponseBody.charStream();
    }

    public String string() throws IOException {
        return this.mResponseBody.string();
    }

    public void close() {
        this.mResponseBody.close();
    }
}
