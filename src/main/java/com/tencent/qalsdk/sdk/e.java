package com.tencent.qalsdk.sdk;

import com.tencent.qalsdk.util.QLog;

final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ r f32242a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ d f32243b;

    e(d dVar, r rVar) {
        this.f32243b = dVar;
        this.f32242a = rVar;
    }

    public final void run() {
        if (!this.f32243b.f32241a.b(this.f32242a.f32272b)) {
            QLog.e("CoreWrapper", 1, "unknown push:" + this.f32242a.f32272b);
        }
    }
}
