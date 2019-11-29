package com.modiface.mfemakeupkit;

import android.opengl.GLES20;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.modiface.mfemakeupkit.aa;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.effects.MFEMakeupProductCategory;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.utils.MFEGLUtil;
import com.modiface.mfemakeupkit.utils.MFENativeError;
import com.modiface.mfemakeupkit.utils.y;
import com.tencent.imsdk.TIMGroupManager;
import java.util.Arrays;

class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEGLFramebuffer f15469a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEGLFramebuffer f15470b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MFETrackingData f15471c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ MFEMakeupProductCategory f15472d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Long f15473e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ aa f15474f;

    z(aa aaVar, MFEGLFramebuffer mFEGLFramebuffer, MFEGLFramebuffer mFEGLFramebuffer2, MFETrackingData mFETrackingData, MFEMakeupProductCategory mFEMakeupProductCategory, Long l) {
        this.f15474f = aaVar;
        this.f15469a = mFEGLFramebuffer;
        this.f15470b = mFEGLFramebuffer2;
        this.f15471c = mFETrackingData;
        this.f15472d = mFEMakeupProductCategory;
        this.f15473e = l;
    }

    public void run() {
        y yVar = new y();
        boolean z = this.f15474f.f15223d.get();
        MFEGLFramebuffer mFEGLFramebuffer = z ? this.f15469a : this.f15470b;
        MFEDebugInfo mFEDebugInfo = null;
        aa.a aVar = (aa.a) this.f15474f.i.get();
        if (aVar != null) {
            mFEDebugInfo = aVar.getDebugInfoToPopulateOn();
        }
        if (mFEDebugInfo == null) {
            mFEDebugInfo = new MFEDebugInfo("Surface");
        }
        mFEDebugInfo.addSimpleDebugInfo("render before", z);
        int i = this.f15474f.f15225f.get();
        int i2 = this.f15474f.f15226g.get();
        mFEDebugInfo.addDetailedDebugInfo("surface width", i);
        mFEDebugInfo.addDetailedDebugInfo("surface height", i2);
        if (i > 0 && i2 > 0) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(0, 0, i, i2);
            Throwable gLError = MFEGLUtil.getGLError();
            if (gLError != null) {
                this.f15474f.a(gLError);
                return;
            }
            GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
            GLES20.glClear(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
            Throwable gLError2 = MFEGLUtil.getGLError();
            if (gLError2 != null) {
                this.f15474f.a(gLError2);
                return;
            }
            if (mFEGLFramebuffer != null && mFEGLFramebuffer.isValid()) {
                int width = mFEGLFramebuffer.getWidth();
                int height = mFEGLFramebuffer.getHeight();
                int textureId = mFEGLFramebuffer.getTextureId();
                mFEDebugInfo.addDetailedDebugInfo("framebuffer width", width);
                mFEDebugInfo.addDetailedDebugInfo("framebuffer height", height);
                float[] a2 = this.f15474f.a(width, height, i, i2);
                float[] a3 = this.f15474f.a(width, height, i, i2, this.f15471c, this.f15472d);
                if (a2 != null && a2.length == 8 && a3 != null && a3.length == 8) {
                    mFEDebugInfo.addDetailedDebugInfo("vertices", Arrays.toString(a2));
                    mFEDebugInfo.addDetailedDebugInfo("texture coordinates", Arrays.toString(a3));
                    if (!this.f15474f.f15222c.f()) {
                        long d2 = yVar.d();
                        this.f15474f.f15222c.d();
                        mFEDebugInfo.addDetailedDebugInfo("native initialization", true);
                        mFEDebugInfo.addDetailedDebugInfo("native initialization time (ms)", yVar.d() - d2);
                    }
                    if (this.f15474f.f15222c.f()) {
                        long d3 = yVar.d();
                        MFENativeError mFENativeError = new MFENativeError();
                        this.f15474f.f15222c.c(textureId, a2, a3, mFEDebugInfo, mFENativeError.getNativeState());
                        Throwable nativeError = mFENativeError.getNativeError();
                        if (nativeError != null) {
                            this.f15474f.a(nativeError);
                            return;
                        }
                        mFEDebugInfo.addDetailedDebugInfo("native render surface time (ms)", yVar.d() - d3);
                    }
                }
            }
            long d4 = yVar.d();
            if (this.f15473e != null) {
                this.f15474f.h.a(this.f15473e.longValue());
                Throwable eGLError = MFEGLUtil.getEGLError();
                if (eGLError != null) {
                    this.f15474f.a(eGLError);
                    return;
                }
            }
            this.f15474f.h.e();
            Throwable eGLError2 = MFEGLUtil.getEGLError();
            if (eGLError2 != null) {
                this.f15474f.a(eGLError2);
                return;
            }
            mFEDebugInfo.addDetailedDebugInfo("native render surface to display time (ms)", yVar.d() - d4);
            mFEDebugInfo.addSimpleDebugInfo("total render surface time (ms)", yVar.d());
            if (aVar != null) {
                aVar.onRenderDone(mFEDebugInfo);
            }
        }
    }
}
