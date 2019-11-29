package com.modiface.mfemakeupkit.utils;

import java.util.concurrent.atomic.AtomicBoolean;

class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f15401a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f15402b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f15403c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ x f15404d;

    w(x xVar, Object obj, Runnable runnable, AtomicBoolean atomicBoolean) {
        this.f15404d = xVar;
        this.f15401a = obj;
        this.f15402b = runnable;
        this.f15403c = atomicBoolean;
    }

    public void run() {
        synchronized (this.f15401a) {
            this.f15402b.run();
            this.f15403c.set(true);
            this.f15401a.notify();
        }
    }
}
