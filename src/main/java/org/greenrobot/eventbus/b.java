package org.greenrobot.eventbus;

import java.util.logging.Level;

final class b implements Runnable, l {

    /* renamed from: a  reason: collision with root package name */
    private final k f33983a = new k();

    /* renamed from: b  reason: collision with root package name */
    private final c f33984b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f33985c;

    b(c cVar) {
        this.f33984b = cVar;
    }

    public void a(q qVar, Object obj) {
        j a2 = j.a(qVar, obj);
        synchronized (this) {
            this.f33983a.a(a2);
            if (!this.f33985c) {
                this.f33985c = true;
                this.f33984b.b().execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                j a2 = this.f33983a.a(1000);
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f33983a.a();
                        if (a2 == null) {
                            this.f33985c = false;
                            this.f33985c = false;
                            return;
                        }
                    }
                }
                this.f33984b.a(a2);
            } catch (InterruptedException e2) {
                try {
                    g c2 = this.f33984b.c();
                    Level level = Level.WARNING;
                    c2.a(level, Thread.currentThread().getName() + " was interruppted", e2);
                    return;
                } finally {
                    this.f33985c = false;
                }
            }
        }
    }
}
