package com.google.firebase.perf.network;

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

public final class b extends HttpURLConnection {

    /* renamed from: a  reason: collision with root package name */
    private final d f14322a;

    b(HttpURLConnection httpURLConnection, zzbg zzbg, zzau zzau) {
        super(httpURLConnection.getURL());
        this.f14322a = new d(httpURLConnection, zzbg, zzau);
    }

    public final void connect() throws IOException {
        this.f14322a.a();
    }

    public final void disconnect() {
        this.f14322a.b();
    }

    public final Object getContent() throws IOException {
        return this.f14322a.c();
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        return this.f14322a.a(clsArr);
    }

    public final InputStream getInputStream() throws IOException {
        return this.f14322a.d();
    }

    public final long getLastModified() {
        return this.f14322a.e();
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.f14322a.f();
    }

    public final Permission getPermission() throws IOException {
        return this.f14322a.g();
    }

    public final int getResponseCode() throws IOException {
        return this.f14322a.h();
    }

    public final String getResponseMessage() throws IOException {
        return this.f14322a.i();
    }

    public final long getExpiration() {
        return this.f14322a.j();
    }

    public final String getHeaderField(int i) {
        return this.f14322a.a(i);
    }

    public final String getHeaderField(String str) {
        return this.f14322a.a(str);
    }

    public final long getHeaderFieldDate(String str, long j) {
        return this.f14322a.a(str, j);
    }

    public final int getHeaderFieldInt(String str, int i) {
        return this.f14322a.a(str, i);
    }

    public final long getHeaderFieldLong(String str, long j) {
        return this.f14322a.b(str, j);
    }

    public final String getHeaderFieldKey(int i) {
        return this.f14322a.b(i);
    }

    public final Map<String, List<String>> getHeaderFields() {
        return this.f14322a.k();
    }

    public final String getContentEncoding() {
        return this.f14322a.l();
    }

    public final int getContentLength() {
        return this.f14322a.m();
    }

    public final long getContentLengthLong() {
        return this.f14322a.n();
    }

    public final String getContentType() {
        return this.f14322a.o();
    }

    public final long getDate() {
        return this.f14322a.p();
    }

    public final void addRequestProperty(String str, String str2) {
        this.f14322a.a(str, str2);
    }

    public final boolean equals(Object obj) {
        return this.f14322a.equals(obj);
    }

    public final boolean getAllowUserInteraction() {
        return this.f14322a.q();
    }

    public final int getConnectTimeout() {
        return this.f14322a.r();
    }

    public final boolean getDefaultUseCaches() {
        return this.f14322a.s();
    }

    public final boolean getDoInput() {
        return this.f14322a.t();
    }

    public final boolean getDoOutput() {
        return this.f14322a.u();
    }

    public final InputStream getErrorStream() {
        return this.f14322a.v();
    }

    public final long getIfModifiedSince() {
        return this.f14322a.w();
    }

    public final boolean getInstanceFollowRedirects() {
        return this.f14322a.x();
    }

    public final int getReadTimeout() {
        return this.f14322a.y();
    }

    public final String getRequestMethod() {
        return this.f14322a.z();
    }

    public final Map<String, List<String>> getRequestProperties() {
        return this.f14322a.A();
    }

    public final String getRequestProperty(String str) {
        return this.f14322a.b(str);
    }

    public final URL getURL() {
        return this.f14322a.B();
    }

    public final boolean getUseCaches() {
        return this.f14322a.C();
    }

    public final int hashCode() {
        return this.f14322a.hashCode();
    }

    public final void setAllowUserInteraction(boolean z) {
        this.f14322a.a(z);
    }

    public final void setChunkedStreamingMode(int i) {
        this.f14322a.c(i);
    }

    public final void setConnectTimeout(int i) {
        this.f14322a.d(i);
    }

    public final void setDefaultUseCaches(boolean z) {
        this.f14322a.b(z);
    }

    public final void setDoInput(boolean z) {
        this.f14322a.c(z);
    }

    public final void setDoOutput(boolean z) {
        this.f14322a.d(z);
    }

    public final void setFixedLengthStreamingMode(int i) {
        this.f14322a.e(i);
    }

    public final void setFixedLengthStreamingMode(long j) {
        this.f14322a.a(j);
    }

    public final void setIfModifiedSince(long j) {
        this.f14322a.b(j);
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.f14322a.e(z);
    }

    public final void setReadTimeout(int i) {
        this.f14322a.f(i);
    }

    public final void setRequestMethod(String str) throws ProtocolException {
        this.f14322a.c(str);
    }

    public final void setRequestProperty(String str, String str2) {
        this.f14322a.b(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.f14322a.f(z);
    }

    public final String toString() {
        return this.f14322a.toString();
    }

    public final boolean usingProxy() {
        return this.f14322a.D();
    }
}
