package com.bca.xco.widget.d.a.a.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public abstract class e {
    public abstract X509Certificate a(X509Certificate x509Certificate);

    public static e a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new a(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return a(x509TrustManager.getAcceptedIssuers());
        }
    }

    public static e a(X509Certificate... x509CertificateArr) {
        return new b(x509CertificateArr);
    }

    static final class a extends e {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f4867a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f4868b;

        a(X509TrustManager x509TrustManager, Method method) {
            this.f4868b = method;
            this.f4867a = x509TrustManager;
        }

        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f4868b.invoke(this.f4867a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                return null;
            }
        }
    }

    static final class b extends e {

        /* renamed from: a  reason: collision with root package name */
        private final Map<X500Principal, List<X509Certificate>> f4869a = new LinkedHashMap();

        public b(X509Certificate... x509CertificateArr) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                List list = this.f4869a.get(subjectX500Principal);
                if (list == null) {
                    list = new ArrayList(1);
                    this.f4869a.put(subjectX500Principal, list);
                }
                list.add(x509Certificate);
            }
        }

        public X509Certificate a(X509Certificate x509Certificate) {
            List<X509Certificate> list = this.f4869a.get(x509Certificate.getIssuerX500Principal());
            if (list == null) {
                return null;
            }
            for (X509Certificate x509Certificate2 : list) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }
}
