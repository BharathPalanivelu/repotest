package com.google.android.exoplayer2.n;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10920a;

    public synchronized boolean a() {
        if (this.f10920a) {
            return false;
        }
        this.f10920a = true;
        notifyAll();
        return true;
    }

    public synchronized boolean b() {
        boolean z;
        z = this.f10920a;
        this.f10920a = false;
        return z;
    }

    public synchronized void c() throws InterruptedException {
        while (!this.f10920a) {
            wait();
        }
    }
}
