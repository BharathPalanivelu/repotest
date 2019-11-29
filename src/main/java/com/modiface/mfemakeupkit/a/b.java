package com.modiface.mfemakeupkit.a;

import com.modiface.mfemakeupkit.a.j;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;

class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f15193a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f15194b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j.c f15195c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ j f15196d;

    b(j jVar, String str, boolean z, j.c cVar) {
        this.f15196d = jVar;
        this.f15193a = str;
        this.f15194b = z;
        this.f15195c = cVar;
    }

    public void run() {
        MFEDebugInfo mFEDebugInfo = new MFEDebugInfo("Face Tracker Load Resources");
        this.f15196d.j.h(this.f15193a, this.f15194b, mFEDebugInfo);
        String unused = this.f15196d.s = this.f15193a;
        boolean unused2 = this.f15196d.t = this.f15194b;
        this.f15196d.m.addSubDebugInfo(mFEDebugInfo);
        j.c cVar = this.f15195c;
        if (cVar != null) {
            cVar.a();
        }
    }
}
