package com.modiface.mfemakeupkit;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.modiface.mfemakeupkit.b.m;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.effects.MFEMakeupProductCategory;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.widgets.MFEMakeupView;
import java.lang.ref.WeakReference;
import java.util.Iterator;

class k implements m.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f15321a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15322b;

    k(MFEMakeupEngine mFEMakeupEngine, aa aaVar) {
        this.f15322b = mFEMakeupEngine;
        this.f15321a = aaVar;
    }

    public void a(MFEGLFramebuffer mFEGLFramebuffer, MFEGLFramebuffer mFEGLFramebuffer2, MFETrackingData mFETrackingData, MFEMakeupProductCategory mFEMakeupProductCategory) {
        this.f15321a.a(mFEGLFramebuffer, mFEGLFramebuffer2, (Long) null, mFETrackingData, mFEMakeupProductCategory);
        Iterator it = this.f15322b.mMakeupViewRefs.iterator();
        int i = 1;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null) {
                MFEMakeupView mFEMakeupView = (MFEMakeupView) weakReference.get();
                if (mFEMakeupView == null || mFEMakeupView.getMakeupSurface() != this.f15321a) {
                    i++;
                } else {
                    MFEDebugInfo debugInfo = mFEMakeupView.getDebugInfo();
                    MFEDebugInfo access$600 = this.f15322b.mDebugInfo;
                    access$600.addSubDebugInfo(debugInfo.getNewCopy(debugInfo.name + SQLBuilder.BLANK + i));
                    return;
                }
            }
        }
    }
}
