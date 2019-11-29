package com.bca.xco.widget.d.a.a.e;

import com.bca.xco.widget.d.a.a.d.e;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;

public abstract class b {
    public abstract List<Certificate> a(List<Certificate> list, String str);

    public static b a(X509TrustManager x509TrustManager) {
        return e.b().a(x509TrustManager);
    }
}
