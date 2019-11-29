package com.google.android.exoplayer2.s;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11394a;

    public synchronized boolean a() {
        if (this.f11394a) {
            return false;
        }
        this.f11394a = true;
        notifyAll();
        return true;
    }

    public synchronized boolean b() {
        boolean z;
        z = this.f11394a;
        this.f11394a = false;
        return z;
    }

    public synchronized void c() throws InterruptedException {
        while (!this.f11394a) {
            wait();
        }
    }
}
