package com.modiface.mfemakeupkit;

import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.a.j;
import com.modiface.mfemakeupkit.utils.n;

class s implements j.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.c f15334a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15335b;

    s(MFEMakeupEngine mFEMakeupEngine, MFEMakeupEngine.c cVar) {
        this.f15335b = mFEMakeupEngine;
        this.f15334a = cVar;
    }

    public void a() {
        if (this.f15334a != null) {
            n.a((Runnable) new C0534r(this));
        }
    }
}
