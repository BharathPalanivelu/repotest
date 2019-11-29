package io.a.a.a.a.e;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;
import org.slf4j.Marker;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f33173b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    private static b f33174c = b.f33185a;

    /* renamed from: a  reason: collision with root package name */
    public final URL f33175a;

    /* renamed from: d  reason: collision with root package name */
    private HttpURLConnection f33176d = null;

    /* renamed from: e  reason: collision with root package name */
    private final String f33177e;

    /* renamed from: f  reason: collision with root package name */
    private e f33178f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f33179g;
    private boolean h = true;
    private boolean i = false;
    /* access modifiers changed from: private */
    public int j = 8192;
    private String k;
    private int l;

    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f33185a = new b() {
            public HttpURLConnection a(URL url) throws IOException {
                return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            }

            public HttpURLConnection a(URL url, Proxy proxy) throws IOException {
                return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection(proxy)));
            }
        };

        HttpURLConnection a(URL url) throws IOException;

        HttpURLConnection a(URL url, Proxy proxy) throws IOException;
    }

    /* access modifiers changed from: private */
    public static String f(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private static StringBuilder a(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        }
        return sb;
    }

    private static StringBuilder b(String str, StringBuilder sb) {
        int indexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (indexOf == -1) {
            sb.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            sb.append('&');
        }
        return sb;
    }

    public static class c extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        protected c(IOException iOException) {
            super(iOException);
        }

        /* renamed from: a */
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    /* renamed from: io.a.a.a.a.e.d$d  reason: collision with other inner class name */
    protected static abstract class C0512d<V> implements Callable<V> {
        /* access modifiers changed from: protected */
        public abstract V b() throws c, IOException;

        /* access modifiers changed from: protected */
        public abstract void c() throws IOException;

        protected C0512d() {
        }

        public V call() throws c {
            boolean z = true;
            try {
                V b2 = b();
                try {
                    c();
                    return b2;
                } catch (IOException e2) {
                    throw new c(e2);
                }
            } catch (c e3) {
                throw e3;
            } catch (IOException e4) {
                throw new c(e4);
            } catch (Throwable th) {
                th = th;
                c();
                throw th;
            }
        }
    }

    protected static abstract class a<V> extends C0512d<V> {

        /* renamed from: a  reason: collision with root package name */
        private final Closeable f33183a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f33184b;

        protected a(Closeable closeable, boolean z) {
            this.f33183a = closeable;
            this.f33184b = z;
        }

        /* access modifiers changed from: protected */
        public void c() throws IOException {
            Closeable closeable = this.f33183a;
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
            if (this.f33184b) {
                try {
                    this.f33183a.close();
                } catch (IOException unused) {
                }
            } else {
                this.f33183a.close();
            }
        }
    }

    public static class e extends BufferedOutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final CharsetEncoder f33186a;

        public e(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f33186a = Charset.forName(d.f(str)).newEncoder();
        }

        public e a(String str) throws IOException {
            ByteBuffer encode = this.f33186a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    public static String a(CharSequence charSequence) throws c {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), (String) null).toASCIIString();
                int indexOf = aSCIIString.indexOf(63);
                if (indexOf <= 0) {
                    return aSCIIString;
                }
                int i2 = indexOf + 1;
                if (i2 >= aSCIIString.length()) {
                    return aSCIIString;
                }
                return aSCIIString.substring(0, i2) + aSCIIString.substring(i2).replace(Marker.ANY_NON_NULL_MARKER, "%2B");
            } catch (URISyntaxException e2) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e2);
                throw new c(iOException);
            }
        } catch (IOException e3) {
            throw new c(e3);
        }
    }

    public static String a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        a(charSequence2, sb);
        b(charSequence2, sb);
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        Map.Entry next = it.next();
        sb.append(next.getKey().toString());
        sb.append('=');
        Object value = next.getValue();
        if (value != null) {
            sb.append(value);
        }
        while (it.hasNext()) {
            sb.append('&');
            Map.Entry next2 = it.next();
            sb.append(next2.getKey().toString());
            sb.append('=');
            Object value2 = next2.getValue();
            if (value2 != null) {
                sb.append(value2);
            }
        }
        return sb.toString();
    }

    public static d b(CharSequence charSequence) throws c {
        return new d(charSequence, "GET");
    }

    public static d a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a2 = a(charSequence, map);
        if (z) {
            a2 = a((CharSequence) a2);
        }
        return b((CharSequence) a2);
    }

    public static d c(CharSequence charSequence) throws c {
        return new d(charSequence, "POST");
    }

    public static d b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a2 = a(charSequence, map);
        if (z) {
            a2 = a((CharSequence) a2);
        }
        return c((CharSequence) a2);
    }

    public static d d(CharSequence charSequence) throws c {
        return new d(charSequence, "PUT");
    }

    public static d e(CharSequence charSequence) throws c {
        return new d(charSequence, "DELETE");
    }

    public d(CharSequence charSequence, String str) throws c {
        try {
            this.f33175a = new URL(charSequence.toString());
            this.f33177e = str;
        } catch (MalformedURLException e2) {
            throw new c(e2);
        }
    }

    private Proxy q() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.k, this.l));
    }

    private HttpURLConnection r() {
        HttpURLConnection httpURLConnection;
        try {
            if (this.k != null) {
                httpURLConnection = f33174c.a(this.f33175a, q());
            } else {
                httpURLConnection = f33174c.a(this.f33175a);
            }
            httpURLConnection.setRequestMethod(this.f33177e);
            return httpURLConnection;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public String toString() {
        return p() + ' ' + o();
    }

    public HttpURLConnection a() {
        if (this.f33176d == null) {
            this.f33176d = r();
        }
        return this.f33176d;
    }

    public int b() throws c {
        try {
            k();
            return a().getResponseCode();
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public boolean c() throws c {
        return 200 == b();
    }

    /* access modifiers changed from: protected */
    public ByteArrayOutputStream d() {
        int j2 = j();
        if (j2 > 0) {
            return new ByteArrayOutputStream(j2);
        }
        return new ByteArrayOutputStream();
    }

    public String a(String str) throws c {
        ByteArrayOutputStream d2 = d();
        try {
            a((InputStream) f(), (OutputStream) d2);
            return d2.toString(f(str));
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public String e() throws c {
        return a(h());
    }

    public BufferedInputStream f() throws c {
        return new BufferedInputStream(g(), this.j);
    }

    public InputStream g() throws c {
        InputStream inputStream;
        if (b() < 400) {
            try {
                inputStream = a().getInputStream();
            } catch (IOException e2) {
                throw new c(e2);
            }
        } else {
            inputStream = a().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = a().getInputStream();
                } catch (IOException e3) {
                    throw new c(e3);
                }
            }
        }
        if (!this.i || !"gzip".equals(i())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e4) {
            throw new c(e4);
        }
    }

    public d a(int i2) {
        a().setConnectTimeout(i2);
        return this;
    }

    public d a(String str, String str2) {
        a().setRequestProperty(str, str2);
        return this;
    }

    public d a(Map.Entry<String, String> entry) {
        return a(entry.getKey(), entry.getValue());
    }

    public String b(String str) throws c {
        l();
        return a().getHeaderField(str);
    }

    public int c(String str) throws c {
        return a(str, -1);
    }

    public int a(String str, int i2) throws c {
        l();
        return a().getHeaderFieldInt(str, i2);
    }

    public String b(String str, String str2) {
        return c(b(str), str2);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f A[EDGE_INSN: B:30:0x006f->B:29:0x006f ?: BREAK  , SYNTHETIC] */
    protected java.lang.String c(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x006f
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000a
            goto L_0x006f
        L_0x000a:
            int r1 = r9.length()
            r2 = 59
            int r3 = r9.indexOf(r2)
            r4 = 1
            int r3 = r3 + r4
            if (r3 == 0) goto L_0x006f
            if (r3 != r1) goto L_0x001b
            goto L_0x006f
        L_0x001b:
            int r5 = r9.indexOf(r2, r3)
            r6 = -1
            if (r5 != r6) goto L_0x0023
        L_0x0022:
            r5 = r1
        L_0x0023:
            if (r3 >= r5) goto L_0x006f
            r7 = 61
            int r7 = r9.indexOf(r7, r3)
            if (r7 == r6) goto L_0x0066
            if (r7 >= r5) goto L_0x0066
            java.lang.String r3 = r9.substring(r3, r7)
            java.lang.String r3 = r3.trim()
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L_0x0066
            int r7 = r7 + 1
            java.lang.String r3 = r9.substring(r7, r5)
            java.lang.String r3 = r3.trim()
            int r7 = r3.length()
            if (r7 == 0) goto L_0x0066
            r9 = 2
            if (r7 <= r9) goto L_0x0065
            r9 = 0
            char r9 = r3.charAt(r9)
            r10 = 34
            if (r10 != r9) goto L_0x0065
            int r7 = r7 - r4
            char r9 = r3.charAt(r7)
            if (r10 != r9) goto L_0x0065
            java.lang.String r9 = r3.substring(r4, r7)
            return r9
        L_0x0065:
            return r3
        L_0x0066:
            int r3 = r5 + 1
            int r5 = r9.indexOf(r2, r3)
            if (r5 != r6) goto L_0x0023
            goto L_0x0022
        L_0x006f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.e.d.c(java.lang.String, java.lang.String):java.lang.String");
    }

    public String h() {
        return b(HttpConstants.Header.CONTENT_TYPE, "charset");
    }

    public d a(boolean z) {
        a().setUseCaches(z);
        return this;
    }

    public String i() {
        return b(COSRequestHeaderKey.CONTENT_ENCODING);
    }

    public d d(String str) {
        return d(str, (String) null);
    }

    public d d(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return a(HttpConstants.Header.CONTENT_TYPE, str);
        }
        return a(HttpConstants.Header.CONTENT_TYPE, str + "; charset=" + str2);
    }

    public int j() {
        return c(HttpConstants.Header.CONTENT_LENGTH);
    }

    /* access modifiers changed from: protected */
    public d a(InputStream inputStream, OutputStream outputStream) throws IOException {
        final InputStream inputStream2 = inputStream;
        final OutputStream outputStream2 = outputStream;
        return (d) new a<d>(inputStream, this.h) {
            /* renamed from: a */
            public d b() throws IOException {
                byte[] bArr = new byte[d.this.j];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        return d.this;
                    }
                    outputStream2.write(bArr, 0, read);
                }
            }
        }.call();
    }

    /* access modifiers changed from: protected */
    public d k() throws IOException {
        e eVar = this.f33178f;
        if (eVar == null) {
            return this;
        }
        if (this.f33179g) {
            eVar.a("\r\n--00content0boundary00--\r\n");
        }
        if (this.h) {
            try {
                this.f33178f.close();
            } catch (IOException unused) {
            }
        } else {
            this.f33178f.close();
        }
        this.f33178f = null;
        return this;
    }

    /* access modifiers changed from: protected */
    public d l() throws c {
        try {
            return k();
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    /* access modifiers changed from: protected */
    public d m() throws IOException {
        if (this.f33178f != null) {
            return this;
        }
        a().setDoOutput(true);
        this.f33178f = new e(a().getOutputStream(), c(a().getRequestProperty(HttpConstants.Header.CONTENT_TYPE), "charset"), this.j);
        return this;
    }

    /* access modifiers changed from: protected */
    public d n() throws IOException {
        if (!this.f33179g) {
            this.f33179g = true;
            d("multipart/form-data; boundary=00content0boundary00").m();
            this.f33178f.a("--00content0boundary00\r\n");
        } else {
            this.f33178f.a("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public d a(String str, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"");
            sb.append(str2);
        }
        sb.append('\"');
        f(COSRequestHeaderKey.CONTENT_DISPOSITION, sb.toString());
        if (str3 != null) {
            f(HttpConstants.Header.CONTENT_TYPE, str3);
        }
        return f((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS);
    }

    public d e(String str, String str2) {
        return b(str, (String) null, str2);
    }

    public d b(String str, String str2, String str3) throws c {
        return a(str, str2, (String) null, str3);
    }

    public d a(String str, String str2, String str3, String str4) throws c {
        try {
            n();
            a(str, str2, str3);
            this.f33178f.a(str4);
            return this;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public d a(String str, Number number) throws c {
        return a(str, (String) null, number);
    }

    public d a(String str, String str2, Number number) throws c {
        return b(str, str2, number != null ? number.toString() : null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0024 A[SYNTHETIC, Splitter:B:19:0x0024] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.a.a.a.a.e.d a(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.io.File r7) throws io.a.a.a.a.e.d.c {
        /*
            r3 = this;
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x001b }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x001b }
            r2.<init>(r7)     // Catch:{ IOException -> 0x001b }
            r1.<init>(r2)     // Catch:{ IOException -> 0x001b }
            io.a.a.a.a.e.d r4 = r3.a((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.io.InputStream) r1)     // Catch:{ IOException -> 0x0016, all -> 0x0013 }
            r1.close()     // Catch:{ IOException -> 0x0012 }
        L_0x0012:
            return r4
        L_0x0013:
            r4 = move-exception
            r0 = r1
            goto L_0x0022
        L_0x0016:
            r4 = move-exception
            r0 = r1
            goto L_0x001c
        L_0x0019:
            r4 = move-exception
            goto L_0x0022
        L_0x001b:
            r4 = move-exception
        L_0x001c:
            io.a.a.a.a.e.d$c r5 = new io.a.a.a.a.e.d$c     // Catch:{ all -> 0x0019 }
            r5.<init>(r4)     // Catch:{ all -> 0x0019 }
            throw r5     // Catch:{ all -> 0x0019 }
        L_0x0022:
            if (r0 == 0) goto L_0x0027
            r0.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.e.d.a(java.lang.String, java.lang.String, java.lang.String, java.io.File):io.a.a.a.a.e.d");
    }

    public d a(String str, String str2, String str3, InputStream inputStream) throws c {
        try {
            n();
            a(str, str2, str3);
            a(inputStream, (OutputStream) this.f33178f);
            return this;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public d f(String str, String str2) throws c {
        return f((CharSequence) str).f((CharSequence) ": ").f((CharSequence) str2).f((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS);
    }

    public d f(CharSequence charSequence) throws c {
        try {
            m();
            this.f33178f.a(charSequence.toString());
            return this;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public URL o() {
        return a().getURL();
    }

    public String p() {
        return a().getRequestMethod();
    }
}
