package com.google.firebase.perf.network;

import com.google.android.gms.internal.p000firebaseperf.zzau;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class e extends HttpsURLConnection {

    /* renamed from: a  reason: collision with root package name */
    private final d f14332a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpsURLConnection f14333b;

    e(HttpsURLConnection httpsURLConnection, zzbg zzbg, zzau zzau) {
        super(httpsURLConnection.getURL());
        this.f14333b = httpsURLConnection;
        this.f14332a = new d(httpsURLConnection, zzbg, zzau);
    }

    public final void connect() throws IOException {
        this.f14332a.a();
    }

    public final void disconnect() {
        this.f14332a.b();
    }

    public final Object getContent() throws IOException {
        return this.f14332a.c();
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        return this.f14332a.a(clsArr);
    }

    public final InputStream getInputStream() throws IOException {
        return this.f14332a.d();
    }

    public final long getLastModified() {
        return this.f14332a.e();
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.f14332a.f();
    }

    public final Permission getPermission() throws IOException {
        return this.f14332a.g();
    }

    public final int getResponseCode() throws IOException {
        return this.f14332a.h();
    }

    public final String getResponseMessage() throws IOException {
        return this.f14332a.i();
    }

    public final long getExpiration() {
        return this.f14332a.j();
    }

    public final String getHeaderField(int i) {
        return this.f14332a.a(i);
    }

    public final String getHeaderField(String str) {
        return this.f14332a.a(str);
    }

    public final long getHeaderFieldDate(String str, long j) {
        return this.f14332a.a(str, j);
    }

    public final int getHeaderFieldInt(String str, int i) {
        return this.f14332a.a(str, i);
    }

    public final long getHeaderFieldLong(String str, long j) {
        return this.f14332a.b(str, j);
    }

    public final String getHeaderFieldKey(int i) {
        return this.f14332a.b(i);
    }

    public final Map<String, List<String>> getHeaderFields() {
        return this.f14332a.k();
    }

    public final String getContentEncoding() {
        return this.f14332a.l();
    }

    public final int getContentLength() {
        return this.f14332a.m();
    }

    public final long getContentLengthLong() {
        return this.f14332a.n();
    }

    public final String getContentType() {
        return this.f14332a.o();
    }

    public final long getDate() {
        return this.f14332a.p();
    }

    public final void addRequestProperty(String str, String str2) {
        this.f14332a.a(str, str2);
    }

    public final boolean equals(Object obj) {
        return this.f14332a.equals(obj);
    }

    public final boolean getAllowUserInteraction() {
        return this.f14332a.q();
    }

    public final int getConnectTimeout() {
        return this.f14332a.r();
    }

    public final boolean getDefaultUseCaches() {
        return this.f14332a.s();
    }

    public final boolean getDoInput() {
        return this.f14332a.t();
    }

    public final boolean getDoOutput() {
        return this.f14332a.u();
    }

    public final InputStream getErrorStream() {
        return this.f14332a.v();
    }

    public final long getIfModifiedSince() {
        return this.f14332a.w();
    }

    public final boolean getInstanceFollowRedirects() {
        return this.f14332a.x();
    }

    public final int getReadTimeout() {
        return this.f14332a.y();
    }

    public final String getRequestMethod() {
        return this.f14332a.z();
    }

    public final Map<String, List<String>> getRequestProperties() {
        return this.f14332a.A();
    }

    public final String getRequestProperty(String str) {
        return this.f14332a.b(str);
    }

    public final URL getURL() {
        return this.f14332a.B();
    }

    public final boolean getUseCaches() {
        return this.f14332a.C();
    }

    public final int hashCode() {
        return this.f14332a.hashCode();
    }

    public final void setAllowUserInteraction(boolean z) {
        this.f14332a.a(z);
    }

    public final void setChunkedStreamingMode(int i) {
        this.f14332a.c(i);
    }

    public final void setConnectTimeout(int i) {
        this.f14332a.d(i);
    }

    public final void setDefaultUseCaches(boolean z) {
        this.f14332a.b(z);
    }

    public final void setDoInput(boolean z) {
        this.f14332a.c(z);
    }

    public final void setDoOutput(boolean z) {
        this.f14332a.d(z);
    }

    public final void setFixedLengthStreamingMode(int i) {
        this.f14332a.e(i);
    }

    public final void setFixedLengthStreamingMode(long j) {
        this.f14332a.a(j);
    }

    public final void setIfModifiedSince(long j) {
        this.f14332a.b(j);
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.f14332a.e(z);
    }

    public final void setReadTimeout(int i) {
        this.f14332a.f(i);
    }

    public final void setRequestMethod(String str) throws ProtocolException {
        this.f14332a.c(str);
    }

    public final void setRequestProperty(String str, String str2) {
        this.f14332a.b(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.f14332a.f(z);
    }

    public final String toString() {
        return this.f14332a.toString();
    }

    public final boolean usingProxy() {
        return this.f14332a.D();
    }

    public final String getCipherSuite() {
        return this.f14333b.getCipherSuite();
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.f14333b.getHostnameVerifier();
    }

    public final Certificate[] getLocalCertificates() {
        return this.f14333b.getLocalCertificates();
    }

    public final Principal getLocalPrincipal() {
        return this.f14333b.getLocalPrincipal();
    }

    public final Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.f14333b.getPeerPrincipal();
    }

    public final Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        return this.f14333b.getServerCertificates();
    }

    public final SSLSocketFactory getSSLSocketFactory() {
        return this.f14333b.getSSLSocketFactory();
    }

    public final void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f14333b.setHostnameVerifier(hostnameVerifier);
    }

    public final void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f14333b.setSSLSocketFactory(sSLSocketFactory);
    }
}
