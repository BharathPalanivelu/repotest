package com.modiface.mfemakeupkit;

import com.modiface.mfemakeupkit.video.j;

class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15325a;

    m(MFEMakeupEngine mFEMakeupEngine) {
        this.f15325a = mFEMakeupEngine;
    }

    public void run() {
        if (this.f15325a.mVideoRecorder != null) {
            this.f15325a.mVideoRecorder.f();
            this.f15325a.mVideoRecorder.c().d();
            j unused = this.f15325a.mVideoRecorder = null;
        }
    }
}
