package okhttp3;

import e.d;
import e.f;
import e.n;
import e.v;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.internal.Util;

public abstract class RequestBody {
    public long contentLength() throws IOException {
        return -1;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(d dVar) throws IOException;

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            charset = mediaType.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(final MediaType mediaType, final f fVar) {
        return new RequestBody() {
            public MediaType contentType() {
                return MediaType.this;
            }

            public long contentLength() throws IOException {
                return (long) fVar.h();
            }

            public void writeTo(d dVar) throws IOException {
                dVar.d(fVar);
            }
        };
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new RequestBody() {
                public MediaType contentType() {
                    return MediaType.this;
                }

                public long contentLength() {
                    return (long) i2;
                }

                public void writeTo(d dVar) throws IOException {
                    dVar.c(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                public MediaType contentType() {
                    return MediaType.this;
                }

                public long contentLength() {
                    return file.length();
                }

                public void writeTo(d dVar) throws IOException {
                    v vVar = null;
                    try {
                        vVar = n.a(file);
                        dVar.a(vVar);
                    } finally {
                        Util.closeQuietly((Closeable) vVar);
                    }
                }
            };
        }
        throw new NullPointerException("file == null");
    }
}
