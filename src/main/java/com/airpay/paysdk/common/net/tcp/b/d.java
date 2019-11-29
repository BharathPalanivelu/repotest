package com.airpay.paysdk.common.net.tcp.b;

import com.airpay.paysdk.common.a.a;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private Socket f4049a;

    /* renamed from: b  reason: collision with root package name */
    private InputStream f4050b;

    /* renamed from: c  reason: collision with root package name */
    private OutputStream f4051c;

    /* renamed from: d  reason: collision with root package name */
    private volatile String f4052d;

    /* renamed from: e  reason: collision with root package name */
    private volatile int f4053e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f4054f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f4055g;

    public d(String str, int i, boolean z) {
        this.f4052d = str;
        this.f4053e = i;
        this.f4054f = z;
    }

    public void a() throws a {
        if (b()) {
            new a((int) IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE, "tcp is connected !");
        }
        try {
            InetAddress byName = InetAddress.getByName(this.f4052d);
            this.f4055g = byName.getAddress();
            if (this.f4054f) {
                this.f4049a = com.airpay.paysdk.common.net.tcp.e.a.a().createSocket();
                this.f4049a.setKeepAlive(true);
                this.f4049a.connect(new InetSocketAddress(byName.getHostAddress(), this.f4053e), 5000);
            } else {
                this.f4049a = new Socket();
                this.f4049a.setKeepAlive(true);
                this.f4049a.connect(new InetSocketAddress(byName.getHostAddress(), this.f4053e), 5000);
            }
            this.f4050b = this.f4049a.getInputStream();
            this.f4051c = this.f4049a.getOutputStream();
        } catch (UnknownHostException e2) {
            throw new a(10002, (Throwable) e2);
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e3) {
            throw new a(10000, e3);
        }
    }

    public void a(e eVar) throws a {
        try {
            byte[] b2 = eVar.b();
            this.f4051c.write(b2, 0, b2.length);
            this.f4051c.flush();
        } catch (Exception e2) {
            throw new a(10001, (Throwable) e2);
        }
    }

    public boolean b() {
        Socket socket = this.f4049a;
        return socket != null && socket.isConnected() && !this.f4049a.isClosed();
    }

    public void c() {
        Socket socket = this.f4049a;
        if (socket != null) {
            try {
                socket.close();
                this.f4049a = null;
            } catch (IOException unused) {
            }
        }
    }

    public InputStream d() {
        return this.f4050b;
    }
}
