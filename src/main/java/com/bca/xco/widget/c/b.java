package com.bca.xco.widget.c;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class b extends SSLSocketFactory {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f4699b = {"TLSv1.2"};

    /* renamed from: a  reason: collision with root package name */
    final SSLSocketFactory f4700a;

    public b(SSLSocketFactory sSLSocketFactory) {
        this.f4700a = sSLSocketFactory;
    }

    public String[] getDefaultCipherSuites() {
        return this.f4700a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f4700a.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return a(this.f4700a.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) {
        return a(this.f4700a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return a(this.f4700a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return a(this.f4700a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return a(this.f4700a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(f4699b);
        }
        return socket;
    }
}
