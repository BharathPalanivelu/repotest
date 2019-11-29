package com.modiface.mfemakeupkit.a;

import com.modiface.mfemakeupkit.a.j;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;

class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j.a f15197a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ j f15198b;

    c(j jVar, j.a aVar) {
        this.f15198b = jVar;
        this.f15197a = aVar;
    }

    public void run() {
        if (!this.f15198b.j.g()) {
            MFEDebugInfo mFEDebugInfo = new MFEDebugInfo("Face Tracker Initialization");
            this.f15198b.j.e(this.f15198b.q, this.f15198b.r, mFEDebugInfo);
            this.f15198b.m.addSubDebugInfo(mFEDebugInfo);
            if (this.f15198b.s != null) {
                MFEDebugInfo mFEDebugInfo2 = new MFEDebugInfo("Face Tracker Load Resources");
                this.f15198b.j.h(this.f15198b.s, this.f15198b.t, mFEDebugInfo2);
                this.f15198b.m.addSubDebugInfo(mFEDebugInfo2);
            }
            j.a aVar = this.f15197a;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
