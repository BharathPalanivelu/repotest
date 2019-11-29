package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.util.QCloudHttpUtils;
import e.c;
import e.d;
import e.n;
import e.u;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;

public class ResponseFileConverter<T> extends ResponseBodyConverter<T> implements ProgressBody {
    private CountingSink countingSink;
    private String filePath;
    private long offset;
    private QCloudProgressListener progressListener;

    public ResponseFileConverter(String str, long j) {
        this.filePath = str;
        this.offset = j;
    }

    public void setProgressListener(QCloudProgressListener qCloudProgressListener) {
        this.progressListener = qCloudProgressListener;
    }

    public T convert(HttpResponse<T> httpResponse) throws QCloudClientException, QCloudServiceException {
        long j;
        d dVar;
        HttpResponse.checkResponseSuccessful(httpResponse);
        long[] parseContentRange = QCloudHttpUtils.parseContentRange(httpResponse.header(HttpConstants.Header.CONTENT_RANGE));
        if (parseContentRange != null) {
            j = (parseContentRange[1] - parseContentRange[0]) + 1;
        } else {
            j = httpResponse.contentLength();
        }
        File file = new File(this.filePath);
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            d dVar2 = null;
            try {
                if (this.offset <= 0) {
                    this.countingSink = new CountingSink(n.b(file), j, this.progressListener);
                    dVar = n.a((u) this.countingSink);
                    try {
                        dVar.a(httpResponse.response.body().source(), j);
                        dVar.flush();
                    } catch (IOException e2) {
                        e = e2;
                        dVar2 = dVar;
                    } catch (Throwable th) {
                        th = th;
                        dVar2 = dVar;
                        Util.closeQuietly((Closeable) dVar2);
                        throw th;
                    }
                } else {
                    writeRandomAccessFile(file, httpResponse.byteStream(), j);
                    dVar = null;
                }
                Util.closeQuietly((Closeable) dVar);
                return null;
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new QCloudClientException("write local file error for " + e.toString(), e);
                } catch (Throwable th2) {
                    th = th2;
                    Util.closeQuietly((Closeable) dVar2);
                    throw th;
                }
            }
        } else {
            throw new QCloudClientException("local file directory can not create.");
        }
    }

    private void writeRandomAccessFile(File file, InputStream inputStream, long j) throws IOException, QCloudClientException {
        RandomAccessFile randomAccessFile;
        if (inputStream != null) {
            try {
                randomAccessFile = new RandomAccessFile(file, "rws");
                try {
                    randomAccessFile.seek(this.offset);
                    byte[] bArr = new byte[8192];
                    this.countingSink = new CountingSink(new c(), j, this.progressListener);
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            randomAccessFile.write(bArr, 0, read);
                            this.countingSink.writeBytesInternal((long) read);
                        } else {
                            Util.closeQuietly((Closeable) inputStream);
                            Util.closeQuietly((Closeable) randomAccessFile);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    Util.closeQuietly((Closeable) inputStream);
                    Util.closeQuietly((Closeable) randomAccessFile);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                Util.closeQuietly((Closeable) inputStream);
                Util.closeQuietly((Closeable) randomAccessFile);
                throw th;
            }
        } else {
            throw new QCloudClientException("response body stream is null");
        }
    }

    public long getBytesTransferred() {
        CountingSink countingSink2 = this.countingSink;
        if (countingSink2 != null) {
            return countingSink2.getTotalTransferred();
        }
        return 0;
    }
}
