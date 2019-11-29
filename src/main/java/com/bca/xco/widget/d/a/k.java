package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.b.h;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f5067a = new a().a();

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f5068b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bca.xco.widget.d.a.a.e.b f5069c;

    private k(List<b> list, com.bca.xco.widget.d.a.a.e.b bVar) {
        this.f5068b = list;
        this.f5069c = bVar;
    }

    public void a(String str, List<Certificate> list) {
        List<b> a2 = a(str);
        if (!a2.isEmpty()) {
            com.bca.xco.widget.d.a.a.e.b bVar = this.f5069c;
            if (bVar != null) {
                list = bVar.a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a2.size();
                h hVar = null;
                h hVar2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar2 = a2.get(i2);
                    if (bVar2.f5073c.equals("sha256/")) {
                        if (hVar == null) {
                            hVar = b(x509Certificate);
                        }
                        if (bVar2.f5074d.equals(hVar)) {
                            return;
                        }
                    } else if (bVar2.f5073c.equals("sha1/")) {
                        if (hVar2 == null) {
                            hVar2 = a(x509Certificate);
                        }
                        if (bVar2.f5074d.equals(hVar2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(a((Certificate) x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = a2.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sb.append("\n    ");
                sb.append(a2.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b next : this.f5068b) {
            if (next.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    /* access modifiers changed from: package-private */
    public k a(com.bca.xco.widget.d.a.a.e.b bVar) {
        return this.f5069c != bVar ? new k(this.f5068b, bVar) : this;
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static h a(X509Certificate x509Certificate) {
        return c.a(h.a(x509Certificate.getPublicKey().getEncoded()));
    }

    static h b(X509Certificate x509Certificate) {
        return c.b(h.a(x509Certificate.getPublicKey().getEncoded()));
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f5071a;

        /* renamed from: b  reason: collision with root package name */
        final String f5072b;

        /* renamed from: c  reason: collision with root package name */
        final String f5073c;

        /* renamed from: d  reason: collision with root package name */
        final h f5074d;

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            if (!this.f5071a.startsWith("*.")) {
                return str.equals(this.f5072b);
            }
            String str2 = this.f5072b;
            return str.regionMatches(false, str.indexOf(46) + 1, str2, 0, str2.length());
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f5071a.equals(bVar.f5071a) && this.f5073c.equals(bVar.f5073c) && this.f5074d.equals(bVar.f5074d);
            }
        }

        public int hashCode() {
            return ((((527 + this.f5071a.hashCode()) * 31) + this.f5073c.hashCode()) * 31) + this.f5074d.hashCode();
        }

        public String toString() {
            return this.f5073c + this.f5074d.b();
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f5070a = new ArrayList();

        public k a() {
            return new k(c.a(this.f5070a), (com.bca.xco.widget.d.a.a.e.b) null);
        }
    }
}
