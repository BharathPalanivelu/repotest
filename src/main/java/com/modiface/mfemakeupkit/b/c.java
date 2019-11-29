package com.modiface.mfemakeupkit.b;

import com.modiface.mfemakeupkit.b.m;

class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m.e f15237a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f15238b;

    c(m mVar, m.e eVar) {
        this.f15238b = mVar;
        this.f15237a = eVar;
    }

    public void run() {
        m.e eVar = this.f15237a;
        if (eVar != null) {
            eVar.a(this.f15238b.q, this.f15238b.p, this.f15238b.s, this.f15238b.t);
        }
    }
}
