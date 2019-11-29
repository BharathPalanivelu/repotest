package com.tencent.cos.xml.transfer;

import com.facebook.common.time.Clock;
import com.facebook.common.util.UriUtil;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.ProgressBody;
import e.d;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.internal.Util;

public class MultipartRequestBody extends RequestBody implements ProgressBody {
    /* access modifiers changed from: private */
    public byte[] bytes;
    private long contentLength = -1;
    /* access modifiers changed from: private */
    public String contentType;
    /* access modifiers changed from: private */
    public File file;
    private String fileName;
    private MultipartBody multipartBody;
    private String name = UriUtil.LOCAL_FILE_SCHEME;
    /* access modifiers changed from: private */
    public long offset = -1;
    private Map<String, String> parameters = new LinkedHashMap();
    /* access modifiers changed from: private */
    public QCloudProgressListener progressListener;

    public long getBytesTransferred() {
        return 0;
    }

    public void build() {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MediaType.parse(HttpConstants.ContentType.MULTIPART_FORM_DATA));
        for (Map.Entry next : this.parameters.entrySet()) {
            builder.addFormDataPart((String) next.getKey(), (String) next.getValue());
        }
        builder.addFormDataPart(this.name, this.fileName, new InnerRequestBody());
        this.multipartBody = builder.build();
    }

    public void setParameters(Map<String, String> map) {
        if (map != null) {
            this.parameters.putAll(map);
        }
    }

    public void setContent(String str, String str2, String str3, byte[] bArr, long j, long j2) {
        this.contentType = str;
        if (str2 != null) {
            this.name = str2;
        }
        this.fileName = str3;
        this.bytes = bArr;
        setOffset(j, j2);
    }

    public void setContent(String str, String str2, String str3, File file2, long j, long j2) {
        this.contentType = str;
        if (str2 != null) {
            this.name = str2;
        }
        this.fileName = str3;
        this.file = file2;
        setOffset(j, j2);
    }

    public void setContent(String str, String str2, String str3, File file2, InputStream inputStream, long j, long j2) throws IOException {
        this.contentType = str;
        if (str2 != null) {
            this.name = str2;
        }
        this.fileName = str3;
        setOffset(j, j2);
        saveStreamToTmpFile(inputStream, file2);
        this.file = file2;
        this.offset = -1;
        this.contentLength = -1;
    }

    private void setOffset(long j, long j2) {
        this.offset = j;
        this.contentLength = j2;
    }

    public void setProgressListener(QCloudProgressListener qCloudProgressListener) {
        this.progressListener = qCloudProgressListener;
    }

    private void saveStreamToTmpFile(InputStream inputStream, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                byte[] bArr = new byte[8192];
                long j = 0;
                long j2 = this.contentLength < 0 ? Clock.MAX_TIME : this.contentLength;
                if (this.offset <= 0 || inputStream.skip(this.offset) == this.offset) {
                    while (j < j2) {
                        int read = inputStream.read(bArr, 0, (int) Math.min((long) bArr.length, j2 - j));
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        j += (long) read;
                    }
                    fileOutputStream.flush();
                    Util.closeQuietly((Closeable) fileOutputStream);
                    return;
                }
                Util.closeQuietly((Closeable) fileOutputStream);
            } catch (Throwable th) {
                th = th;
                Util.closeQuietly((Closeable) fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            Util.closeQuietly((Closeable) fileOutputStream);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public long getContentRawLength() throws IOException {
        long j;
        File file2 = this.file;
        if (file2 != null) {
            j = file2.length();
        } else {
            byte[] bArr = this.bytes;
            j = bArr != null ? (long) bArr.length : 0;
        }
        if (this.offset < 0) {
            this.offset = 0;
        }
        if (this.contentLength < 0) {
            this.contentLength = j;
        }
        long j2 = this.offset;
        long j3 = this.contentLength;
        return j > j2 + j3 ? j3 : j - j2;
    }

    public MediaType contentType() {
        return this.multipartBody.contentType();
    }

    public long contentLength() throws IOException {
        return this.multipartBody.contentLength();
    }

    public void writeTo(d dVar) throws IOException {
        this.multipartBody.writeTo(dVar);
    }

    private class InnerRequestBody extends RequestBody {
        private InnerRequestBody() {
        }

        public MediaType contentType() {
            if (MultipartRequestBody.this.contentType != null) {
                return MediaType.parse(MultipartRequestBody.this.contentType);
            }
            return null;
        }

        public long contentLength() throws IOException {
            return MultipartRequestBody.this.getContentRawLength();
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0050 A[SYNTHETIC, Splitter:B:17:0x0050] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeTo(e.d r10) throws java.io.IOException {
            /*
                r9 = this;
                r0 = 0
                com.tencent.cos.xml.transfer.MultipartRequestBody r1 = com.tencent.cos.xml.transfer.MultipartRequestBody.this     // Catch:{ all -> 0x0074 }
                java.io.File r1 = r1.file     // Catch:{ all -> 0x0074 }
                if (r1 == 0) goto L_0x0016
                java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0074 }
                com.tencent.cos.xml.transfer.MultipartRequestBody r2 = com.tencent.cos.xml.transfer.MultipartRequestBody.this     // Catch:{ all -> 0x0074 }
                java.io.File r2 = r2.file     // Catch:{ all -> 0x0074 }
                r1.<init>(r2)     // Catch:{ all -> 0x0074 }
            L_0x0014:
                r0 = r1
                goto L_0x002a
            L_0x0016:
                com.tencent.cos.xml.transfer.MultipartRequestBody r1 = com.tencent.cos.xml.transfer.MultipartRequestBody.this     // Catch:{ all -> 0x0074 }
                byte[] r1 = r1.bytes     // Catch:{ all -> 0x0074 }
                if (r1 == 0) goto L_0x002a
                java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0074 }
                com.tencent.cos.xml.transfer.MultipartRequestBody r2 = com.tencent.cos.xml.transfer.MultipartRequestBody.this     // Catch:{ all -> 0x0074 }
                byte[] r2 = r2.bytes     // Catch:{ all -> 0x0074 }
                r1.<init>(r2)     // Catch:{ all -> 0x0074 }
                goto L_0x0014
            L_0x002a:
                com.tencent.cos.xml.transfer.MultipartRequestBody r1 = com.tencent.cos.xml.transfer.MultipartRequestBody.this     // Catch:{ all -> 0x0074 }
                long r1 = r1.offset     // Catch:{ all -> 0x0074 }
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 <= 0) goto L_0x004e
                com.tencent.cos.xml.transfer.MultipartRequestBody r1 = com.tencent.cos.xml.transfer.MultipartRequestBody.this     // Catch:{ all -> 0x0074 }
                long r1 = r1.offset     // Catch:{ all -> 0x0074 }
                long r1 = r0.skip(r1)     // Catch:{ all -> 0x0074 }
                com.tencent.cos.xml.transfer.MultipartRequestBody r5 = com.tencent.cos.xml.transfer.MultipartRequestBody.this     // Catch:{ all -> 0x0074 }
                long r5 = r5.offset     // Catch:{ all -> 0x0074 }
                int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r7 == 0) goto L_0x004e
                okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                return
            L_0x004e:
                if (r0 == 0) goto L_0x0070
                long r1 = r9.contentLength()     // Catch:{ all -> 0x0074 }
                r5 = 2048(0x800, float:2.87E-42)
                byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0074 }
            L_0x0058:
                int r6 = r5.length     // Catch:{ all -> 0x0074 }
                r7 = 0
                int r6 = r0.read(r5, r7, r6)     // Catch:{ all -> 0x0074 }
                r8 = -1
                if (r6 == r8) goto L_0x0070
                r10.c(r5, r7, r6)     // Catch:{ all -> 0x0074 }
                long r6 = (long) r6     // Catch:{ all -> 0x0074 }
                long r3 = r3 + r6
                com.tencent.cos.xml.transfer.MultipartRequestBody r6 = com.tencent.cos.xml.transfer.MultipartRequestBody.this     // Catch:{ all -> 0x0074 }
                com.tencent.qcloud.core.common.QCloudProgressListener r6 = r6.progressListener     // Catch:{ all -> 0x0074 }
                r6.onProgress(r3, r1)     // Catch:{ all -> 0x0074 }
                goto L_0x0058
            L_0x0070:
                okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                return
            L_0x0074:
                r10 = move-exception
                okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                goto L_0x007a
            L_0x0079:
                throw r10
            L_0x007a:
                goto L_0x0079
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.transfer.MultipartRequestBody.InnerRequestBody.writeTo(e.d):void");
        }
    }
}
