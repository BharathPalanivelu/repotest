package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudProgressListener;
import e.c;
import e.h;
import e.u;
import java.io.IOException;

class CountingSink extends h {
    private long bytesTotal = 0;
    private long bytesWritten = 0;
    private QCloudProgressListener progressListener;
    private long recentReportBytes = 0;

    public CountingSink(u uVar, long j, QCloudProgressListener qCloudProgressListener) {
        super(uVar);
        this.bytesTotal = j;
        this.progressListener = qCloudProgressListener;
    }

    private void reportProgress() {
        if (this.progressListener != null) {
            long j = this.bytesTotal;
            if (j >= 0) {
                long j2 = this.bytesWritten;
                long j3 = j2 - this.recentReportBytes;
                if (j3 > 51200 || j3 * 10 > j || j2 == j) {
                    long j4 = this.bytesWritten;
                    this.recentReportBytes = j4;
                    this.progressListener.onProgress(j4, this.bytesTotal);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void writeBytesInternal(long j) {
        this.bytesWritten += j;
        reportProgress();
    }

    /* access modifiers changed from: package-private */
    public long getTotalTransferred() {
        return this.bytesWritten;
    }

    public void write(c cVar, long j) throws IOException {
        super.write(cVar, j);
        writeBytesInternal(j);
    }
}
