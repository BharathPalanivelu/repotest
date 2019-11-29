package com.modiface.mfemakeupkit.b;

import com.modiface.mfemakeupkit.b.m;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.u;

class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f15251a;

    l(m mVar) {
        this.f15251a = mVar;
    }

    public void run() {
        u uVar = (u) this.f15251a.v.getAndSet((Object) null);
        if (uVar != null) {
            MFETrackingData mFETrackingData = uVar.f15398a;
            MFEDebugInfo mFEDebugInfo = new MFEDebugInfo("Rendering Tracking Data");
            this.f15251a.s.copyFacePointsFrom(mFETrackingData);
            this.f15251a.o.e(mFETrackingData, mFEDebugInfo);
            m.d dVar = (m.d) this.f15251a.k.get();
            if (dVar != null) {
                dVar.onFinishedWithTrackingData(uVar);
            }
        }
    }
}
