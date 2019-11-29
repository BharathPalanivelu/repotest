package io.a.a.a.a.e;

import io.a.a.a.c;
import io.a.a.a.l;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class h implements X509TrustManager {

    /* renamed from: a  reason: collision with root package name */
    private static final X509Certificate[] f33187a = new X509Certificate[0];

    /* renamed from: b  reason: collision with root package name */
    private final TrustManager[] f33188b;

    /* renamed from: c  reason: collision with root package name */
    private final i f33189c;

    /* renamed from: d  reason: collision with root package name */
    private final long f33190d;

    /* renamed from: e  reason: collision with root package name */
    private final List<byte[]> f33191e = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    private final Set<X509Certificate> f33192f = Collections.synchronizedSet(new HashSet());

    public h(i iVar, g gVar) {
        this.f33188b = a(iVar);
        this.f33189c = iVar;
        this.f33190d = gVar.d();
        for (String a2 : gVar.c()) {
            this.f33191e.add(a(a2));
        }
    }

    private TrustManager[] a(i iVar) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(iVar.f33193a);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        } catch (KeyStoreException e3) {
            throw new AssertionError(e3);
        }
    }

    private boolean a(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f33191e) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e2) {
            throw new CertificateException(e2);
        }
    }

    private void a(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        for (TrustManager trustManager : this.f33188b) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void a(X509Certificate[] x509CertificateArr) throws CertificateException {
        if (this.f33190d == -1 || System.currentTimeMillis() - this.f33190d <= 15552000000L) {
            X509Certificate[] a2 = a.a(x509CertificateArr, this.f33189c);
            int length = a2.length;
            int i = 0;
            while (i < length) {
                if (!a(a2[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        l h = c.h();
        h.d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f33190d) + " millis vs " + 15552000000L + " millis) falling back to system trust.");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.f33192f.contains(x509CertificateArr[0])) {
            a(x509CertificateArr, str);
            a(x509CertificateArr);
            this.f33192f.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f33187a;
    }

    private byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
