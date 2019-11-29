package com.tencent.qcloud.core.http;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.common.time.Clock;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.util.QCloudUtils;
import e.d;
import e.n;
import e.u;
import e.v;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;

public class StreamingRequestBody extends RequestBody implements ProgressBody {
    private byte[] bytes;
    private long contentRawLength = -1;
    private ContentResolver contentResolver;
    private String contentType;
    private CountingSink countingSink;
    private File file;
    private long offset = 0;
    private QCloudProgressListener progressListener;
    private long requiredLength = -1;
    private InputStream stream;
    private Uri uri;
    private URL url;

    public void setProgressListener(QCloudProgressListener qCloudProgressListener) {
        this.progressListener = qCloudProgressListener;
    }

    private StreamingRequestBody() {
    }

    public long getBytesTransferred() {
        CountingSink countingSink2 = this.countingSink;
        if (countingSink2 != null) {
            return countingSink2.getTotalTransferred();
        }
        return 0;
    }

    static StreamingRequestBody file(File file2, String str) {
        return file(file2, str, 0, Clock.MAX_TIME);
    }

    static StreamingRequestBody file(File file2, String str, long j, long j2) {
        StreamingRequestBody streamingRequestBody = new StreamingRequestBody();
        streamingRequestBody.file = file2;
        streamingRequestBody.contentType = str;
        long j3 = 0;
        if (j >= 0) {
            j3 = j;
        }
        streamingRequestBody.offset = j3;
        streamingRequestBody.requiredLength = j2;
        return streamingRequestBody;
    }

    static StreamingRequestBody bytes(byte[] bArr, String str, long j, long j2) {
        StreamingRequestBody streamingRequestBody = new StreamingRequestBody();
        streamingRequestBody.bytes = bArr;
        streamingRequestBody.contentType = str;
        long j3 = 0;
        if (j >= 0) {
            j3 = j;
        }
        streamingRequestBody.offset = j3;
        streamingRequestBody.requiredLength = j2;
        return streamingRequestBody;
    }

    static StreamingRequestBody steam(InputStream inputStream, File file2, String str, long j, long j2) {
        StreamingRequestBody streamingRequestBody = new StreamingRequestBody();
        streamingRequestBody.stream = inputStream;
        streamingRequestBody.contentType = str;
        streamingRequestBody.file = file2;
        long j3 = 0;
        if (j >= 0) {
            j3 = j;
        }
        streamingRequestBody.offset = j3;
        streamingRequestBody.requiredLength = j2;
        return streamingRequestBody;
    }

    static StreamingRequestBody url(URL url2, String str, long j, long j2) {
        StreamingRequestBody streamingRequestBody = new StreamingRequestBody();
        streamingRequestBody.url = url2;
        streamingRequestBody.contentType = str;
        long j3 = 0;
        if (j >= 0) {
            j3 = j;
        }
        streamingRequestBody.offset = j3;
        streamingRequestBody.requiredLength = j2;
        return streamingRequestBody;
    }

    static StreamingRequestBody uri(Uri uri2, ContentResolver contentResolver2, String str, long j, long j2) {
        StreamingRequestBody streamingRequestBody = new StreamingRequestBody();
        streamingRequestBody.uri = uri2;
        streamingRequestBody.contentResolver = contentResolver2;
        streamingRequestBody.contentType = str;
        long j3 = 0;
        if (j >= 0) {
            j3 = j;
        }
        streamingRequestBody.offset = j3;
        streamingRequestBody.requiredLength = j2;
        return streamingRequestBody;
    }

    /* access modifiers changed from: package-private */
    public boolean isLargeData() {
        return (this.file == null && this.stream == null) ? false : true;
    }

    public MediaType contentType() {
        String str = this.contentType;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public long contentLength() throws IOException {
        long contentRawLength2 = getContentRawLength();
        if (contentRawLength2 <= 0) {
            return Math.max(this.requiredLength, -1);
        }
        long j = this.requiredLength;
        if (j <= 0) {
            return Math.max(contentRawLength2 - this.offset, -1);
        }
        return Math.min(contentRawLength2 - this.offset, j);
    }

    private long getContentRawLength() throws IOException {
        if (this.contentRawLength < 0) {
            InputStream inputStream = this.stream;
            if (inputStream != null) {
                this.contentRawLength = (long) inputStream.available();
            } else {
                File file2 = this.file;
                if (file2 != null) {
                    this.contentRawLength = file2.length();
                } else {
                    byte[] bArr = this.bytes;
                    if (bArr != null) {
                        this.contentRawLength = (long) bArr.length;
                    } else {
                        Uri uri2 = this.uri;
                        if (uri2 != null) {
                            this.contentRawLength = QCloudUtils.getUriContentLength(uri2, this.contentResolver);
                        }
                    }
                }
            }
        }
        return this.contentRawLength;
    }

    /* JADX INFO: finally extract failed */
    private InputStream getStream() throws IOException {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            return new ByteArrayInputStream(bArr);
        }
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                saveInputStreamToTmpFile(inputStream, this.file);
                Util.closeQuietly((Closeable) this.stream);
                this.stream = null;
                this.offset = 0;
                return new FileInputStream(this.file);
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) this.stream);
                this.stream = null;
                this.offset = 0;
                throw th;
            }
        } else {
            File file2 = this.file;
            if (file2 != null) {
                return new FileInputStream(file2);
            }
            URL url2 = this.url;
            if (url2 != null) {
                return FirebasePerfUrlConnection.openStream(url2);
            }
            Uri uri2 = this.uri;
            if (uri2 != null) {
                return this.contentResolver.openInputStream(uri2);
            }
            return null;
        }
    }

    private void saveInputStreamToTmpFile(InputStream inputStream, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                byte[] bArr = new byte[8192];
                long contentLength = contentLength();
                long j = 0;
                if (contentLength < 0) {
                    contentLength = Clock.MAX_TIME;
                }
                if (this.offset > 0) {
                    inputStream.skip(this.offset);
                }
                while (j < contentLength) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    long j2 = (long) read;
                    fileOutputStream.write(bArr, 0, (int) Math.min(j2, contentLength - j));
                    j += j2;
                }
                fileOutputStream.flush();
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

    public void writeTo(d dVar) throws IOException {
        InputStream inputStream;
        v vVar = null;
        try {
            inputStream = getStream();
            if (inputStream != null) {
                try {
                    if (this.offset > 0) {
                        inputStream.skip(this.offset);
                    }
                    vVar = n.a(inputStream);
                    long contentLength = contentLength();
                    this.countingSink = new CountingSink(dVar, contentLength, this.progressListener);
                    d a2 = n.a((u) this.countingSink);
                    if (contentLength > 0) {
                        a2.a(vVar, contentLength);
                    } else {
                        a2.a(vVar);
                    }
                    a2.flush();
                } catch (Throwable th) {
                    th = th;
                    Util.closeQuietly((Closeable) inputStream);
                    Util.closeQuietly((Closeable) null);
                    Util.closeQuietly((Closeable) this.countingSink);
                    throw th;
                }
            }
            Util.closeQuietly((Closeable) inputStream);
            Util.closeQuietly((Closeable) vVar);
            Util.closeQuietly((Closeable) this.countingSink);
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            Util.closeQuietly((Closeable) inputStream);
            Util.closeQuietly((Closeable) null);
            Util.closeQuietly((Closeable) this.countingSink);
            throw th;
        }
    }
}
