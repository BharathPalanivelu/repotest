package com.garena.f.a;

abstract class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7957a;

    public abstract void a();

    d() {
    }

    public void b() {
        this.f7957a = true;
    }

    public void run() {
        if (!this.f7957a) {
            a();
        }
    }
}
