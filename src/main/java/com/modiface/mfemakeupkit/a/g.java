package com.modiface.mfemakeupkit.a;

import com.modiface.mfemakeupkit.a.j;
import com.modiface.mfemakeupkit.data.MFEFaceTrackingParameters;
import com.modiface.mfemakeupkit.utils.u;

class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f15204a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEFaceTrackingParameters f15205b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j.d f15206c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ j f15207d;

    g(j jVar, u uVar, MFEFaceTrackingParameters mFEFaceTrackingParameters, j.d dVar) {
        this.f15207d = jVar;
        this.f15204a = uVar;
        this.f15205b = mFEFaceTrackingParameters;
        this.f15206c = dVar;
    }

    public void run() {
        this.f15207d.a(this.f15204a, this.f15205b, true, this.f15206c);
    }
}
