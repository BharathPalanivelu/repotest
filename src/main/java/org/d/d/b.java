package org.d.d;

import com.facebook.internal.ServerProtocol;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.d.a.a.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f33957a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f33958b = false;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f33959c;

    /* renamed from: d  reason: collision with root package name */
    private String f33960d;

    /* renamed from: e  reason: collision with root package name */
    private HttpURLConnection f33961e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f33962f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f33963g;
    private String h;
    private f i;
    private int j;
    private int k;
    private Proxy l;

    public b(f fVar, String str) {
        this.i = fVar;
        this.h = str;
        this.f33963g = new HashMap();
        this.f33959c = new HashMap();
        this.f33962f = new HashMap();
    }

    public c a() throws IOException {
        m();
        return b();
    }

    private void m() throws IOException {
        String a2 = e.a(this.h, this.f33963g);
        if (this.f33961e == null) {
            System.setProperty("http.keepAlive", this.f33958b ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
            URL url = new URL(a2);
            Proxy proxy = this.l;
            this.f33961e = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(proxy == null ? url.openConnection() : url.openConnection(proxy)));
            this.f33961e.setConnectTimeout(this.j);
            this.f33961e.setReadTimeout(this.k);
        }
    }

    /* access modifiers changed from: package-private */
    public c b() throws IOException {
        this.f33961e.setRequestMethod(this.i.name());
        a(this.f33961e);
        if (this.i.equals(f.PUT) || this.i.equals(f.POST)) {
            a(this.f33961e, f());
        }
        return new c(this.f33961e);
    }

    /* access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection) {
        for (Map.Entry next : this.f33962f.entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setRequestProperty(HttpConstants.Header.CONTENT_LENGTH, String.valueOf(bArr.length));
        httpURLConnection.setDoOutput(true);
        httpURLConnection.getOutputStream().write(bArr);
    }

    public void a(String str, String str2) {
        this.f33959c.put(str, str2);
    }

    public void b(String str, String str2) {
        this.f33963g.put(str, str2);
    }

    public Map<String, String> c() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.putAll(e.d(new URL(this.h).getQuery()));
            hashMap.putAll(this.f33963g);
            return hashMap;
        } catch (MalformedURLException e2) {
            throw new a("Malformed URL", e2);
        }
    }

    public Map<String, String> d() {
        return this.f33959c;
    }

    public String e() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public byte[] f() {
        String str = this.f33957a;
        if (str == null) {
            str = e.a(this.f33959c);
        }
        try {
            return str.getBytes(h());
        } catch (UnsupportedEncodingException e2) {
            throw new a("Unsupported Charset: " + h(), e2);
        }
    }

    public f g() {
        return this.i;
    }

    public String h() {
        String str = this.f33960d;
        return str == null ? Charset.defaultCharset().name() : str;
    }

    public void a(int i2, TimeUnit timeUnit) {
        this.j = (int) timeUnit.toMillis((long) i2);
    }

    public int i() {
        return this.j;
    }

    public void b(int i2, TimeUnit timeUnit) {
        this.k = (int) timeUnit.toMillis((long) i2);
    }

    public int j() {
        return this.k;
    }

    public void a(String str) {
        this.f33960d = str;
    }

    public void a(boolean z) {
        this.f33958b = z;
    }

    public boolean k() {
        return this.f33958b;
    }

    public void a(Proxy proxy) {
        this.l = proxy;
    }

    public Proxy l() {
        return this.l;
    }

    public String toString() {
        return String.format("@Request(%s %s)", new Object[]{g(), e()});
    }
}
