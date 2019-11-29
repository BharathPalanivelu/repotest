package com.modiface.mfemakeupkit.utils;

class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f15366a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f15367b;

    i(m mVar, Runnable runnable) {
        this.f15367b = mVar;
        this.f15366a = runnable;
    }

    public void run() {
        Runnable runnable = this.f15366a;
        if (runnable != null) {
            runnable.run();
        }
        this.f15367b.c();
    }
}
