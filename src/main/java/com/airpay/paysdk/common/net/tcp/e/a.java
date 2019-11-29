package com.airpay.paysdk.common.net.tcp.e;

import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.SocketFactory;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class a extends SSLSocketFactory {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f4069b = {"TLSv1.2"};

    /* renamed from: a  reason: collision with root package name */
    final SSLSocketFactory f4070a;

    public a(SSLSocketFactory sSLSocketFactory) {
        this.f4070a = sSLSocketFactory;
    }

    public String[] getDefaultCipherSuites() {
        return this.f4070a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f4070a.getSupportedCipherSuites();
    }

    public Socket createSocket() throws IOException {
        return a(this.f4070a.createSocket());
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a(this.f4070a.createSocket());
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return a(this.f4070a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return a(this.f4070a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(this.f4070a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(this.f4070a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(f4069b);
        }
        return socket;
    }

    public static SocketFactory a() throws NoSuchAlgorithmException, KeyManagementException {
        if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT >= 22) {
            SSLContext instance = SSLContext.getInstance("TLS");
            a(instance);
            return instance.getSocketFactory();
        }
        SSLContext instance2 = SSLContext.getInstance("TLSv1.2");
        a(instance2);
        return new a(instance2.getSocketFactory());
    }

    private static void a(SSLContext sSLContext) throws KeyManagementException {
        sSLContext.init((KeyManager[]) null, new TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }}, new SecureRandom());
    }
}
