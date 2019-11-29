package com.shopee.app.util.n;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f26450a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final String f26451b;

    public a(String str) {
        this.f26451b = str;
    }

    public void a() {
        if (b.f26452a) {
            this.f26450a = com.garena.android.appkit.tools.a.a.b();
        }
    }

    public void b() {
        if (b.f26452a) {
            long b2 = com.garena.android.appkit.tools.a.a.b() - this.f26450a;
            if (b2 > 250) {
                String str = this.f26451b;
                com.garena.reactpush.a.a.a(str, new RuntimeException(this.f26451b + " took " + b2 + "ms for onCreate. You may want to optimize this for smooth transition."));
            }
        }
    }
}
