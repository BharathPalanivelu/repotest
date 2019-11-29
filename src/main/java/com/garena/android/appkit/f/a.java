package com.garena.android.appkit.f;

public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f7671a = false;

    /* access modifiers changed from: protected */
    public abstract void a();

    public void run() {
        if (!d()) {
            a();
        }
    }

    public void b() {
        this.f7671a = true;
    }

    public void c() {
        this.f7671a = false;
    }

    private boolean d() {
        return this.f7671a;
    }
}
