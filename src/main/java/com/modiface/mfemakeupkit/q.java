package com.modiface.mfemakeupkit;

import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.a.j;
import com.modiface.mfemakeupkit.utils.n;

class q implements j.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.d f15331a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15332b;

    q(MFEMakeupEngine mFEMakeupEngine, MFEMakeupEngine.d dVar) {
        this.f15332b = mFEMakeupEngine;
        this.f15331a = dVar;
    }

    public void a() {
        if (this.f15331a != null) {
            n.a((Runnable) new p(this));
        }
    }
}
