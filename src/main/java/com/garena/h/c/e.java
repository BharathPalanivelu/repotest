package com.garena.h.c;

import com.garena.h.a.c;
import com.garena.h.b.a;
import com.garena.h.f;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f8031a;

    /* renamed from: b  reason: collision with root package name */
    private final f f8032b;

    /* renamed from: c  reason: collision with root package name */
    private final c f8033c;

    public e(a aVar, f fVar, c cVar) {
        this.f8031a = aVar;
        this.f8032b = fVar;
        this.f8033c = cVar;
    }

    public void run() {
        try {
            this.f8032b.a(this.f8031a.d());
            a();
        } catch (Exception unused) {
        }
    }

    private void a() {
        while (!Thread.interrupted()) {
            try {
                a(this.f8032b.a());
            } catch (c unused) {
                if (!(!this.f8031a.e())) {
                    this.f8031a.b();
                }
                b();
                return;
            }
        }
    }

    private void a(com.garena.h.e eVar) {
        this.f8033c.a(eVar);
    }

    private void b() {
        this.f8033c.a(this.f8031a.c());
    }
}
