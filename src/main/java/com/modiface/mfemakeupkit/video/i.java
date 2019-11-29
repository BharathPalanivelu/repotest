package com.modiface.mfemakeupkit.video;

import com.modiface.mfemakeupkit.video.MFEVideoRecordingError;

class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f15428a;

    i(j jVar) {
        this.f15428a = jVar;
    }

    public void run() {
        this.f15428a.f15432d.b().removeMessages(52);
        this.f15428a.f15432d.b().removeMessages(51);
        try {
            this.f15428a.f15434f.g();
        } catch (IllegalStateException e2) {
            this.f15428a.p.add(new MFEVideoRecordingError(e2, new MFEVideoRecordingError.Consequence[0]));
        }
        this.f15428a.j();
        this.f15428a.h();
        this.f15428a.i.b();
        j jVar = this.f15428a;
        jVar.n = jVar.i.a();
    }
}
