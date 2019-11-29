package com.modiface.mfemakeupkit;

class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15338a;

    u(MFEMakeupEngine mFEMakeupEngine) {
        this.f15338a = mFEMakeupEngine;
    }

    public void run() {
        if (this.f15338a.mVideoRecorder != null) {
            this.f15338a.mVideoRecorder.c().c();
            this.f15338a.mVideoRecorder.e();
        }
    }
}
