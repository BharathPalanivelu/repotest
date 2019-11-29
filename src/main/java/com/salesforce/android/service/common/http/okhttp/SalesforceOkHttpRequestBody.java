package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpMediaType;
import com.salesforce.android.service.common.http.HttpRequestBody;
import com.salesforce.android.service.common.http.okhttp.ProgressObservingSink;
import e.f;
import java.io.File;
import java.io.IOException;
import okhttp3.RequestBody;

public class SalesforceOkHttpRequestBody implements HttpRequestBody, ProgressObservingSink.Listener {
    private long mNumberOfBytesWritten;
    private HttpRequestBody.OnProgressListener mOnProgressListener;
    private final RequestBody mRequestBody;

    public static SalesforceOkHttpRequestBody wrap(RequestBody requestBody) {
        return new SalesforceOkHttpRequestBody(requestBody);
    }

    public static SalesforceOkHttpRequestBody create(HttpMediaType httpMediaType, String str) {
        return wrap(ObservableRequestBody.wrap(RequestBody.create(httpMediaType.toOkHttpMediaType(), str)));
    }

    public static SalesforceOkHttpRequestBody create(HttpMediaType httpMediaType, f fVar) {
        return wrap(ObservableRequestBody.wrap(RequestBody.create(httpMediaType.toOkHttpMediaType(), fVar)));
    }

    public static SalesforceOkHttpRequestBody create(HttpMediaType httpMediaType, byte[] bArr) {
        return wrap(ObservableRequestBody.wrap(RequestBody.create(httpMediaType.toOkHttpMediaType(), bArr)));
    }

    public static SalesforceOkHttpRequestBody create(HttpMediaType httpMediaType, byte[] bArr, int i, int i2) {
        return wrap(ObservableRequestBody.wrap(RequestBody.create(httpMediaType.toOkHttpMediaType(), bArr, i, i2)));
    }

    public static SalesforceOkHttpRequestBody create(HttpMediaType httpMediaType, File file) {
        return wrap(ObservableRequestBody.wrap(RequestBody.create(httpMediaType.toOkHttpMediaType(), file)));
    }

    private SalesforceOkHttpRequestBody(RequestBody requestBody) {
        this.mRequestBody = requestBody;
    }

    public void setOnProgressListener(HttpRequestBody.OnProgressListener onProgressListener) {
        this.mOnProgressListener = onProgressListener;
        RequestBody requestBody = this.mRequestBody;
        if (requestBody instanceof ObservableRequestBody) {
            ((ObservableRequestBody) requestBody).setListener(this);
        }
    }

    public HttpMediaType contentType() {
        return SalesforceOkHttpMediaType.wrap(this.mRequestBody.contentType());
    }

    public long contentLength() throws IOException {
        return this.mRequestBody.contentLength();
    }

    public RequestBody toOkHttpRequestBody() {
        return this.mRequestBody;
    }

    public void onBytesWritten(long j) throws IOException {
        this.mNumberOfBytesWritten += j;
        HttpRequestBody.OnProgressListener onProgressListener = this.mOnProgressListener;
        if (onProgressListener != null) {
            onProgressListener.onProgress(this.mNumberOfBytesWritten, contentLength());
        }
    }
}
