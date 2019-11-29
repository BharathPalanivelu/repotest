package com.modiface.mfemakeupkit.b;

import android.opengl.GLES20;
import com.modiface.mfemakeupkit.b.m;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.utils.MFEGLUtil;
import com.modiface.mfemakeupkit.utils.u;
import java.util.ArrayList;

class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f15244a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f15245b;

    f(m mVar, Runnable runnable) {
        this.f15245b = mVar;
        this.f15244a = runnable;
    }

    public void run() {
        Runnable runnable = this.f15244a;
        if (runnable != null) {
            runnable.run();
        }
        ArrayList arrayList = new ArrayList();
        u uVar = (u) this.f15245b.v.get();
        if (uVar != null) {
            MFETrackingData mFETrackingData = uVar.f15398a;
            if (!(mFETrackingData == null || mFETrackingData.getImage() == null || uVar.f15398a.getImage().textureId == 0)) {
                GLES20.glDeleteTextures(1, new int[]{uVar.f15398a.getImage().textureId}, 0);
                Throwable gLError = MFEGLUtil.getGLError();
                if (gLError != null) {
                    arrayList.add(new Throwable("gl error when deleting texture of tracking data", gLError));
                }
                uVar.f15398a.getImage().textureId = 0;
            }
        }
        if (this.f15245b.p != null) {
            this.f15245b.p.close();
            arrayList.addAll(this.f15245b.p.getAndClearErrors());
            MFEGLFramebuffer unused = this.f15245b.p = null;
        }
        if (this.f15245b.q != null) {
            this.f15245b.q.close();
            arrayList.addAll(this.f15245b.q.getAndClearErrors());
            MFEGLFramebuffer unused2 = this.f15245b.q = null;
        }
        if (this.f15245b.r != null) {
            this.f15245b.r.close();
            arrayList.addAll(this.f15245b.r.getAndClearErrors());
            MFEGLFramebuffer unused3 = this.f15245b.r = null;
        }
        if (this.f15245b.o.j()) {
            this.f15245b.o.c();
        }
        if (!arrayList.isEmpty()) {
            m.d dVar = (m.d) this.f15245b.k.get();
            if (dVar != null) {
                dVar.onRenderingEngineErrors(arrayList);
            }
        }
    }
}
