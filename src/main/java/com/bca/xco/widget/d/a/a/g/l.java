package com.bca.xco.widget.d.a.a.g;

import java.util.concurrent.CountDownLatch;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f5026a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    private long f5027b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f5028c = -1;

    l() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f5027b == -1) {
            this.f5027b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f5028c != -1 || this.f5027b == -1) {
            throw new IllegalStateException();
        }
        this.f5028c = System.nanoTime();
        this.f5026a.countDown();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f5028c == -1) {
            long j = this.f5027b;
            if (j != -1) {
                this.f5028c = j - 1;
                this.f5026a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
