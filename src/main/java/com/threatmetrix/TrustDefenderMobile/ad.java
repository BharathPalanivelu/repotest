package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfHttpClient;
import com.threatmetrix.TrustDefenderMobile.aa;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpParams;

class ad {

    /* renamed from: f  reason: collision with root package name */
    private static final String f32543f = ad.class.toString();

    /* renamed from: a  reason: collision with root package name */
    private final AndroidHttpClient f32544a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<BasicHeader> f32545b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private HttpResponse f32546c;

    /* renamed from: d  reason: collision with root package name */
    private HttpRequestBase f32547d;

    /* renamed from: e  reason: collision with root package name */
    private aa.b f32548e;

    ad(AndroidHttpClient androidHttpClient) {
        this.f32544a = androidHttpClient;
        this.f32548e = aa.b.THM_NotYet;
        this.f32547d = null;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2) {
        this.f32545b.add(new BasicHeader(str, str2));
    }

    /* access modifiers changed from: package-private */
    public void a(Map<String, String> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                a(next, map.get(next));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public long a(String str) {
        a((HttpRequestBase) new HttpGet(str));
        if (this.f32546c == null || this.f32548e != aa.b.THM_OK) {
            return -1;
        }
        return (long) this.f32546c.getStatusLine().getStatusCode();
    }

    /* access modifiers changed from: package-private */
    public long a(String str, HttpEntity httpEntity) {
        HttpPost httpPost = new HttpPost(str);
        httpPost.setEntity(httpEntity);
        a((HttpRequestBase) httpPost);
        if (this.f32546c == null || this.f32548e != aa.b.THM_OK) {
            return -1;
        }
        return (long) this.f32546c.getStatusLine().getStatusCode();
    }

    private void a(HttpRequestBase httpRequestBase) {
        synchronized (this) {
            this.f32547d = httpRequestBase;
        }
        Iterator<BasicHeader> it = this.f32545b.iterator();
        while (it.hasNext()) {
            this.f32547d.addHeader(it.next());
        }
        HttpClientParams.setRedirecting(this.f32547d.getParams(), true);
        r rVar = new r();
        if (rVar.a() == null || rVar.a().isEmpty()) {
            this.f32544a.getParams().setParameter("http.route.default-proxy", (Object) null);
        } else {
            this.f32544a.getParams().setParameter("http.route.default-proxy", new HttpHost(rVar.a(), rVar.b()));
        }
        try {
            this.f32546c = FirebasePerfHttpClient.execute(this.f32544a, this.f32547d);
            this.f32548e = aa.b.THM_OK;
        } catch (IOException e2) {
            if (e2.getCause() instanceof CertificateException) {
                this.f32548e = aa.b.THM_HostVerification_Error;
            } else if (e2 instanceof SSLPeerUnverifiedException) {
                this.f32548e = aa.b.THM_HostVerification_Error;
            } else if (e2 instanceof UnknownHostException) {
                this.f32548e = aa.b.THM_HostNotFound_Error;
            } else if (e2 instanceof SocketTimeoutException) {
                this.f32548e = aa.b.THM_NetworkTimeout_Error;
            } else if (this.f32548e == aa.b.THM_NotYet) {
                this.f32548e = aa.b.THM_Connection_Error;
            } else {
                Log.d(f32543f, "Connection interrupted!", e2);
            }
            Log.e(f32543f, "Failed to retrieve URI", e2);
        } catch (RuntimeException e3) {
            Log.e(f32543f, "Caught runtime exception:", e3);
            this.f32548e = aa.b.THM_Connection_Error;
        }
    }

    public String a() {
        if (this.f32547d == null) {
            return "";
        }
        return this.f32547d.getURI().getScheme() + "://" + this.f32547d.getURI().getHost() + this.f32547d.getURI().getPath();
    }

    public String b() {
        HttpRequestBase httpRequestBase = this.f32547d;
        return httpRequestBase != null ? httpRequestBase.getURI().getHost() : "";
    }

    public void c() {
        Log.d(f32543f, "aborting connection");
        synchronized (this) {
            if (this.f32547d != null) {
                this.f32547d.abort();
            }
        }
        this.f32548e = aa.b.THM_Interrupted_Error;
    }

    public HttpResponse d() {
        return this.f32546c;
    }

    public void e() {
        HttpResponse httpResponse = this.f32546c;
        if (httpResponse != null) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                try {
                    entity.consumeContent();
                } catch (IOException e2) {
                    Log.d(f32543f, "failed to consume content", e2);
                }
            }
        }
    }

    public static void a(Context context, HttpClient httpClient, int i) {
        if (Build.VERSION.SDK_INT >= 14) {
            b(context, httpClient, i);
        } else {
            c(context, httpClient, i);
        }
    }

    private static void b(Context context, HttpClient httpClient, int i) {
        httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(i, new SSLSessionCache(context)), 443));
    }

    private static void c(final Context context, HttpClient httpClient, final int i) {
        httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", new LayeredSocketFactory() {

            /* renamed from: a  reason: collision with root package name */
            final SSLSocketFactory f32549a = SSLCertificateSocketFactory.getHttpSocketFactory(i, new SSLSessionCache(context));

            public Socket createSocket() throws IOException {
                return this.f32549a.createSocket();
            }

            public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) throws IOException {
                return this.f32549a.connectSocket(socket, str, i, inetAddress, i2, httpParams);
            }

            public boolean isSecure(Socket socket) throws IllegalArgumentException {
                return this.f32549a.isSecure(socket);
            }

            public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
                a(socket, str);
                return this.f32549a.createSocket(socket, str, i, z);
            }

            private void a(Socket socket, String str) {
                try {
                    Field declaredField = InetAddress.class.getDeclaredField("hostName");
                    declaredField.setAccessible(true);
                    declaredField.set(socket.getInetAddress(), str);
                } catch (Exception unused) {
                }
            }
        }, 443));
    }

    public aa.b f() {
        return this.f32548e;
    }
}
