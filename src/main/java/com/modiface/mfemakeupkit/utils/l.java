package com.modiface.mfemakeupkit.utils;

class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f15374a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f15375b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m f15376c;

    l(m mVar, Runnable runnable, Runnable runnable2) {
        this.f15376c = mVar;
        this.f15374a = runnable;
        this.f15375b = runnable2;
    }

    public void run() {
        if (this.f15376c.l) {
            this.f15374a.run();
            return;
        }
        Runnable runnable = this.f15375b;
        if (runnable != null) {
            runnable.run();
        }
    }
}
