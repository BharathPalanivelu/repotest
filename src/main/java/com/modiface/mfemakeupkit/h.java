package com.modiface.mfemakeupkit;

import com.modiface.mfemakeupkit.video.j;
import java.io.File;

class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ File f15314a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f15315b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15316c;

    h(MFEMakeupEngine mFEMakeupEngine, File file, boolean z) {
        this.f15316c = mFEMakeupEngine;
        this.f15314a = file;
        this.f15315b = z;
    }

    public void run() {
        if (this.f15316c.mVideoRecorder != null) {
            this.f15316c.mVideoRecorder.f();
            this.f15316c.mVideoRecorder.c().d();
            j unused = this.f15316c.mVideoRecorder = null;
        }
        j unused2 = this.f15316c.mVideoRecorder = new j(this.f15314a, this.f15315b);
    }
}
