package com.salesforce.android.chat.core.internal.filetransfer;

import com.salesforce.android.service.common.http.HttpRequestBody;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.validation.Arguments;

class FileTransferProgressMonitor implements HttpRequestBody.OnProgressListener {
    private final BasicAsync<Float> mFileTransferAsync;

    private FileTransferProgressMonitor(Builder builder) {
        this.mFileTransferAsync = builder.mFileTransferAsync;
        builder.mRequestBody.setOnProgressListener(this);
    }

    public void onProgress(long j, long j2) {
        this.mFileTransferAsync.setResult(Float.valueOf(((float) j) / ((float) j2)));
    }

    static class Factory {
        Factory() {
        }

        /* access modifiers changed from: package-private */
        public Builder createBuilder() {
            return new Builder();
        }
    }

    static class Builder {
        /* access modifiers changed from: private */
        public BasicAsync<Float> mFileTransferAsync;
        /* access modifiers changed from: private */
        public HttpRequestBody mRequestBody;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder fileTransferAsync(BasicAsync<Float> basicAsync) {
            this.mFileTransferAsync = basicAsync;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder requestBody(HttpRequestBody httpRequestBody) {
            this.mRequestBody = httpRequestBody;
            return this;
        }

        public FileTransferProgressMonitor build() {
            Arguments.checkNotNull(this.mFileTransferAsync);
            Arguments.checkNotNull(this.mRequestBody);
            return new FileTransferProgressMonitor(this);
        }
    }
}
