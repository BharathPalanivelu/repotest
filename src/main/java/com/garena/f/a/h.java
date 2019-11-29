package com.garena.f.a;

import com.garena.f.b;
import com.garena.f.d;
import com.garena.f.g;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f7962a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f7963b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public d f7964c;

    /* renamed from: d  reason: collision with root package name */
    private b f7965d;

    /* renamed from: e  reason: collision with root package name */
    private final ScheduledExecutorService f7966e;

    public h(d dVar, b bVar, ScheduledExecutorService scheduledExecutorService) {
        this.f7964c = dVar;
        this.f7965d = bVar;
        this.f7966e = scheduledExecutorService;
    }

    public void a(boolean z) {
        this.f7962a = z;
        this.f7963b = false;
    }

    public boolean a() {
        return this.f7963b;
    }

    public void a(com.garena.h.a.d dVar) {
        boolean z = this.f7962a;
        this.f7963b = !z;
        if (!z) {
            g b2 = this.f7965d.b(dVar);
            this.f7963b = b2.b();
            if (this.f7963b) {
                this.f7966e.schedule(new Runnable() {
                    public void run() {
                        boolean unused = h.this.f7963b = false;
                        if (!h.this.f7962a) {
                            h.this.f7964c.c();
                        }
                    }
                }, (long) b2.a(), TimeUnit.MILLISECONDS);
            }
        }
    }
}
