package com.modiface.mfemakeupkit.a;

import java.util.concurrent.atomic.AtomicBoolean;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f15201a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ j f15202b;

    e(j jVar, AtomicBoolean atomicBoolean) {
        this.f15202b = jVar;
        this.f15201a = atomicBoolean;
    }

    public void run() {
        this.f15201a.set(this.f15202b.j.g());
    }
}
