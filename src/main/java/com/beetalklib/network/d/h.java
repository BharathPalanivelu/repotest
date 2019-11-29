package com.beetalklib.network.d;

import com.beetalklib.network.b.b;
import com.beetalklib.network.b.d;
import com.beetalklib.network.c.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class h {

    /* renamed from: b  reason: collision with root package name */
    private static int f5525b = 1;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f5526a;

    /* renamed from: c  reason: collision with root package name */
    private Socket f5527c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f5528d;

    /* renamed from: e  reason: collision with root package name */
    private OutputStream f5529e;

    /* renamed from: f  reason: collision with root package name */
    private String f5530f;

    /* renamed from: g  reason: collision with root package name */
    private int f5531g;
    private int h;
    private boolean i;
    private int j;

    public h(String str, int i2) {
        this(str, i2, false);
    }

    public h(String str, int i2, boolean z) {
        this.f5530f = str;
        this.f5531g = i2;
        this.j = 0;
        this.i = z;
    }

    public int a() {
        return this.h;
    }

    public void b() throws d {
        this.j = 2;
        try {
            InetAddress byName = InetAddress.getByName(this.f5530f);
            this.f5526a = byName.getAddress();
            int i2 = 1;
            if (this.i) {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init((KeyManager[]) null, new TrustManager[]{new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    }

                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }}, new SecureRandom());
                this.f5527c = instance.getSocketFactory().createSocket(byName, this.f5531g);
            } else {
                this.f5527c = new Socket(byName.getHostAddress(), this.f5531g);
                this.f5527c.setKeepAlive(true);
            }
            this.f5528d = this.f5527c.getInputStream();
            this.f5529e = this.f5527c.getOutputStream();
            if (!this.f5527c.isConnected()) {
                i2 = 0;
            }
            this.j = i2;
            a.b(this.f5527c.isConnected() ? "connection ok" : "connection fails", new Object[0]);
        } catch (KeyManagementException e2) {
            a.a(e2);
            throw new d(e2);
        } catch (NoSuchAlgorithmException e3) {
            a.a(e3);
            throw new d(e3);
        } catch (IOException e4) {
            a.a(e4);
            throw new d(e4);
        }
    }

    public void a(byte[] bArr) throws b {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i2, int i3) throws b {
        try {
            this.f5529e.write(bArr, i2, i3);
            this.f5529e.flush();
        } catch (Exception e2) {
            a.a(e2);
            e();
            throw new b(e2);
        }
    }

    public InputStream c() {
        return this.f5528d;
    }

    public boolean d() {
        return this.j == 1;
    }

    public boolean a(String str, int i2) {
        return this.f5530f.equals(str) && this.f5531g == i2;
    }

    public void e() {
        Socket socket = this.f5527c;
        if (socket != null) {
            try {
                socket.close();
                this.f5527c = null;
            } catch (IOException e2) {
                a.a(e2);
            } catch (Throwable th) {
                this.j = 0;
                throw th;
            }
            this.j = 0;
        }
    }
}
