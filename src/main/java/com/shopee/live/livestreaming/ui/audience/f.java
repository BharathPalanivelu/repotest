package com.shopee.live.livestreaming.ui.audience;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private boolean f29019a = false;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f29020b = new Runnable() {
        public final void run() {
            f.this.c();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private int f29021c = 5000;

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        c.c(com.shopee.live.livestreaming.util.f.a().s());
        if (this.f29019a) {
            com.garena.android.appkit.f.f.a().a(this.f29020b, this.f29021c);
        }
    }

    public void a(int i) {
        this.f29021c = i * 1000;
    }

    public void a() {
        b();
        this.f29019a = true;
        com.garena.android.appkit.f.f.a().a(this.f29020b);
    }

    public void b() {
        com.garena.android.appkit.f.f.a().b(this.f29020b);
        this.f29019a = false;
    }
}
