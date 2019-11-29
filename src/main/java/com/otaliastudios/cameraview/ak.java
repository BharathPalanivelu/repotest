package com.otaliastudios.cameraview;

import java.util.concurrent.CountDownLatch;

class ak<T> {

    /* renamed from: a  reason: collision with root package name */
    private CountDownLatch f15553a;

    /* renamed from: b  reason: collision with root package name */
    private T f15554b;

    /* renamed from: c  reason: collision with root package name */
    private int f15555c;

    ak() {
    }

    private boolean b() {
        return this.f15553a != null;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!b()) {
            this.f15555c++;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(T t) {
        int i = this.f15555c;
        if (i > 0) {
            this.f15555c = i - 1;
        } else if (b()) {
            this.f15554b = t;
            this.f15553a.countDown();
        }
    }
}
