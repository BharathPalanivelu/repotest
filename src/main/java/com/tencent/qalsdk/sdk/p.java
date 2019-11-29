package com.tencent.qalsdk.sdk;

final class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f32269a;

    p(m mVar) {
        this.f32269a = mVar;
    }

    public final void run() {
        if (this.f32269a.A != null && m.f32260a && !this.f32269a.u.get()) {
            new q(this, "QLogInitThread").start();
        }
    }
}
