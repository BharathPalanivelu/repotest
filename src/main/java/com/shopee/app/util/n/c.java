package com.shopee.app.util.n;

import com.garena.android.appkit.tools.a.a;
import com.shopee.app.application.ar;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f26458a;

    /* renamed from: b  reason: collision with root package name */
    private long f26459b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f26460c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f26461d = 0;

    public c(String str) {
        this.f26458a = str;
    }

    public void a() {
        if (b.f26452a) {
            long b2 = a.b();
            long j = this.f26461d;
            if (j == 0) {
                this.f26461d = b2;
                return;
            }
            if (b2 - j < 500) {
                this.f26460c++;
            } else if (b2 - j > 2000) {
                this.f26460c = 0;
            }
            if (this.f26460c >= 7) {
                this.f26460c = 0;
                com.garena.reactpush.a.a.a(this.f26458a, new RuntimeException(this.f26458a + " has run multiple times in a short interval. You may want to check it."));
            }
            this.f26461d = b2;
        }
    }

    public void b() {
        if (b.f26452a) {
            this.f26459b = a.b();
        }
    }

    public void c() {
        if (b.f26452a) {
            com.garena.android.appkit.d.a.b("_PROCESSOR: " + this.f26458a, new Object[0]);
            long b2 = a.b() - this.f26459b;
            if (b2 > 600) {
                String str = this.f26458a;
                com.garena.reactpush.a.a.a(str, new RuntimeException(this.f26458a + " has a running time of " + b2 + "ms. You may want to optimize this."));
            }
        }
    }

    public void a(Exception exc) {
        if (b.f26452a) {
            com.garena.reactpush.a.a.a((Throwable) exc);
        }
        if (!b.b(exc)) {
            ar.f().e().fabricClient().a((Throwable) exc, "crash_from:Processor");
        }
    }
}
