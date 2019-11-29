package com.google.firebase.perf.network;

import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.zzau;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private final HttpURLConnection f14327a;

    /* renamed from: b  reason: collision with root package name */
    private final zzau f14328b;

    /* renamed from: c  reason: collision with root package name */
    private long f14329c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f14330d = -1;

    /* renamed from: e  reason: collision with root package name */
    private final zzbg f14331e;

    public d(HttpURLConnection httpURLConnection, zzbg zzbg, zzau zzau) {
        this.f14327a = httpURLConnection;
        this.f14328b = zzau;
        this.f14331e = zzbg;
        this.f14328b.zza(this.f14327a.getURL().toString());
    }

    public final void a() throws IOException {
        if (this.f14329c == -1) {
            this.f14331e.reset();
            this.f14329c = this.f14331e.zzcr();
            this.f14328b.zzg(this.f14329c);
        }
        try {
            this.f14327a.connect();
        } catch (IOException e2) {
            this.f14328b.zzj(this.f14331e.zzcs());
            h.a(this.f14328b);
            throw e2;
        }
    }

    public final void b() {
        this.f14328b.zzj(this.f14331e.zzcs());
        this.f14328b.zzai();
        this.f14327a.disconnect();
    }

    public final Object c() throws IOException {
        E();
        this.f14328b.zzb(this.f14327a.getResponseCode());
        try {
            Object content = this.f14327a.getContent();
            if (content instanceof InputStream) {
                this.f14328b.zzc(this.f14327a.getContentType());
                return new a((InputStream) content, this.f14328b, this.f14331e);
            }
            this.f14328b.zzc(this.f14327a.getContentType());
            this.f14328b.zzk((long) this.f14327a.getContentLength());
            this.f14328b.zzj(this.f14331e.zzcs());
            this.f14328b.zzai();
            return content;
        } catch (IOException e2) {
            this.f14328b.zzj(this.f14331e.zzcs());
            h.a(this.f14328b);
            throw e2;
        }
    }

    public final Object a(Class[] clsArr) throws IOException {
        E();
        this.f14328b.zzb(this.f14327a.getResponseCode());
        try {
            Object content = this.f14327a.getContent(clsArr);
            if (content instanceof InputStream) {
                this.f14328b.zzc(this.f14327a.getContentType());
                return new a((InputStream) content, this.f14328b, this.f14331e);
            }
            this.f14328b.zzc(this.f14327a.getContentType());
            this.f14328b.zzk((long) this.f14327a.getContentLength());
            this.f14328b.zzj(this.f14331e.zzcs());
            this.f14328b.zzai();
            return content;
        } catch (IOException e2) {
            this.f14328b.zzj(this.f14331e.zzcs());
            h.a(this.f14328b);
            throw e2;
        }
    }

    public final InputStream d() throws IOException {
        E();
        this.f14328b.zzb(this.f14327a.getResponseCode());
        this.f14328b.zzc(this.f14327a.getContentType());
        try {
            return new a(this.f14327a.getInputStream(), this.f14328b, this.f14331e);
        } catch (IOException e2) {
            this.f14328b.zzj(this.f14331e.zzcs());
            h.a(this.f14328b);
            throw e2;
        }
    }

    public final long e() {
        E();
        return this.f14327a.getLastModified();
    }

    public final OutputStream f() throws IOException {
        try {
            return new c(this.f14327a.getOutputStream(), this.f14328b, this.f14331e);
        } catch (IOException e2) {
            this.f14328b.zzj(this.f14331e.zzcs());
            h.a(this.f14328b);
            throw e2;
        }
    }

    public final Permission g() throws IOException {
        try {
            return this.f14327a.getPermission();
        } catch (IOException e2) {
            this.f14328b.zzj(this.f14331e.zzcs());
            h.a(this.f14328b);
            throw e2;
        }
    }

    public final int h() throws IOException {
        E();
        if (this.f14330d == -1) {
            this.f14330d = this.f14331e.zzcs();
            this.f14328b.zzi(this.f14330d);
        }
        try {
            int responseCode = this.f14327a.getResponseCode();
            this.f14328b.zzb(responseCode);
            return responseCode;
        } catch (IOException e2) {
            this.f14328b.zzj(this.f14331e.zzcs());
            h.a(this.f14328b);
            throw e2;
        }
    }

    public final String i() throws IOException {
        E();
        if (this.f14330d == -1) {
            this.f14330d = this.f14331e.zzcs();
            this.f14328b.zzi(this.f14330d);
        }
        try {
            String responseMessage = this.f14327a.getResponseMessage();
            this.f14328b.zzb(this.f14327a.getResponseCode());
            return responseMessage;
        } catch (IOException e2) {
            this.f14328b.zzj(this.f14331e.zzcs());
            h.a(this.f14328b);
            throw e2;
        }
    }

    public final long j() {
        E();
        return this.f14327a.getExpiration();
    }

    public final String a(int i) {
        E();
        return this.f14327a.getHeaderField(i);
    }

    public final String a(String str) {
        E();
        return this.f14327a.getHeaderField(str);
    }

    public final long a(String str, long j) {
        E();
        return this.f14327a.getHeaderFieldDate(str, j);
    }

    public final int a(String str, int i) {
        E();
        return this.f14327a.getHeaderFieldInt(str, i);
    }

    public final long b(String str, long j) {
        E();
        return this.f14327a.getHeaderFieldLong(str, j);
    }

    public final String b(int i) {
        E();
        return this.f14327a.getHeaderFieldKey(i);
    }

    public final Map<String, List<String>> k() {
        E();
        return this.f14327a.getHeaderFields();
    }

    public final String l() {
        E();
        return this.f14327a.getContentEncoding();
    }

    public final int m() {
        E();
        return this.f14327a.getContentLength();
    }

    public final long n() {
        E();
        return this.f14327a.getContentLengthLong();
    }

    public final String o() {
        E();
        return this.f14327a.getContentType();
    }

    public final long p() {
        E();
        return this.f14327a.getDate();
    }

    public final void a(String str, String str2) {
        this.f14327a.addRequestProperty(str, str2);
    }

    public final boolean equals(Object obj) {
        return this.f14327a.equals(obj);
    }

    public final boolean q() {
        return this.f14327a.getAllowUserInteraction();
    }

    public final int r() {
        return this.f14327a.getConnectTimeout();
    }

    public final boolean s() {
        return this.f14327a.getDefaultUseCaches();
    }

    public final boolean t() {
        return this.f14327a.getDoInput();
    }

    public final boolean u() {
        return this.f14327a.getDoOutput();
    }

    public final InputStream v() {
        E();
        try {
            this.f14328b.zzb(this.f14327a.getResponseCode());
        } catch (IOException unused) {
            Log.d("FirebasePerformance", "IOException thrown trying to obtain the response code");
        }
        InputStream errorStream = this.f14327a.getErrorStream();
        return errorStream != null ? new a(errorStream, this.f14328b, this.f14331e) : errorStream;
    }

    public final long w() {
        return this.f14327a.getIfModifiedSince();
    }

    public final boolean x() {
        return this.f14327a.getInstanceFollowRedirects();
    }

    public final int y() {
        return this.f14327a.getReadTimeout();
    }

    public final String z() {
        return this.f14327a.getRequestMethod();
    }

    public final Map<String, List<String>> A() {
        return this.f14327a.getRequestProperties();
    }

    public final String b(String str) {
        return this.f14327a.getRequestProperty(str);
    }

    public final URL B() {
        return this.f14327a.getURL();
    }

    public final boolean C() {
        return this.f14327a.getUseCaches();
    }

    public final int hashCode() {
        return this.f14327a.hashCode();
    }

    public final void a(boolean z) {
        this.f14327a.setAllowUserInteraction(z);
    }

    public final void c(int i) {
        this.f14327a.setChunkedStreamingMode(i);
    }

    public final void d(int i) {
        this.f14327a.setConnectTimeout(i);
    }

    public final void b(boolean z) {
        this.f14327a.setDefaultUseCaches(z);
    }

    public final void c(boolean z) {
        this.f14327a.setDoInput(z);
    }

    public final void d(boolean z) {
        this.f14327a.setDoOutput(z);
    }

    public final void e(int i) {
        this.f14327a.setFixedLengthStreamingMode(i);
    }

    public final void a(long j) {
        this.f14327a.setFixedLengthStreamingMode(j);
    }

    public final void b(long j) {
        this.f14327a.setIfModifiedSince(j);
    }

    public final void e(boolean z) {
        this.f14327a.setInstanceFollowRedirects(z);
    }

    public final void f(int i) {
        this.f14327a.setReadTimeout(i);
    }

    public final void c(String str) throws ProtocolException {
        this.f14327a.setRequestMethod(str);
    }

    public final void b(String str, String str2) {
        this.f14327a.setRequestProperty(str, str2);
    }

    public final void f(boolean z) {
        this.f14327a.setUseCaches(z);
    }

    public final String toString() {
        return this.f14327a.toString();
    }

    public final boolean D() {
        return this.f14327a.usingProxy();
    }

    private final void E() {
        if (this.f14329c == -1) {
            this.f14331e.reset();
            this.f14329c = this.f14331e.zzcr();
            this.f14328b.zzg(this.f14329c);
        }
        String requestMethod = this.f14327a.getRequestMethod();
        if (requestMethod != null) {
            this.f14328b.zzb(requestMethod);
        } else if (this.f14327a.getDoOutput()) {
            this.f14328b.zzb("POST");
        } else {
            this.f14328b.zzb("GET");
        }
    }
}
