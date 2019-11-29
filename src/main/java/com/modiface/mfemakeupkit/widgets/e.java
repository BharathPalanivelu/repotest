package com.modiface.mfemakeupkit.widgets;

import android.graphics.RectF;
import com.modiface.mfemakeupkit.aa;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.effects.MFEMakeupProductCategory;
import com.modiface.mfemakeupkit.utils.MFEImage;
import com.modiface.mfemakeupkit.utils.n;

class e extends aa {
    final /* synthetic */ MFEMakeupView k;

    e(MFEMakeupView mFEMakeupView) {
        this.k = mFEMakeupView;
    }

    /* access modifiers changed from: protected */
    public float[] a(int i, int i2, int i3, int i4, MFETrackingData mFETrackingData, MFEMakeupProductCategory mFEMakeupProductCategory) {
        if (mFETrackingData == null) {
            mFETrackingData = new MFETrackingData((MFEImage) null, 0);
        }
        MFEMakeupZoomArea mFEMakeupZoomArea = (MFEMakeupZoomArea) this.k.mZoomAreaRef.get();
        if (mFEMakeupZoomArea == null) {
            mFEMakeupZoomArea = MFEMakeupZoomArea.None;
        }
        MFEMakeupZoomArea mFEMakeupZoomArea2 = mFEMakeupZoomArea;
        RectF rectF = new RectF();
        this.k.jniCalculateZoomArea(mFEMakeupZoomArea2, i, i2, mFETrackingData, rectF);
        RectF rectF2 = new RectF(n.a(rectF.width(), rectF.height(), (float) i3, (float) i4));
        rectF2.offset(rectF.left, rectF.top);
        if (rectF2.isEmpty()) {
            return super.a(i, i2, i3, i4, mFETrackingData, mFEMakeupProductCategory);
        }
        return n.a(rectF2, i, i2);
    }
}
