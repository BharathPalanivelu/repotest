package com.garena.h.b;

import com.garena.h.a.b;
import com.garena.h.a.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Socket f8005a;

    /* renamed from: b  reason: collision with root package name */
    private InputStream f8006b;

    /* renamed from: c  reason: collision with root package name */
    private OutputStream f8007c;

    /* renamed from: d  reason: collision with root package name */
    private String f8008d;

    /* renamed from: e  reason: collision with root package name */
    private int f8009e;

    /* renamed from: f  reason: collision with root package name */
    private String f8010f;

    /* renamed from: g  reason: collision with root package name */
    private int f8011g;
    private byte[] h;

    public a(String str, String str2, int i) {
        this.f8010f = str;
        this.f8008d = str2;
        this.f8009e = i;
        this.f8011g = 0;
        this.f8005a = new Socket();
    }

    public a(String str, String str2, int i, Socket socket) {
        this.f8010f = str;
        this.f8008d = str2;
        this.f8009e = i;
        this.f8011g = 0;
        this.f8005a = socket;
    }

    public void a() throws e {
        a(30000);
    }

    public void a(int i) throws e {
        this.f8011g = 2;
        try {
            InetAddress byName = InetAddress.getByName(this.f8008d);
            this.h = byName.getAddress();
            int i2 = 1;
            this.f8005a.setKeepAlive(true);
            if (!this.f8005a.isConnected()) {
                this.f8005a.connect(new InetSocketAddress(byName.getHostAddress(), this.f8009e), i);
            }
            this.f8006b = this.f8005a.getInputStream();
            this.f8007c = this.f8005a.getOutputStream();
            if (!this.f8005a.isConnected()) {
                i2 = 0;
            }
            this.f8011g = i2;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public void a(byte[] bArr) throws b {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i, int i2) throws b {
        try {
            this.f8007c.write(bArr, i, i2);
            this.f8007c.flush();
        } catch (Exception e2) {
            b();
            throw new b(e2);
        }
    }

    public void b() {
        Socket socket = this.f8005a;
        if (socket != null) {
            try {
                socket.close();
                this.f8005a = null;
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f8011g = 0;
                throw th;
            }
            this.f8011g = 0;
        }
    }

    public String c() {
        return this.f8010f;
    }

    public InputStream d() {
        return this.f8006b;
    }

    public boolean e() {
        return this.f8011g == 1;
    }
}
