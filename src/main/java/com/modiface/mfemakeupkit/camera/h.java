package com.modiface.mfemakeupkit.camera;

import com.modiface.mfemakeupkit.a.j;
import com.modiface.mfemakeupkit.camera.i;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.utils.MFEImage;
import com.modiface.mfemakeupkit.utils.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class h implements j.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f15282a;

    h(i iVar) {
        this.f15282a = iVar;
    }

    public void a(u uVar) {
        if (uVar != null && uVar.f15398a != null) {
            Object obj = uVar.f15399b;
            if (obj != null) {
                for (Map.Entry entry : ((HashMap) obj).entrySet()) {
                    if (entry != null) {
                        WeakReference weakReference = (WeakReference) entry.getKey();
                        MFEImage mFEImage = (MFEImage) entry.getValue();
                        if (!(weakReference == null || mFEImage == null)) {
                            i.b bVar = (i.b) weakReference.get();
                            if (bVar != null) {
                                MFETrackingData mFETrackingData = new MFETrackingData(mFEImage, uVar.f15398a.getFrameID());
                                mFETrackingData.copyFacePointsFrom(uVar.f15398a);
                                bVar.onFaceTrackedOnCameraFrame(mFETrackingData);
                            }
                        }
                    }
                }
            }
        }
    }
}
