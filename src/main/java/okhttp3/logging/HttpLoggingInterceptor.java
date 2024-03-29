package okhttp3.logging;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import e.c;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;

public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Set<String> headersToRedact;
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

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        this.headersToRedact = Collections.emptySet();
        this.level = Level.NONE;
        this.logger = logger2;
    }

    public void redactHeader(String str) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
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

    /* JADX WARNING: Removed duplicated region for block: B:93:0x02ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r20) throws java.io.IOException {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            okhttp3.logging.HttpLoggingInterceptor$Level r2 = r1.level
            okhttp3.Request r3 = r20.request()
            okhttp3.logging.HttpLoggingInterceptor$Level r4 = okhttp3.logging.HttpLoggingInterceptor.Level.NONE
            if (r2 != r4) goto L_0x0013
            okhttp3.Response r0 = r0.proceed(r3)
            return r0
        L_0x0013:
            okhttp3.logging.HttpLoggingInterceptor$Level r4 = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
            r5 = 1
            if (r2 != r4) goto L_0x001a
            r4 = 1
            goto L_0x001b
        L_0x001a:
            r4 = 0
        L_0x001b:
            if (r4 != 0) goto L_0x0024
            okhttp3.logging.HttpLoggingInterceptor$Level r7 = okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS
            if (r2 != r7) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r2 = 0
            goto L_0x0025
        L_0x0024:
            r2 = 1
        L_0x0025:
            okhttp3.RequestBody r7 = r3.body()
            if (r7 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r5 = 0
        L_0x002d:
            okhttp3.Connection r8 = r20.connection()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "--> "
            r9.append(r10)
            java.lang.String r10 = r3.method()
            r9.append(r10)
            r10 = 32
            r9.append(r10)
            okhttp3.HttpUrl r11 = r3.url()
            r9.append(r11)
            java.lang.String r11 = ""
            if (r8 == 0) goto L_0x0068
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = " "
            r12.append(r13)
            okhttp3.Protocol r8 = r8.protocol()
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            goto L_0x0069
        L_0x0068:
            r8 = r11
        L_0x0069:
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "-byte body)"
            java.lang.String r12 = " ("
            if (r2 != 0) goto L_0x0091
            if (r5 == 0) goto L_0x0091
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r8)
            r13.append(r12)
            long r14 = r7.contentLength()
            r13.append(r14)
            r13.append(r9)
            java.lang.String r8 = r13.toString()
        L_0x0091:
            okhttp3.logging.HttpLoggingInterceptor$Logger r13 = r1.logger
            r13.log(r8)
            java.lang.String r8 = "-byte body omitted)"
            r13 = -1
            if (r2 == 0) goto L_0x01c6
            if (r5 == 0) goto L_0x00e0
            okhttp3.MediaType r15 = r7.contentType()
            if (r15 == 0) goto L_0x00be
            okhttp3.logging.HttpLoggingInterceptor$Logger r15 = r1.logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r10 = "Content-Type: "
            r6.append(r10)
            okhttp3.MediaType r10 = r7.contentType()
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            r15.log(r6)
        L_0x00be:
            long r16 = r7.contentLength()
            int r6 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x00e0
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r15 = "Content-Length: "
            r10.append(r15)
            long r13 = r7.contentLength()
            r10.append(r13)
            java.lang.String r10 = r10.toString()
            r6.log(r10)
        L_0x00e0:
            okhttp3.Headers r6 = r3.headers()
            int r10 = r6.size()
            r13 = 0
        L_0x00e9:
            if (r13 >= r10) goto L_0x0105
            java.lang.String r14 = r6.name(r13)
            java.lang.String r15 = "Content-Type"
            boolean r15 = r15.equalsIgnoreCase(r14)
            if (r15 != 0) goto L_0x0102
            java.lang.String r15 = "Content-Length"
            boolean r14 = r15.equalsIgnoreCase(r14)
            if (r14 != 0) goto L_0x0102
            r1.logHeader(r6, r13)
        L_0x0102:
            int r13 = r13 + 1
            goto L_0x00e9
        L_0x0105:
            java.lang.String r6 = "--> END "
            if (r4 == 0) goto L_0x01ae
            if (r5 != 0) goto L_0x010d
            goto L_0x01ae
        L_0x010d:
            okhttp3.Headers r5 = r3.headers()
            boolean r5 = bodyHasUnknownEncoding(r5)
            if (r5 == 0) goto L_0x0136
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = r3.method()
            r7.append(r6)
            java.lang.String r6 = " (encoded body omitted)"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.log(r6)
            goto L_0x01c6
        L_0x0136:
            e.c r5 = new e.c
            r5.<init>()
            r7.writeTo(r5)
            java.nio.charset.Charset r10 = UTF8
            okhttp3.MediaType r13 = r7.contentType()
            if (r13 == 0) goto L_0x014c
            java.nio.charset.Charset r10 = UTF8
            java.nio.charset.Charset r10 = r13.charset(r10)
        L_0x014c:
            okhttp3.logging.HttpLoggingInterceptor$Logger r13 = r1.logger
            r13.log(r11)
            boolean r13 = isPlaintext(r5)
            if (r13 == 0) goto L_0x0186
            okhttp3.logging.HttpLoggingInterceptor$Logger r13 = r1.logger
            java.lang.String r5 = r5.a((java.nio.charset.Charset) r10)
            r13.log(r5)
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r6)
            java.lang.String r6 = r3.method()
            r10.append(r6)
            r10.append(r12)
            long r6 = r7.contentLength()
            r10.append(r6)
            r10.append(r9)
            java.lang.String r6 = r10.toString()
            r5.log(r6)
            goto L_0x01c6
        L_0x0186:
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r6)
            java.lang.String r6 = r3.method()
            r10.append(r6)
            java.lang.String r6 = " (binary "
            r10.append(r6)
            long r6 = r7.contentLength()
            r10.append(r6)
            r10.append(r8)
            java.lang.String r6 = r10.toString()
            r5.log(r6)
            goto L_0x01c6
        L_0x01ae:
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = r3.method()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.log(r6)
        L_0x01c6:
            long r5 = java.lang.System.nanoTime()
            okhttp3.Response r0 = r0.proceed(r3)     // Catch:{ Exception -> 0x0392 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r13 = java.lang.System.nanoTime()
            long r13 = r13 - r5
            long r5 = r3.toMillis(r13)
            okhttp3.ResponseBody r3 = r0.body()
            long r13 = r3.contentLength()
            r16 = -1
            int r7 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r7 == 0) goto L_0x01f9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r13)
            java.lang.String r10 = "-byte"
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            goto L_0x01fb
        L_0x01f9:
            java.lang.String r7 = "unknown-length"
        L_0x01fb:
            okhttp3.logging.HttpLoggingInterceptor$Logger r10 = r1.logger
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r16 = r9
            java.lang.String r9 = "<-- "
            r15.append(r9)
            int r9 = r0.code()
            r15.append(r9)
            java.lang.String r9 = r0.message()
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x0220
            r9 = r11
            r17 = r13
            r13 = 32
            goto L_0x0237
        L_0x0220:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r17 = r13
            r13 = 32
            r9.append(r13)
            java.lang.String r14 = r0.message()
            r9.append(r14)
            java.lang.String r9 = r9.toString()
        L_0x0237:
            r15.append(r9)
            r15.append(r13)
            okhttp3.Request r9 = r0.request()
            okhttp3.HttpUrl r9 = r9.url()
            r15.append(r9)
            r15.append(r12)
            r15.append(r5)
            java.lang.String r5 = "ms"
            r15.append(r5)
            if (r2 != 0) goto L_0x026c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = ", "
            r5.append(r6)
            r5.append(r7)
            java.lang.String r6 = " body"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            goto L_0x026d
        L_0x026c:
            r5 = r11
        L_0x026d:
            r15.append(r5)
            r5 = 41
            r15.append(r5)
            java.lang.String r5 = r15.toString()
            r10.log(r5)
            if (r2 == 0) goto L_0x0391
            okhttp3.Headers r2 = r0.headers()
            int r5 = r2.size()
            r6 = 0
        L_0x0287:
            if (r6 >= r5) goto L_0x028f
            r1.logHeader(r2, r6)
            int r6 = r6 + 1
            goto L_0x0287
        L_0x028f:
            if (r4 == 0) goto L_0x038a
            boolean r4 = okhttp3.internal.http.HttpHeaders.hasBody(r0)
            if (r4 != 0) goto L_0x0299
            goto L_0x038a
        L_0x0299:
            okhttp3.Headers r4 = r0.headers()
            boolean r4 = bodyHasUnknownEncoding(r4)
            if (r4 == 0) goto L_0x02ac
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP (encoded body omitted)"
            r2.log(r3)
            goto L_0x0391
        L_0x02ac:
            e.e r4 = r3.source()
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4.b(r5)
            e.c r4 = r4.b()
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r2 = r2.get(r5)
            java.lang.String r5 = "gzip"
            boolean r2 = r5.equalsIgnoreCase(r2)
            r5 = 0
            if (r2 == 0) goto L_0x02f2
            long r6 = r4.a()
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            e.l r6 = new e.l     // Catch:{ all -> 0x02eb }
            e.c r4 = r4.clone()     // Catch:{ all -> 0x02eb }
            r6.<init>(r4)     // Catch:{ all -> 0x02eb }
            e.c r4 = new e.c     // Catch:{ all -> 0x02e8 }
            r4.<init>()     // Catch:{ all -> 0x02e8 }
            r4.a((e.v) r6)     // Catch:{ all -> 0x02e8 }
            r6.close()
            goto L_0x02f3
        L_0x02e8:
            r0 = move-exception
            r5 = r6
            goto L_0x02ec
        L_0x02eb:
            r0 = move-exception
        L_0x02ec:
            if (r5 == 0) goto L_0x02f1
            r5.close()
        L_0x02f1:
            throw r0
        L_0x02f2:
            r2 = r5
        L_0x02f3:
            java.nio.charset.Charset r5 = UTF8
            okhttp3.MediaType r3 = r3.contentType()
            if (r3 == 0) goto L_0x0301
            java.nio.charset.Charset r5 = UTF8
            java.nio.charset.Charset r5 = r3.charset(r5)
        L_0x0301:
            boolean r3 = isPlaintext(r4)
            if (r3 != 0) goto L_0x032a
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            r2.log(r11)
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "<-- END HTTP (binary "
            r3.append(r5)
            long r4 = r4.a()
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r2.log(r3)
            return r0
        L_0x032a:
            r6 = 0
            int r3 = (r17 > r6 ? 1 : (r17 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x0342
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            r3.log(r11)
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            e.c r6 = r4.clone()
            java.lang.String r5 = r6.a((java.nio.charset.Charset) r5)
            r3.log(r5)
        L_0x0342:
            java.lang.String r3 = "<-- END HTTP ("
            if (r2 == 0) goto L_0x036c
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r3)
            long r3 = r4.a()
            r6.append(r3)
            java.lang.String r3 = "-byte, "
            r6.append(r3)
            r6.append(r2)
            java.lang.String r2 = "-gzipped-byte body)"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r5.log(r2)
            goto L_0x0391
        L_0x036c:
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            long r3 = r4.a()
            r5.append(r3)
            r3 = r16
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2.log(r3)
            goto L_0x0391
        L_0x038a:
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP"
            r2.log(r3)
        L_0x0391:
            return r0
        L_0x0392:
            r0 = move-exception
            r2 = r0
            okhttp3.logging.HttpLoggingInterceptor$Logger r0 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<-- HTTP FAILED: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r0.log(r3)
            goto L_0x03ac
        L_0x03ab:
            throw r2
        L_0x03ac:
            goto L_0x03ab
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private void logHeader(Headers headers, int i) {
        String value = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        Logger logger2 = this.logger;
        logger2.log(headers.name(i) + ": " + value);
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

    private static boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get(COSRequestHeaderKey.CONTENT_ENCODING);
        return str != null && !str.equalsIgnoreCase(InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY) && !str.equalsIgnoreCase("gzip");
    }
}
