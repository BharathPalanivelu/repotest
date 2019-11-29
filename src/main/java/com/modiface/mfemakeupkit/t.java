package com.modiface.mfemakeupkit;

import android.opengl.GLES20;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.utils.MFEImage;
import com.modiface.mfemakeupkit.utils.u;
import java.util.Iterator;

class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f15336a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15337b;

    t(MFEMakeupEngine mFEMakeupEngine, u uVar) {
        this.f15337b = mFEMakeupEngine;
        this.f15336a = uVar;
    }

    public void run() {
        u uVar = this.f15336a;
        if (uVar != null) {
            MFETrackingData mFETrackingData = uVar.f15398a;
            if (!(mFETrackingData == null || mFETrackingData.getImage() == null || this.f15336a.f15398a.getImage().textureId == 0)) {
                GLES20.glDeleteTextures(1, new int[]{this.f15336a.f15398a.getImage().textureId}, 0);
                this.f15336a.f15398a.getImage().textureId = 0;
            }
        }
        Iterator it = this.f15337b.mLiveImageCache.iterator();
        while (it.hasNext()) {
            MFEImage mFEImage = (MFEImage) it.next();
            if (mFEImage != null) {
                int i = mFEImage.textureId;
                if (i != 0) {
                    GLES20.glDeleteTextures(1, new int[]{i}, 0);
                    mFEImage.textureId = 0;
                    mFEImage.textureWidth = 0;
                    mFEImage.textureHeight = 0;
                }
            }
        }
        if (this.f15337b.mVideoRecorder != null) {
            this.f15337b.mVideoRecorder.c().b();
            this.f15337b.mVideoRecorder.d();
            this.f15337b.mVideoRecorder.c().a();
        }
    }
}
