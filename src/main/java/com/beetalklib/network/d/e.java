package com.beetalklib.network.d;

import com.beetalklib.network.b.c;
import com.beetalklib.network.c.a;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f5519a;

    /* renamed from: b  reason: collision with root package name */
    private final g f5520b;

    /* renamed from: c  reason: collision with root package name */
    private final h f5521c;

    public e(h hVar, g gVar, c cVar) {
        this.f5521c = hVar;
        this.f5520b = gVar;
        this.f5519a = cVar;
    }

    public void run() {
        try {
            a();
        } catch (Exception e2) {
            a.a(e2);
        }
    }

    private void a() {
        while (!Thread.interrupted()) {
            try {
                a(this.f5520b.a());
            } catch (c unused) {
                a.b("connection dropped", new Object[0]);
                if (!(!this.f5521c.d())) {
                    this.f5521c.e();
                }
                b();
                return;
            }
        }
    }

    private void a(f fVar) {
        this.f5519a.b(fVar);
    }

    private void b() {
        this.f5519a.a(this.f5521c.a());
    }
}
