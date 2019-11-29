package com.bca.xco.widget.c;

import android.content.Context;
import android.util.Base64;
import com.bca.xco.widget.d.a.s;
import com.bca.xco.widget.d.a.u;
import com.bca.xco.widget.e.b;
import com.bca.xco.widget.h;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private s f4694a;

    /* renamed from: b  reason: collision with root package name */
    private u f4695b = u.a(LiveAgentRequest.HEADER_ACCEPT_VALUE);

    /* renamed from: c  reason: collision with root package name */
    private b f4696c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f4697d;

    public a(Context context, String str) {
        this.f4694a = b(context);
        this.f4696c = new b();
        this.f4697d = str;
    }

    private TrustManager[] a(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(new String(Base64.decode(new BufferedInputStream(context.getAssets().open("signature/oneklik")).toString(), 0), "UTF-8").getBytes("UTF-8"));
            Certificate generateCertificate = instance.generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
            instance2.load((InputStream) null, (char[]) null);
            instance2.setCertificateEntry("ca", generateCertificate);
            TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance3.init(instance2);
            return instance3.getTrustManagers();
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            byteArrayInputStream.close();
            throw th;
        }
    }

    private s b(Context context) {
        try {
            SSLContext instance = SSLContext.getInstance("TLSv1.2");
            instance.init((KeyManager[]) null, a(context), new SecureRandom());
            SSLSocketFactory socketFactory = instance.getSocketFactory();
            s.a aVar = new s.a();
            aVar.a(socketFactory);
            aVar.a((HostnameVerifier) new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return str.equals(a.this.f4697d.equals("PRODUCTION") ? "oneklik.klikbca.com" : "202.6.215.226");
                }
            });
            Integer valueOf = Integer.valueOf(context.getResources().getString(h.f.xco_timeout_maxprogress));
            return a(aVar).a(true).a((long) valueOf.intValue(), TimeUnit.MILLISECONDS).b((long) valueOf.intValue(), TimeUnit.MILLISECONDS).a();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|4|5|(1:7)(1:8)|9) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0053 A[Catch:{ Exception -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x005d A[Catch:{ Exception -> 0x007e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bca.xco.widget.d.a.s.a a(com.bca.xco.widget.d.a.s.a r7) {
        /*
            r6 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            java.lang.String r2 = "TLSv1.2"
            r3 = 16
            if (r0 < r3) goto L_0x0065
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r2)     // Catch:{ Exception -> 0x004b }
            r3 = 0
            r0.init(r3, r3, r3)     // Catch:{ Exception -> 0x004b }
            com.bca.xco.widget.c.b r3 = new com.bca.xco.widget.c.b     // Catch:{ Exception -> 0x004b }
            javax.net.ssl.SSLSocketFactory r0 = r0.getSocketFactory()     // Catch:{ Exception -> 0x004b }
            r3.<init>(r0)     // Catch:{ Exception -> 0x004b }
            r7.a((javax.net.ssl.SSLSocketFactory) r3)     // Catch:{ Exception -> 0x004b }
            com.bca.xco.widget.d.a.n$a r0 = new com.bca.xco.widget.d.a.n$a     // Catch:{ Exception -> 0x004b }
            com.bca.xco.widget.d.a.n r3 = com.bca.xco.widget.d.a.n.f5090a     // Catch:{ Exception -> 0x004b }
            r0.<init>((com.bca.xco.widget.d.a.n) r3)     // Catch:{ Exception -> 0x004b }
            r3 = 1
            com.bca.xco.widget.d.a.ac[] r3 = new com.bca.xco.widget.d.a.ac[r3]     // Catch:{ Exception -> 0x004b }
            r4 = 0
            com.bca.xco.widget.d.a.ac r5 = com.bca.xco.widget.d.a.ac.TLS_1_2     // Catch:{ Exception -> 0x004b }
            r3[r4] = r5     // Catch:{ Exception -> 0x004b }
            com.bca.xco.widget.d.a.n$a r0 = r0.a((com.bca.xco.widget.d.a.ac[]) r3)     // Catch:{ Exception -> 0x004b }
            com.bca.xco.widget.d.a.n r0 = r0.a()     // Catch:{ Exception -> 0x004b }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x004b }
            r3.<init>()     // Catch:{ Exception -> 0x004b }
            r3.add(r0)     // Catch:{ Exception -> 0x004b }
            com.bca.xco.widget.d.a.n r0 = com.bca.xco.widget.d.a.n.f5091b     // Catch:{ Exception -> 0x004b }
            r3.add(r0)     // Catch:{ Exception -> 0x004b }
            com.bca.xco.widget.d.a.n r0 = com.bca.xco.widget.d.a.n.f5092c     // Catch:{ Exception -> 0x004b }
            r3.add(r0)     // Catch:{ Exception -> 0x004b }
            r7.a((java.util.List<com.bca.xco.widget.d.a.n>) r3)     // Catch:{ Exception -> 0x004b }
            goto L_0x007e
        L_0x004b:
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r2)     // Catch:{ Exception -> 0x007e }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x007e }
            if (r2 > r1) goto L_0x005d
            com.bca.xco.widget.c.b r1 = new com.bca.xco.widget.c.b     // Catch:{ Exception -> 0x007e }
            javax.net.ssl.SSLSocketFactory r0 = r0.getSocketFactory()     // Catch:{ Exception -> 0x007e }
            r1.<init>(r0)     // Catch:{ Exception -> 0x007e }
            goto L_0x0061
        L_0x005d:
            javax.net.ssl.SSLSocketFactory r1 = r0.getSocketFactory()     // Catch:{ Exception -> 0x007e }
        L_0x0061:
            r7.a((javax.net.ssl.SSLSocketFactory) r1)     // Catch:{ Exception -> 0x007e }
            goto L_0x007e
        L_0x0065:
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r2)     // Catch:{ Exception -> 0x007e }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x007e }
            if (r2 > r1) goto L_0x0077
            com.bca.xco.widget.c.b r1 = new com.bca.xco.widget.c.b     // Catch:{ Exception -> 0x007e }
            javax.net.ssl.SSLSocketFactory r0 = r0.getSocketFactory()     // Catch:{ Exception -> 0x007e }
            r1.<init>(r0)     // Catch:{ Exception -> 0x007e }
            goto L_0x007b
        L_0x0077:
            javax.net.ssl.SSLSocketFactory r1 = r0.getSocketFactory()     // Catch:{ Exception -> 0x007e }
        L_0x007b:
            r7.a((javax.net.ssl.SSLSocketFactory) r1)     // Catch:{ Exception -> 0x007e }
        L_0x007e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.c.a.a(com.bca.xco.widget.d.a.s$a):com.bca.xco.widget.d.a.s$a");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00bf, code lost:
        if (r12 != null) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00c1, code lost:
        if (r13 != null) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00c7, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x00bb, code lost:
        r14 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r12, com.bca.xco.widget.a.a r13, com.bca.xco.widget.a.b r14) {
        /*
            r11 = this;
            java.util.TreeMap r0 = new java.util.TreeMap
            r0.<init>()
            java.lang.String r1 = r14.i()
            java.lang.String r2 = "TransactionType"
            r0.put(r2, r1)
            java.lang.String r1 = r14.g()
            java.lang.String r2 = "XCOID"
            r0.put(r2, r1)
            java.lang.String r1 = r14.j()
            java.lang.String r2 = "MSISDNID"
            r0.put(r2, r1)
            java.lang.String r14 = r14.e()
            java.lang.String r1 = "MerchantID"
            r0.put(r1, r14)
            com.bca.xco.widget.e.d r14 = new com.bca.xco.widget.e.d
            r14.<init>()
            com.bca.xco.widget.d.a.u r1 = r11.f4695b
            java.lang.String r2 = r14.a(r0)
            com.bca.xco.widget.d.a.y r1 = com.bca.xco.widget.d.a.y.a((com.bca.xco.widget.d.a.u) r1, (java.lang.String) r2)
            com.bca.xco.widget.e.b r2 = r11.f4696c
            java.lang.String r2 = r2.a()
            com.bca.xco.widget.e.b r3 = r11.f4696c
            java.lang.String r4 = r13.d()
            java.lang.String r8 = r13.a()
            java.lang.String r9 = r14.a(r0)
            java.lang.String r5 = "POST"
            java.lang.String r6 = "/xco/otp"
            r7 = 0
            r10 = r2
            java.lang.String r14 = r3.a(r4, r5, r6, r7, r8, r9, r10)
            com.bca.xco.widget.d.a.x$a r0 = new com.bca.xco.widget.d.a.x$a
            r0.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Bearer "
            r3.append(r4)
            java.lang.String r4 = r13.a()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "Authorization"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r3 = r13.b()
            java.lang.String r4 = "Content-Type"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r13 = r13.c()
            java.lang.String r3 = "X-BCA-Key"
            com.bca.xco.widget.d.a.x$a r13 = r0.a((java.lang.String) r3, (java.lang.String) r13)
            java.lang.String r0 = "X-BCA-Timestamp"
            com.bca.xco.widget.d.a.x$a r13 = r13.a((java.lang.String) r0, (java.lang.String) r2)
            java.lang.String r0 = "X-BCA-Signature"
            com.bca.xco.widget.d.a.x$a r13 = r13.a((java.lang.String) r0, (java.lang.String) r14)
            com.bca.xco.widget.d.a.x$a r12 = r13.a((java.lang.String) r12)
            com.bca.xco.widget.d.a.x$a r12 = r12.a((com.bca.xco.widget.d.a.y) r1)
            com.bca.xco.widget.d.a.x r12 = r12.b()
            com.bca.xco.widget.d.a.s r13 = r11.f4694a
            com.bca.xco.widget.d.a.b r12 = r13.a((com.bca.xco.widget.d.a.x) r12)
            com.bca.xco.widget.d.a.z r12 = r12.a()
            r13 = 0
            com.bca.xco.widget.d.a.aa r14 = r12.e()     // Catch:{ Throwable -> 0x00bd }
            java.lang.String r13 = r14.e()     // Catch:{ Throwable -> 0x00bd }
            if (r12 == 0) goto L_0x00ba
            r12.close()
        L_0x00ba:
            return r13
        L_0x00bb:
            r14 = move-exception
            goto L_0x00bf
        L_0x00bd:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00bb }
        L_0x00bf:
            if (r12 == 0) goto L_0x00ca
            if (r13 == 0) goto L_0x00c7
            r12.close()     // Catch:{ Throwable -> 0x00ca }
            goto L_0x00ca
        L_0x00c7:
            r12.close()
        L_0x00ca:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.c.a.a(java.lang.String, com.bca.xco.widget.a.a, com.bca.xco.widget.a.b):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00b7, code lost:
        if (r12 != null) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00b9, code lost:
        if (r13 != null) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00bf, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x00b3, code lost:
        r14 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(java.lang.String r12, com.bca.xco.widget.a.a r13, com.bca.xco.widget.a.b r14) {
        /*
            r11 = this;
            java.util.TreeMap r0 = new java.util.TreeMap
            r0.<init>()
            java.lang.String r1 = r14.f()
            java.lang.String r2 = "OTP"
            r0.put(r2, r1)
            java.lang.String r14 = r14.g()
            java.lang.String r1 = "XCOID"
            r0.put(r1, r14)
            com.bca.xco.widget.e.d r14 = new com.bca.xco.widget.e.d
            r14.<init>()
            com.bca.xco.widget.d.a.u r1 = r11.f4695b
            java.lang.String r2 = r14.a(r0)
            com.bca.xco.widget.d.a.y r1 = com.bca.xco.widget.d.a.y.a((com.bca.xco.widget.d.a.u) r1, (java.lang.String) r2)
            com.bca.xco.widget.e.b r2 = r11.f4696c
            java.lang.String r2 = r2.a()
            com.bca.xco.widget.e.b r3 = r11.f4696c
            java.lang.String r4 = r13.d()
            java.lang.String r8 = r13.a()
            java.lang.String r9 = r14.a(r0)
            java.lang.String r5 = "PUT"
            java.lang.String r6 = "/xco/widget/credentials"
            r7 = 0
            r10 = r2
            java.lang.String r14 = r3.a(r4, r5, r6, r7, r8, r9, r10)
            com.bca.xco.widget.d.a.x$a r0 = new com.bca.xco.widget.d.a.x$a
            r0.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Bearer "
            r3.append(r4)
            java.lang.String r4 = r13.a()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "Authorization"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r3 = r13.b()
            java.lang.String r4 = "Content-Type"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r3 = r13.c()
            java.lang.String r4 = "X-BCA-Key"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r3 = "X-BCA-Timestamp"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r3, (java.lang.String) r2)
            java.lang.String r2 = "X-BCA-Signature"
            com.bca.xco.widget.d.a.x$a r14 = r0.a((java.lang.String) r2, (java.lang.String) r14)
            java.lang.String r13 = r13.e()
            java.lang.String r0 = "X-Client-DeviceInfo"
            com.bca.xco.widget.d.a.x$a r13 = r14.a((java.lang.String) r0, (java.lang.String) r13)
            com.bca.xco.widget.d.a.x$a r12 = r13.a((java.lang.String) r12)
            com.bca.xco.widget.d.a.x$a r12 = r12.b((com.bca.xco.widget.d.a.y) r1)
            com.bca.xco.widget.d.a.x r12 = r12.b()
            com.bca.xco.widget.d.a.s r13 = r11.f4694a
            com.bca.xco.widget.d.a.b r12 = r13.a((com.bca.xco.widget.d.a.x) r12)
            com.bca.xco.widget.d.a.z r12 = r12.a()
            r13 = 0
            com.bca.xco.widget.d.a.aa r14 = r12.e()     // Catch:{ Throwable -> 0x00b5 }
            java.lang.String r13 = r14.e()     // Catch:{ Throwable -> 0x00b5 }
            if (r12 == 0) goto L_0x00b2
            r12.close()
        L_0x00b2:
            return r13
        L_0x00b3:
            r14 = move-exception
            goto L_0x00b7
        L_0x00b5:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00b3 }
        L_0x00b7:
            if (r12 == 0) goto L_0x00c2
            if (r13 == 0) goto L_0x00bf
            r12.close()     // Catch:{ Throwable -> 0x00c2 }
            goto L_0x00c2
        L_0x00bf:
            r12.close()
        L_0x00c2:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.c.a.b(java.lang.String, com.bca.xco.widget.a.a, com.bca.xco.widget.a.b):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00c8, code lost:
        if (r12 != null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00ca, code lost:
        if (r13 != null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00d0, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x00c4, code lost:
        r14 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c(java.lang.String r12, com.bca.xco.widget.a.a r13, com.bca.xco.widget.a.b r14) {
        /*
            r11 = this;
            java.util.TreeMap r0 = new java.util.TreeMap
            r0.<init>()
            java.lang.String r1 = r14.c()
            java.lang.String r2 = "MaxLimit"
            r0.put(r2, r1)
            java.lang.String r1 = r14.a()
            java.lang.String r2 = "CredentialType"
            r0.put(r2, r1)
            java.lang.String r1 = r14.b()
            java.lang.String r2 = "CredentialNumber"
            r0.put(r2, r1)
            java.lang.String r1 = r14.e()
            java.lang.String r2 = "MerchantID"
            r0.put(r2, r1)
            java.lang.String r14 = r14.d()
            java.lang.String r1 = "CustomerIDMerchant"
            r0.put(r1, r14)
            com.bca.xco.widget.e.d r14 = new com.bca.xco.widget.e.d
            r14.<init>()
            com.bca.xco.widget.d.a.u r1 = r11.f4695b
            java.lang.String r2 = r14.a(r0)
            com.bca.xco.widget.d.a.y r1 = com.bca.xco.widget.d.a.y.a((com.bca.xco.widget.d.a.u) r1, (java.lang.String) r2)
            com.bca.xco.widget.e.b r2 = r11.f4696c
            java.lang.String r2 = r2.a()
            com.bca.xco.widget.e.b r3 = r11.f4696c
            java.lang.String r4 = r13.d()
            java.lang.String r8 = r13.a()
            java.lang.String r9 = r14.a(r0)
            java.lang.String r5 = "POST"
            java.lang.String r6 = "/xco/widget/credentials"
            r7 = 0
            r10 = r2
            java.lang.String r14 = r3.a(r4, r5, r6, r7, r8, r9, r10)
            com.bca.xco.widget.d.a.x$a r0 = new com.bca.xco.widget.d.a.x$a
            r0.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Bearer "
            r3.append(r4)
            java.lang.String r4 = r13.a()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "Authorization"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r3 = r13.b()
            java.lang.String r4 = "Content-Type"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r13 = r13.c()
            java.lang.String r3 = "X-BCA-Key"
            com.bca.xco.widget.d.a.x$a r13 = r0.a((java.lang.String) r3, (java.lang.String) r13)
            java.lang.String r0 = "X-BCA-Timestamp"
            com.bca.xco.widget.d.a.x$a r13 = r13.a((java.lang.String) r0, (java.lang.String) r2)
            java.lang.String r0 = "X-BCA-Signature"
            com.bca.xco.widget.d.a.x$a r13 = r13.a((java.lang.String) r0, (java.lang.String) r14)
            com.bca.xco.widget.d.a.x$a r12 = r13.a((java.lang.String) r12)
            com.bca.xco.widget.d.a.x$a r12 = r12.a((com.bca.xco.widget.d.a.y) r1)
            com.bca.xco.widget.d.a.x r12 = r12.b()
            com.bca.xco.widget.d.a.s r13 = r11.f4694a
            com.bca.xco.widget.d.a.b r12 = r13.a((com.bca.xco.widget.d.a.x) r12)
            com.bca.xco.widget.d.a.z r12 = r12.a()
            r13 = 0
            com.bca.xco.widget.d.a.aa r14 = r12.e()     // Catch:{ Throwable -> 0x00c6 }
            java.lang.String r13 = r14.e()     // Catch:{ Throwable -> 0x00c6 }
            if (r12 == 0) goto L_0x00c3
            r12.close()
        L_0x00c3:
            return r13
        L_0x00c4:
            r14 = move-exception
            goto L_0x00c8
        L_0x00c6:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00c4 }
        L_0x00c8:
            if (r12 == 0) goto L_0x00d3
            if (r13 == 0) goto L_0x00d0
            r12.close()     // Catch:{ Throwable -> 0x00d3 }
            goto L_0x00d3
        L_0x00d0:
            r12.close()
        L_0x00d3:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.c.a.c(java.lang.String, com.bca.xco.widget.a.a, com.bca.xco.widget.a.b):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0097, code lost:
        if (r10 != null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0099, code lost:
        if (r11 != null) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x009f, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0093, code lost:
        r12 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String d(java.lang.String r10, com.bca.xco.widget.a.a r11, com.bca.xco.widget.a.b r12) {
        /*
            r9 = this;
            com.bca.xco.widget.e.b r0 = r9.f4696c
            java.lang.String r0 = r0.a()
            com.bca.xco.widget.e.b r1 = r9.f4696c
            java.lang.String r2 = r11.d()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "/xco/merchants/"
            r3.append(r4)
            java.lang.String r12 = r12.e()
            r3.append(r12)
            java.lang.String r4 = r3.toString()
            java.lang.String r6 = r11.a()
            java.lang.String r3 = "GET"
            r5 = 0
            r7 = 0
            r8 = r0
            java.lang.String r12 = r1.a(r2, r3, r4, r5, r6, r7, r8)
            com.bca.xco.widget.d.a.x$a r1 = new com.bca.xco.widget.d.a.x$a
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Bearer "
            r2.append(r3)
            java.lang.String r3 = r11.a()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Authorization"
            com.bca.xco.widget.d.a.x$a r1 = r1.a((java.lang.String) r3, (java.lang.String) r2)
            java.lang.String r2 = r11.b()
            java.lang.String r3 = "Content-Type"
            com.bca.xco.widget.d.a.x$a r1 = r1.a((java.lang.String) r3, (java.lang.String) r2)
            java.lang.String r11 = r11.c()
            java.lang.String r2 = "X-BCA-Key"
            com.bca.xco.widget.d.a.x$a r11 = r1.a((java.lang.String) r2, (java.lang.String) r11)
            java.lang.String r1 = "X-BCA-Timestamp"
            com.bca.xco.widget.d.a.x$a r11 = r11.a((java.lang.String) r1, (java.lang.String) r0)
            java.lang.String r0 = "X-BCA-Signature"
            com.bca.xco.widget.d.a.x$a r11 = r11.a((java.lang.String) r0, (java.lang.String) r12)
            com.bca.xco.widget.d.a.x$a r10 = r11.a((java.lang.String) r10)
            com.bca.xco.widget.d.a.x$a r10 = r10.a()
            com.bca.xco.widget.d.a.x r10 = r10.b()
            com.bca.xco.widget.d.a.s r11 = r9.f4694a
            com.bca.xco.widget.d.a.b r10 = r11.a((com.bca.xco.widget.d.a.x) r10)
            com.bca.xco.widget.d.a.z r10 = r10.a()
            r11 = 0
            com.bca.xco.widget.d.a.aa r12 = r10.e()     // Catch:{ Throwable -> 0x0095 }
            java.lang.String r11 = r12.e()     // Catch:{ Throwable -> 0x0095 }
            if (r10 == 0) goto L_0x0092
            r10.close()
        L_0x0092:
            return r11
        L_0x0093:
            r12 = move-exception
            goto L_0x0097
        L_0x0095:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0093 }
        L_0x0097:
            if (r10 == 0) goto L_0x00a2
            if (r11 == 0) goto L_0x009f
            r10.close()     // Catch:{ Throwable -> 0x00a2 }
            goto L_0x00a2
        L_0x009f:
            r10.close()
        L_0x00a2:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.c.a.d(java.lang.String, com.bca.xco.widget.a.a, com.bca.xco.widget.a.b):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0093, code lost:
        if (r10 != null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0095, code lost:
        if (r11 != null) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x009b, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x008f, code lost:
        r12 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String e(java.lang.String r10, com.bca.xco.widget.a.a r11, com.bca.xco.widget.a.b r12) {
        /*
            r9 = this;
            com.bca.xco.widget.e.b r0 = r9.f4696c
            java.lang.String r0 = r0.a()
            com.bca.xco.widget.e.b r1 = r9.f4696c
            java.lang.String r2 = r11.d()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "/xco/credentials/details/"
            r3.append(r4)
            java.lang.String r12 = r12.g()
            r3.append(r12)
            java.lang.String r4 = r3.toString()
            java.lang.String r6 = r11.a()
            java.lang.String r3 = "GET"
            r5 = 0
            r7 = 0
            r8 = r0
            java.lang.String r12 = r1.a(r2, r3, r4, r5, r6, r7, r8)
            com.bca.xco.widget.d.a.x$a r1 = new com.bca.xco.widget.d.a.x$a
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Bearer "
            r2.append(r3)
            java.lang.String r3 = r11.a()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Authorization"
            com.bca.xco.widget.d.a.x$a r1 = r1.a((java.lang.String) r3, (java.lang.String) r2)
            java.lang.String r2 = r11.b()
            java.lang.String r3 = "Content-Type"
            com.bca.xco.widget.d.a.x$a r1 = r1.a((java.lang.String) r3, (java.lang.String) r2)
            java.lang.String r11 = r11.c()
            java.lang.String r2 = "X-BCA-Key"
            com.bca.xco.widget.d.a.x$a r11 = r1.a((java.lang.String) r2, (java.lang.String) r11)
            java.lang.String r1 = "X-BCA-Timestamp"
            com.bca.xco.widget.d.a.x$a r11 = r11.a((java.lang.String) r1, (java.lang.String) r0)
            java.lang.String r0 = "X-BCA-Signature"
            com.bca.xco.widget.d.a.x$a r11 = r11.a((java.lang.String) r0, (java.lang.String) r12)
            com.bca.xco.widget.d.a.x$a r10 = r11.a((java.lang.String) r10)
            com.bca.xco.widget.d.a.x r10 = r10.b()
            com.bca.xco.widget.d.a.s r11 = r9.f4694a
            com.bca.xco.widget.d.a.b r10 = r11.a((com.bca.xco.widget.d.a.x) r10)
            com.bca.xco.widget.d.a.z r10 = r10.a()
            r11 = 0
            com.bca.xco.widget.d.a.aa r12 = r10.e()     // Catch:{ Throwable -> 0x0091 }
            java.lang.String r11 = r12.e()     // Catch:{ Throwable -> 0x0091 }
            if (r10 == 0) goto L_0x008e
            r10.close()
        L_0x008e:
            return r11
        L_0x008f:
            r12 = move-exception
            goto L_0x0093
        L_0x0091:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x008f }
        L_0x0093:
            if (r10 == 0) goto L_0x009e
            if (r11 == 0) goto L_0x009b
            r10.close()     // Catch:{ Throwable -> 0x009e }
            goto L_0x009e
        L_0x009b:
            r10.close()
        L_0x009e:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.c.a.e(java.lang.String, com.bca.xco.widget.a.a, com.bca.xco.widget.a.b):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00b6, code lost:
        if (r12 != null) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00b8, code lost:
        if (r13 != null) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00be, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x00b2, code lost:
        r14 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String f(java.lang.String r12, com.bca.xco.widget.a.a r13, com.bca.xco.widget.a.b r14) {
        /*
            r11 = this;
            java.util.TreeMap r0 = new java.util.TreeMap
            r0.<init>()
            java.lang.String r1 = r14.g()
            java.lang.String r2 = "XCOID"
            r0.put(r2, r1)
            java.lang.String r1 = r14.c()
            java.lang.String r2 = "MaxLimit"
            r0.put(r2, r1)
            java.lang.String r14 = r14.e()
            java.lang.String r1 = "MerchantID"
            r0.put(r1, r14)
            com.bca.xco.widget.e.d r14 = new com.bca.xco.widget.e.d
            r14.<init>()
            com.bca.xco.widget.d.a.u r1 = r11.f4695b
            java.lang.String r2 = r14.a(r0)
            com.bca.xco.widget.d.a.y r1 = com.bca.xco.widget.d.a.y.a((com.bca.xco.widget.d.a.u) r1, (java.lang.String) r2)
            com.bca.xco.widget.e.b r2 = r11.f4696c
            java.lang.String r2 = r2.a()
            com.bca.xco.widget.e.b r3 = r11.f4696c
            java.lang.String r4 = r13.d()
            java.lang.String r8 = r13.a()
            java.lang.String r9 = r14.a(r0)
            java.lang.String r5 = "POST"
            java.lang.String r6 = "/xco/credentials/limits"
            r7 = 0
            r10 = r2
            java.lang.String r14 = r3.a(r4, r5, r6, r7, r8, r9, r10)
            com.bca.xco.widget.d.a.x$a r0 = new com.bca.xco.widget.d.a.x$a
            r0.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Bearer "
            r3.append(r4)
            java.lang.String r4 = r13.a()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "Authorization"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r3 = r13.b()
            java.lang.String r4 = "Content-Type"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r13 = r13.c()
            java.lang.String r3 = "X-BCA-Key"
            com.bca.xco.widget.d.a.x$a r13 = r0.a((java.lang.String) r3, (java.lang.String) r13)
            java.lang.String r0 = "X-BCA-Timestamp"
            com.bca.xco.widget.d.a.x$a r13 = r13.a((java.lang.String) r0, (java.lang.String) r2)
            java.lang.String r0 = "X-BCA-Signature"
            com.bca.xco.widget.d.a.x$a r13 = r13.a((java.lang.String) r0, (java.lang.String) r14)
            com.bca.xco.widget.d.a.x$a r12 = r13.a((java.lang.String) r12)
            com.bca.xco.widget.d.a.x$a r12 = r12.a((com.bca.xco.widget.d.a.y) r1)
            com.bca.xco.widget.d.a.x r12 = r12.b()
            com.bca.xco.widget.d.a.s r13 = r11.f4694a
            com.bca.xco.widget.d.a.b r12 = r13.a((com.bca.xco.widget.d.a.x) r12)
            com.bca.xco.widget.d.a.z r12 = r12.a()
            r13 = 0
            com.bca.xco.widget.d.a.aa r14 = r12.e()     // Catch:{ Throwable -> 0x00b4 }
            java.lang.String r13 = r14.e()     // Catch:{ Throwable -> 0x00b4 }
            if (r12 == 0) goto L_0x00b1
            r12.close()
        L_0x00b1:
            return r13
        L_0x00b2:
            r14 = move-exception
            goto L_0x00b6
        L_0x00b4:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00b2 }
        L_0x00b6:
            if (r12 == 0) goto L_0x00c1
            if (r13 == 0) goto L_0x00be
            r12.close()     // Catch:{ Throwable -> 0x00c1 }
            goto L_0x00c1
        L_0x00be:
            r12.close()
        L_0x00c1:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.c.a.f(java.lang.String, com.bca.xco.widget.a.a, com.bca.xco.widget.a.b):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00c9, code lost:
        if (r12 != null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00cb, code lost:
        if (r13 != null) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00d1, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x00c5, code lost:
        r14 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String g(java.lang.String r12, com.bca.xco.widget.a.a r13, com.bca.xco.widget.a.b r14) {
        /*
            r11 = this;
            java.util.TreeMap r0 = new java.util.TreeMap
            r0.<init>()
            java.lang.String r1 = r14.g()
            java.lang.String r2 = "XCOID"
            r0.put(r2, r1)
            java.lang.String r1 = r14.c()
            java.lang.String r2 = "MaxLimit"
            r0.put(r2, r1)
            java.lang.String r1 = r14.e()
            java.lang.String r2 = "MerchantID"
            r0.put(r2, r1)
            java.lang.String r14 = r14.f()
            java.lang.String r1 = "OTP"
            r0.put(r1, r14)
            com.bca.xco.widget.e.d r14 = new com.bca.xco.widget.e.d
            r14.<init>()
            com.bca.xco.widget.d.a.u r1 = r11.f4695b
            java.lang.String r2 = r14.a(r0)
            com.bca.xco.widget.d.a.y r1 = com.bca.xco.widget.d.a.y.a((com.bca.xco.widget.d.a.u) r1, (java.lang.String) r2)
            com.bca.xco.widget.e.b r2 = r11.f4696c
            java.lang.String r2 = r2.a()
            com.bca.xco.widget.e.b r3 = r11.f4696c
            java.lang.String r4 = r13.d()
            java.lang.String r8 = r13.a()
            java.lang.String r9 = r14.a(r0)
            java.lang.String r5 = "PUT"
            java.lang.String r6 = "/xco/credentials/limits"
            r7 = 0
            r10 = r2
            java.lang.String r14 = r3.a(r4, r5, r6, r7, r8, r9, r10)
            com.bca.xco.widget.d.a.x$a r0 = new com.bca.xco.widget.d.a.x$a
            r0.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Bearer "
            r3.append(r4)
            java.lang.String r4 = r13.a()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "Authorization"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r3 = r13.b()
            java.lang.String r4 = "Content-Type"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r3 = r13.c()
            java.lang.String r4 = "X-BCA-Key"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r3 = "X-BCA-Timestamp"
            com.bca.xco.widget.d.a.x$a r0 = r0.a((java.lang.String) r3, (java.lang.String) r2)
            java.lang.String r2 = "X-BCA-Signature"
            com.bca.xco.widget.d.a.x$a r14 = r0.a((java.lang.String) r2, (java.lang.String) r14)
            java.lang.String r13 = r13.e()
            java.lang.String r0 = "X-Client-DeviceInfo"
            com.bca.xco.widget.d.a.x$a r13 = r14.a((java.lang.String) r0, (java.lang.String) r13)
            com.bca.xco.widget.d.a.x$a r12 = r13.a((java.lang.String) r12)
            com.bca.xco.widget.d.a.x$a r12 = r12.b((com.bca.xco.widget.d.a.y) r1)
            com.bca.xco.widget.d.a.x r12 = r12.b()
            com.bca.xco.widget.d.a.s r13 = r11.f4694a
            com.bca.xco.widget.d.a.b r12 = r13.a((com.bca.xco.widget.d.a.x) r12)
            com.bca.xco.widget.d.a.z r12 = r12.a()
            r13 = 0
            com.bca.xco.widget.d.a.aa r14 = r12.e()     // Catch:{ Throwable -> 0x00c7 }
            java.lang.String r13 = r14.e()     // Catch:{ Throwable -> 0x00c7 }
            if (r12 == 0) goto L_0x00c4
            r12.close()
        L_0x00c4:
            return r13
        L_0x00c5:
            r14 = move-exception
            goto L_0x00c9
        L_0x00c7:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00c5 }
        L_0x00c9:
            if (r12 == 0) goto L_0x00d4
            if (r13 == 0) goto L_0x00d1
            r12.close()     // Catch:{ Throwable -> 0x00d4 }
            goto L_0x00d4
        L_0x00d1:
            r12.close()
        L_0x00d4:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.c.a.g(java.lang.String, com.bca.xco.widget.a.a, com.bca.xco.widget.a.b):java.lang.String");
    }
}
