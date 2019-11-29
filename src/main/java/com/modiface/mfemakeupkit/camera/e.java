package com.modiface.mfemakeupkit.camera;

import android.os.Handler;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f15270a;

    e(f fVar) {
        this.f15270a = fVar;
    }

    public void run() {
        Handler b2 = this.f15270a.f15275e.j.b();
        if (b2 != null) {
            b2.sendEmptyMessage(13);
        }
    }
}
