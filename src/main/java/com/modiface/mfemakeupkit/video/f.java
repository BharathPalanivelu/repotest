package com.modiface.mfemakeupkit.video;

import com.modiface.mfemakeupkit.video.MFEVideoRecordingError;
import java.io.IOException;

class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f15425a;

    f(j jVar) {
        this.f15425a = jVar;
    }

    public void run() {
        this.f15425a.g();
        try {
            this.f15425a.i.a(this.f15425a.m.getAbsolutePath(), this.f15425a.o);
        } catch (IOException | IllegalArgumentException e2) {
            this.f15425a.p.add(new MFEVideoRecordingError(e2, MFEVideoRecordingError.Consequence.RecordingFailed));
        }
        if (!this.f15425a.f15435g.e()) {
            this.f15425a.i.a(false);
        }
    }
}
