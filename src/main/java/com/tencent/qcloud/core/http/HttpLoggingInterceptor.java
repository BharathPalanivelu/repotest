package com.tencent.qcloud.core.http;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.ijk.media.player.IjkMediaMeta;
import e.c;
import java.io.EOFException;
import java.nio.charset.Charset;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;

final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            public void log(String str) {
                Platform.get().log(4, str, (Throwable) null);
            }
        };

        void log(String str);
    }

    private boolean isContentLengthTooLarge(long j) {
        return j > IjkMediaMeta.AV_CH_TOP_CENTER;
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        this.level = Level.NONE;
        this.logger = logger2;
    }

    public HttpLoggingInterceptor setLevel(Level level2) {
        if (level2 != null) {
            this.level = level2;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public Level getLevel() {
        return this.level;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:101|102|103) */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r1.logger.log("");
        r1.logger.log("Couldn't decode the response body; charset is likely malformed.");
        r1.logger.log("<-- END HTTP");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0332, code lost:
        return r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x0321 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r24) throws java.io.IOException {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Level r2 = r1.level
            okhttp3.Request r3 = r24.request()
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Level r4 = com.tencent.qcloud.core.http.HttpLoggingInterceptor.Level.NONE
            if (r2 != r4) goto L_0x0013
            okhttp3.Response r0 = r0.proceed(r3)
            return r0
        L_0x0013:
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Level r4 = com.tencent.qcloud.core.http.HttpLoggingInterceptor.Level.BODY
            if (r2 != r4) goto L_0x0019
            r4 = 1
            goto L_0x001a
        L_0x0019:
            r4 = 0
        L_0x001a:
            if (r4 != 0) goto L_0x0023
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Level r7 = com.tencent.qcloud.core.http.HttpLoggingInterceptor.Level.HEADERS
            if (r2 != r7) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r2 = 0
            goto L_0x0024
        L_0x0023:
            r2 = 1
        L_0x0024:
            okhttp3.RequestBody r7 = r3.body()
            if (r7 == 0) goto L_0x002c
            r8 = 1
            goto L_0x002d
        L_0x002c:
            r8 = 0
        L_0x002d:
            okhttp3.Connection r9 = r24.connection()
            if (r9 == 0) goto L_0x0038
            okhttp3.Protocol r9 = r9.protocol()
            goto L_0x003a
        L_0x0038:
            okhttp3.Protocol r9 = okhttp3.Protocol.HTTP_1_1
        L_0x003a:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "--> "
            r10.append(r11)
            java.lang.String r11 = r3.method()
            r10.append(r11)
            r11 = 32
            r10.append(r11)
            okhttp3.HttpUrl r12 = r3.url()
            r10.append(r12)
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.lang.String r10 = "-byte body)"
            java.lang.String r12 = " ("
            if (r2 != 0) goto L_0x0082
            if (r8 == 0) goto L_0x0082
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r9)
            r13.append(r12)
            long r14 = r7.contentLength()
            r13.append(r14)
            r13.append(r10)
            java.lang.String r9 = r13.toString()
        L_0x0082:
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r13 = r1.logger
            r13.log(r9)
            java.lang.String r9 = "-byte body omitted)"
            java.lang.String r13 = ": "
            java.lang.String r5 = ""
            if (r2 == 0) goto L_0x0204
            if (r8 == 0) goto L_0x00d5
            okhttp3.MediaType r17 = r7.contentType()
            if (r17 == 0) goto L_0x00b1
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r14 = "Content-Type: "
            r11.append(r14)
            okhttp3.MediaType r14 = r7.contentType()
            r11.append(r14)
            java.lang.String r11 = r11.toString()
            r6.log(r11)
        L_0x00b1:
            long r14 = r7.contentLength()
            r19 = -1
            int r6 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r6 == 0) goto L_0x00d5
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r14 = "Content-Length: "
            r11.append(r14)
            long r14 = r7.contentLength()
            r11.append(r14)
            java.lang.String r11 = r11.toString()
            r6.log(r11)
        L_0x00d5:
            okhttp3.Headers r6 = r3.headers()
            int r11 = r6.size()
            r14 = 0
        L_0x00de:
            if (r14 >= r11) goto L_0x011d
            java.lang.String r15 = r6.name(r14)
            r21 = r11
            java.lang.String r11 = "Content-Type"
            boolean r11 = r11.equalsIgnoreCase(r15)
            if (r11 != 0) goto L_0x0114
            java.lang.String r11 = "Content-Length"
            boolean r11 = r11.equalsIgnoreCase(r15)
            if (r11 != 0) goto L_0x0114
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r11 = r1.logger
            r22 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r15)
            r2.append(r13)
            java.lang.String r15 = r6.value(r14)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r11.log(r2)
            goto L_0x0116
        L_0x0114:
            r22 = r2
        L_0x0116:
            int r14 = r14 + 1
            r11 = r21
            r2 = r22
            goto L_0x00de
        L_0x011d:
            r22 = r2
            java.lang.String r2 = "--> END "
            if (r4 == 0) goto L_0x01eb
            if (r8 == 0) goto L_0x01eb
            long r14 = r7.contentLength()
            boolean r6 = r1.isContentLengthTooLarge(r14)
            if (r6 == 0) goto L_0x0131
            goto L_0x01eb
        L_0x0131:
            okhttp3.Headers r6 = r3.headers()
            boolean r6 = r1.bodyEncoded(r6)
            if (r6 == 0) goto L_0x015a
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r2)
            java.lang.String r2 = r3.method()
            r7.append(r2)
            java.lang.String r2 = " (encoded body omitted)"
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            r6.log(r2)
            goto L_0x0206
        L_0x015a:
            e.c r6 = new e.c     // Catch:{ Exception -> 0x01d2 }
            r6.<init>()     // Catch:{ Exception -> 0x01d2 }
            r7.writeTo(r6)     // Catch:{ Exception -> 0x01d2 }
            java.nio.charset.Charset r8 = UTF8     // Catch:{ Exception -> 0x01d2 }
            okhttp3.MediaType r11 = r7.contentType()     // Catch:{ Exception -> 0x01d2 }
            if (r11 == 0) goto L_0x0170
            java.nio.charset.Charset r8 = UTF8     // Catch:{ Exception -> 0x01d2 }
            java.nio.charset.Charset r8 = r11.charset(r8)     // Catch:{ Exception -> 0x01d2 }
        L_0x0170:
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r11 = r1.logger     // Catch:{ Exception -> 0x01d2 }
            r11.log(r5)     // Catch:{ Exception -> 0x01d2 }
            boolean r11 = isPlaintext(r6)     // Catch:{ Exception -> 0x01d2 }
            if (r11 == 0) goto L_0x01aa
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r11 = r1.logger     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r6 = r6.a((java.nio.charset.Charset) r8)     // Catch:{ Exception -> 0x01d2 }
            r11.log(r6)     // Catch:{ Exception -> 0x01d2 }
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r6 = r1.logger     // Catch:{ Exception -> 0x01d2 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d2 }
            r8.<init>()     // Catch:{ Exception -> 0x01d2 }
            r8.append(r2)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r11 = r3.method()     // Catch:{ Exception -> 0x01d2 }
            r8.append(r11)     // Catch:{ Exception -> 0x01d2 }
            r8.append(r12)     // Catch:{ Exception -> 0x01d2 }
            long r14 = r7.contentLength()     // Catch:{ Exception -> 0x01d2 }
            r8.append(r14)     // Catch:{ Exception -> 0x01d2 }
            r8.append(r10)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x01d2 }
            r6.log(r7)     // Catch:{ Exception -> 0x01d2 }
            goto L_0x0206
        L_0x01aa:
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r6 = r1.logger     // Catch:{ Exception -> 0x01d2 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d2 }
            r8.<init>()     // Catch:{ Exception -> 0x01d2 }
            r8.append(r2)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r11 = r3.method()     // Catch:{ Exception -> 0x01d2 }
            r8.append(r11)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r11 = " (binary "
            r8.append(r11)     // Catch:{ Exception -> 0x01d2 }
            long r14 = r7.contentLength()     // Catch:{ Exception -> 0x01d2 }
            r8.append(r14)     // Catch:{ Exception -> 0x01d2 }
            r8.append(r9)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x01d2 }
            r6.log(r7)     // Catch:{ Exception -> 0x01d2 }
            goto L_0x0206
        L_0x01d2:
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r2)
            java.lang.String r2 = r3.method()
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            r6.log(r2)
            goto L_0x0206
        L_0x01eb:
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r2)
            java.lang.String r2 = r3.method()
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            r6.log(r2)
            goto L_0x0206
        L_0x0204:
            r22 = r2
        L_0x0206:
            long r6 = java.lang.System.nanoTime()
            okhttp3.Response r0 = r0.proceed(r3)     // Catch:{ Exception -> 0x03a2 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r14 = java.lang.System.nanoTime()
            long r14 = r14 - r6
            long r2 = r2.toMillis(r14)
            okhttp3.ResponseBody r6 = r0.body()
            if (r6 == 0) goto L_0x0222
            r16 = 1
            goto L_0x0224
        L_0x0222:
            r16 = 0
        L_0x0224:
            if (r16 == 0) goto L_0x022b
            long r14 = r6.contentLength()
            goto L_0x022d
        L_0x022b:
            r14 = 0
        L_0x022d:
            r19 = -1
            int r11 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r11 == 0) goto L_0x0245
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r14)
            java.lang.String r7 = "-byte"
            r11.append(r7)
            java.lang.String r7 = r11.toString()
            goto L_0x0247
        L_0x0245:
            java.lang.String r7 = "unknown-length"
        L_0x0247:
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r8 = r1.logger
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r21 = r10
            java.lang.String r10 = "<-- "
            r11.append(r10)
            int r10 = r0.code()
            r11.append(r10)
            r10 = 32
            r11.append(r10)
            r18 = r9
            java.lang.String r9 = r0.message()
            r11.append(r9)
            r11.append(r10)
            okhttp3.Request r9 = r0.request()
            okhttp3.HttpUrl r9 = r9.url()
            r11.append(r9)
            r11.append(r12)
            r11.append(r2)
            java.lang.String r2 = "ms"
            r11.append(r2)
            if (r22 != 0) goto L_0x029c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ", "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = " body"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            goto L_0x029d
        L_0x029c:
            r2 = r5
        L_0x029d:
            r11.append(r2)
            r2 = 41
            r11.append(r2)
            java.lang.String r2 = r11.toString()
            r8.log(r2)
            if (r22 == 0) goto L_0x03a1
            okhttp3.Headers r2 = r0.headers()
            int r3 = r2.size()
            r7 = 0
        L_0x02b7:
            if (r7 >= r3) goto L_0x02db
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r8 = r1.logger
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r2.name(r7)
            r9.append(r10)
            r9.append(r13)
            java.lang.String r10 = r2.value(r7)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.log(r9)
            int r7 = r7 + 1
            goto L_0x02b7
        L_0x02db:
            java.lang.String r2 = "<-- END HTTP"
            if (r4 == 0) goto L_0x039c
            boolean r3 = okhttp3.internal.http.HttpHeaders.hasBody(r0)
            if (r3 == 0) goto L_0x039c
            if (r16 == 0) goto L_0x039c
            boolean r3 = r1.isContentLengthTooLarge(r14)
            if (r3 == 0) goto L_0x02ef
            goto L_0x039c
        L_0x02ef:
            okhttp3.Headers r3 = r0.headers()
            boolean r3 = r1.bodyEncoded(r3)
            if (r3 == 0) goto L_0x0302
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP (encoded body omitted)"
            r2.log(r3)
            goto L_0x03a1
        L_0x0302:
            e.e r3 = r6.source()     // Catch:{ Exception -> 0x0396 }
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3.b(r7)     // Catch:{ Exception -> 0x0396 }
            e.c r3 = r3.b()     // Catch:{ Exception -> 0x0396 }
            java.nio.charset.Charset r4 = UTF8     // Catch:{ Exception -> 0x0396 }
            okhttp3.MediaType r6 = r6.contentType()     // Catch:{ Exception -> 0x0396 }
            if (r6 == 0) goto L_0x0333
            java.nio.charset.Charset r4 = UTF8     // Catch:{ UnsupportedCharsetException -> 0x0321 }
            java.nio.charset.Charset r4 = r6.charset(r4)     // Catch:{ UnsupportedCharsetException -> 0x0321 }
            goto L_0x0333
        L_0x0321:
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r3 = r1.logger     // Catch:{ Exception -> 0x0396 }
            r3.log(r5)     // Catch:{ Exception -> 0x0396 }
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r3 = r1.logger     // Catch:{ Exception -> 0x0396 }
            java.lang.String r4 = "Couldn't decode the response body; charset is likely malformed."
            r3.log(r4)     // Catch:{ Exception -> 0x0396 }
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r3 = r1.logger     // Catch:{ Exception -> 0x0396 }
            r3.log(r2)     // Catch:{ Exception -> 0x0396 }
            return r0
        L_0x0333:
            boolean r6 = isPlaintext(r3)     // Catch:{ Exception -> 0x0396 }
            if (r6 != 0) goto L_0x035e
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r4 = r1.logger     // Catch:{ Exception -> 0x0396 }
            r4.log(r5)     // Catch:{ Exception -> 0x0396 }
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r4 = r1.logger     // Catch:{ Exception -> 0x0396 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0396 }
            r5.<init>()     // Catch:{ Exception -> 0x0396 }
            java.lang.String r6 = "<-- END HTTP (binary "
            r5.append(r6)     // Catch:{ Exception -> 0x0396 }
            long r6 = r3.a()     // Catch:{ Exception -> 0x0396 }
            r5.append(r6)     // Catch:{ Exception -> 0x0396 }
            r3 = r18
            r5.append(r3)     // Catch:{ Exception -> 0x0396 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0396 }
            r4.log(r3)     // Catch:{ Exception -> 0x0396 }
            return r0
        L_0x035e:
            r6 = 0
            int r8 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0376
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r6 = r1.logger     // Catch:{ Exception -> 0x0396 }
            r6.log(r5)     // Catch:{ Exception -> 0x0396 }
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r5 = r1.logger     // Catch:{ Exception -> 0x0396 }
            e.c r6 = r3.clone()     // Catch:{ Exception -> 0x0396 }
            java.lang.String r4 = r6.a((java.nio.charset.Charset) r4)     // Catch:{ Exception -> 0x0396 }
            r5.log(r4)     // Catch:{ Exception -> 0x0396 }
        L_0x0376:
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r4 = r1.logger     // Catch:{ Exception -> 0x0396 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0396 }
            r5.<init>()     // Catch:{ Exception -> 0x0396 }
            java.lang.String r6 = "<-- END HTTP ("
            r5.append(r6)     // Catch:{ Exception -> 0x0396 }
            long r6 = r3.a()     // Catch:{ Exception -> 0x0396 }
            r5.append(r6)     // Catch:{ Exception -> 0x0396 }
            r3 = r21
            r5.append(r3)     // Catch:{ Exception -> 0x0396 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0396 }
            r4.log(r3)     // Catch:{ Exception -> 0x0396 }
            goto L_0x03a1
        L_0x0396:
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r3 = r1.logger
            r3.log(r2)
            goto L_0x03a1
        L_0x039c:
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r3 = r1.logger
            r3.log(r2)
        L_0x03a1:
            return r0
        L_0x03a2:
            r0 = move-exception
            r2 = r0
            com.tencent.qcloud.core.http.HttpLoggingInterceptor$Logger r0 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<-- HTTP FAILED: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r0.log(r3)
            goto L_0x03bc
        L_0x03bb:
            throw r2
        L_0x03bc:
            goto L_0x03bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.core.http.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    static boolean isPlaintext(c cVar) {
        try {
            c cVar2 = new c();
            cVar.a(cVar2, 0, cVar.a() < 64 ? cVar.a() : 64);
            for (int i = 0; i < 16; i++) {
                if (cVar2.f()) {
                    return true;
                }
                int u = cVar2.u();
                if (Character.isISOControl(u) && !Character.isWhitespace(u)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private boolean bodyEncoded(Headers headers) {
        String str = headers.get(COSRequestHeaderKey.CONTENT_ENCODING);
        return str != null && !str.equalsIgnoreCase(InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
    }
}
