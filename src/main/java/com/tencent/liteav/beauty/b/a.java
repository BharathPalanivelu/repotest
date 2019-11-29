package com.tencent.liteav.beauty.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f31495a = false;

    public synchronized void a() {
        this.f31495a = true;
        notify();
    }

    public synchronized void b() throws InterruptedException {
        while (!this.f31495a) {
            wait();
        }
        this.f31495a = false;
    }
}
