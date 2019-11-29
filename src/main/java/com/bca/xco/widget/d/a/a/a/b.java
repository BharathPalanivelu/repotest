package com.bca.xco.widget.d.a.a.a;

import com.bca.xco.widget.d.a.a.a;
import com.bca.xco.widget.d.a.n;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<n> f4743a;

    /* renamed from: b  reason: collision with root package name */
    private int f4744b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4745c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4746d;

    public b(List<n> list) {
        this.f4743a = list;
    }

    public n a(SSLSocket sSLSocket) {
        n nVar;
        int i = this.f4744b;
        int size = this.f4743a.size();
        while (true) {
            if (i >= size) {
                nVar = null;
                break;
            }
            nVar = this.f4743a.get(i);
            if (nVar.a(sSLSocket)) {
                this.f4744b = i + 1;
                break;
            }
            i++;
        }
        if (nVar != null) {
            this.f4745c = b(sSLSocket);
            a.f4741a.a(nVar, sSLSocket, this.f4746d);
            return nVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f4746d + ", modes=" + this.f4743a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.f4746d = true;
        if (!this.f4745c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z || (iOException instanceof SSLProtocolException)) {
            return true;
        }
        return false;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.f4744b; i < this.f4743a.size(); i++) {
            if (this.f4743a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
