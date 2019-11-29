package com.modiface.mfemakeupkit.a;

import com.modiface.mfemakeupkit.a.j;
import com.modiface.mfemakeupkit.data.MFEFaceTrackingParameters;
import com.modiface.mfemakeupkit.utils.u;
import java.util.concurrent.atomic.AtomicReference;

class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f15208a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEFaceTrackingParameters f15209b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j.d f15210c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ j f15211d;

    h(j jVar, Object obj, MFEFaceTrackingParameters mFEFaceTrackingParameters, j.d dVar) {
        this.f15211d = jVar;
        this.f15208a = obj;
        this.f15209b = mFEFaceTrackingParameters;
        this.f15210c = dVar;
    }

    public void run() {
        if (!this.f15211d.p.get()) {
            u uVar = (u) ((AtomicReference) this.f15211d.l.get(this.f15208a)).getAndSet((Object) null);
            if (uVar != null) {
                this.f15211d.a(uVar, this.f15209b, false, this.f15210c);
            }
        }
    }
}
