package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.c;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final ac f5115a;

    /* renamed from: b  reason: collision with root package name */
    private final l f5116b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f5117c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Certificate> f5118d;

    private q(ac acVar, l lVar, List<Certificate> list, List<Certificate> list2) {
        this.f5115a = acVar;
        this.f5116b = lVar;
        this.f5117c = list;
        this.f5118d = list2;
    }

    public static q a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            l a2 = l.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                ac a3 = ac.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = c.a((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = c.a((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new q(a3, a2, list, list2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public l a() {
        return this.f5116b;
    }

    public List<Certificate> b() {
        return this.f5117c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (!c.a((Object) this.f5116b, (Object) qVar.f5116b) || !this.f5116b.equals(qVar.f5116b) || !this.f5117c.equals(qVar.f5117c) || !this.f5118d.equals(qVar.f5118d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        ac acVar = this.f5115a;
        return ((((((527 + (acVar != null ? acVar.hashCode() : 0)) * 31) + this.f5116b.hashCode()) * 31) + this.f5117c.hashCode()) * 31) + this.f5118d.hashCode();
    }
}
