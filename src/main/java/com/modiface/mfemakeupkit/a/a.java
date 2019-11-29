package com.modiface.mfemakeupkit.a;

import com.modiface.mfemakeupkit.utils.MFEDebugInfo;

class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f15192a;

    a(j jVar) {
        this.f15192a = jVar;
    }

    public void run() {
        MFEDebugInfo mFEDebugInfo = new MFEDebugInfo("Face Tracker Initialization");
        this.f15192a.j.e(this.f15192a.q, this.f15192a.r, mFEDebugInfo);
        this.f15192a.m.addSubDebugInfo(mFEDebugInfo);
    }
}
