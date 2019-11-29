package com.modiface.mfemakeupkit.b;

import com.modiface.mfemakeupkit.b.m;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.u;
import com.modiface.mfemakeupkit.utils.y;
import java.util.ArrayList;

class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f15250a;

    k(m mVar) {
        this.f15250a = mVar;
    }

    public void run() {
        u uVar = (u) this.f15250a.v.getAndSet((Object) null);
        if (uVar != null) {
            y yVar = new y();
            MFETrackingData mFETrackingData = uVar.f15398a;
            MFEDebugInfo mFEDebugInfo = new MFEDebugInfo("Rendering Tracking Data");
            this.f15250a.s.copyFacePointsFrom(mFETrackingData);
            this.f15250a.o.e(mFETrackingData, mFEDebugInfo);
            if (!this.f15250a.l.get()) {
                ArrayList arrayList = new ArrayList();
                boolean a2 = this.f15250a.a(mFETrackingData, mFEDebugInfo, arrayList);
                mFEDebugInfo.addSimpleDebugInfo("total update tracking data time (ms)", yVar.d());
                if (a2) {
                    this.f15250a.b((ArrayList<Throwable>) arrayList);
                } else {
                    m.c cVar = (m.c) this.f15250a.j.get();
                    if (cVar != null) {
                        cVar.onMakeupApplied(false, arrayList, this.f15250a.q, this.f15250a.p, this.f15250a.s, this.f15250a.t);
                    }
                }
            }
            this.f15250a.x.addSubDebugInfo(mFEDebugInfo);
            m.d dVar = (m.d) this.f15250a.k.get();
            if (dVar != null) {
                dVar.onFinishedWithTrackingData(uVar);
            }
        }
    }
}
