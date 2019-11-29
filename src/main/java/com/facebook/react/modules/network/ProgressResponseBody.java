package com.facebook.react.modules.network;

import e.c;
import e.e;
import e.i;
import e.n;
import e.v;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

public class ProgressResponseBody extends ResponseBody {
    private e mBufferedSource;
    /* access modifiers changed from: private */
    public final ProgressListener mProgressListener;
    /* access modifiers changed from: private */
    public final ResponseBody mResponseBody;
    /* access modifiers changed from: private */
    public long mTotalBytesRead = 0;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        this.mResponseBody = responseBody;
        this.mProgressListener = progressListener;
    }

    public MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    public long totalBytesRead() {
        return this.mTotalBytesRead;
    }

    public e source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = n.a(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }

    private v source(v vVar) {
        return new i(vVar) {
            public long read(c cVar, long j) throws IOException {
                long read = super.read(cVar, j);
                ProgressResponseBody progressResponseBody = ProgressResponseBody.this;
                long unused = progressResponseBody.mTotalBytesRead = progressResponseBody.mTotalBytesRead + (read != -1 ? read : 0);
                ProgressResponseBody.this.mProgressListener.onProgress(ProgressResponseBody.this.mTotalBytesRead, ProgressResponseBody.this.mResponseBody.contentLength(), read == -1);
                return read;
            }
        };
    }
}
