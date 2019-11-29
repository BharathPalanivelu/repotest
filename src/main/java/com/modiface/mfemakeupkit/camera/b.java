package com.modiface.mfemakeupkit.camera;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f15263a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AtomicInteger f15264b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i f15265c;

    b(i iVar, AtomicReference atomicReference, AtomicInteger atomicInteger) {
        this.f15265c = iVar;
        this.f15263a = atomicReference;
        this.f15264b = atomicInteger;
    }

    public void run() {
        Handler b2 = this.f15265c.j.b();
        if (b2 != null) {
            b2.removeMessages(11);
            b2.removeMessages(12);
            b2.removeMessages(13);
        }
        this.f15263a.set(this.f15265c.p);
        SurfaceTexture unused = this.f15265c.p = null;
        this.f15264b.set(this.f15265c.q[0]);
        this.f15265c.q[0] = 0;
    }
}
