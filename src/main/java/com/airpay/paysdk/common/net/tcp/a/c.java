package com.airpay.paysdk.common.net.tcp.a;

import com.airpay.paysdk.common.c.b;
import com.airpay.paysdk.common.net.tcp.b.a;
import com.airpay.paysdk.common.net.tcp.b.d;
import com.airpay.paysdk.common.net.tcp.b.f;
import com.airpay.paysdk.common.net.tcp.c.e;
import java.util.concurrent.locks.ReentrantLock;

public class c implements e {

    /* renamed from: a  reason: collision with root package name */
    private volatile d f4019a;

    /* renamed from: b  reason: collision with root package name */
    private e f4020b;

    /* renamed from: c  reason: collision with root package name */
    private a f4021c;

    /* renamed from: d  reason: collision with root package name */
    private b f4022d;

    /* renamed from: e  reason: collision with root package name */
    private final ReentrantLock f4023e = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    private volatile com.airpay.paysdk.common.net.tcp.f.a f4024f = com.airpay.paysdk.common.net.tcp.f.a.NULL;

    public c(String str, int i, boolean z, e eVar) {
        this.f4020b = eVar;
        this.f4022d = b.a(b.c.CACHE);
        this.f4019a = new d(str, i, z);
    }

    public synchronized void a() {
        if (this.f4019a != null && b()) {
            this.f4024f = com.airpay.paysdk.common.net.tcp.f.a.DISCONNECTED;
            if (this.f4021c != null) {
                this.f4021c.interrupt();
            }
        }
    }

    public void a(int i) {
        this.f4024f = com.airpay.paysdk.common.net.tcp.f.a.CONNECTING;
        try {
            this.f4019a.a();
            if (!c() || !this.f4019a.b()) {
                this.f4019a.c();
                a(i, 10008, "unable to init packet receiver");
                return;
            }
            b(i);
        } catch (com.airpay.paysdk.common.a.a e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            if (e2.a() != 10003) {
                this.f4019a.c();
                a(i, e2.a(), e2.b());
            }
        }
    }

    public void a(com.airpay.paysdk.common.net.tcp.b.e eVar) {
        if (this.f4019a != null) {
            try {
                this.f4023e.lock();
                this.f4019a.a(eVar);
            } catch (com.airpay.paysdk.common.a.a e2) {
                com.airpay.paysdk.common.b.a.a((Throwable) e2);
                this.f4019a.c();
                a(eVar.a().b(), e2.a(), e2.b());
            } catch (Throwable th) {
                this.f4023e.unlock();
                throw th;
            }
            this.f4023e.unlock();
        }
    }

    private boolean c() {
        if (this.f4022d.isShutdown() || this.f4022d.isTerminated()) {
            return false;
        }
        this.f4021c = new a(this.f4019a, new com.airpay.paysdk.common.net.tcp.d.b(this.f4019a.d()), this);
        this.f4022d.execute(this.f4021c);
        return true;
    }

    public void a(f fVar) {
        if (!b()) {
            a(fVar.a());
        }
        this.f4020b.a(fVar);
    }

    public void b(f fVar) {
        this.f4020b.b(fVar);
    }

    public void b(int i) {
        this.f4024f = com.airpay.paysdk.common.net.tcp.f.a.CONNECTED;
        this.f4020b.b(i);
    }

    public void a(int i, int i2, String str) {
        this.f4024f = com.airpay.paysdk.common.net.tcp.f.a.DISCONNECTED;
        this.f4020b.a(i, i2, str);
    }

    public boolean b() {
        return this.f4019a.b() && this.f4024f == com.airpay.paysdk.common.net.tcp.f.a.CONNECTED;
    }
}
