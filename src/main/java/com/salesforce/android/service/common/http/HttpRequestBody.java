package com.salesforce.android.service.common.http;

import java.io.IOException;
import okhttp3.RequestBody;

public interface HttpRequestBody {

    public interface OnProgressListener {
        void onProgress(long j, long j2);
    }

    long contentLength() throws IOException;

    HttpMediaType contentType();

    void setOnProgressListener(OnProgressListener onProgressListener);

    RequestBody toOkHttpRequestBody();
}
