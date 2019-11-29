package com.modiface.mfemakeupkit.mfea;

import android.content.res.AssetManager;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.data.MFEMakeupRenderingParameters;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.utils.q;

public class c {
    private long k = 0;

    static {
        q.a("MFEMakeupKit");
        registerNatives();
    }

    private native long a(String str, MFEMakeupEngine.Region region, String str2, AssetManager assetManager);

    private native void b();

    private long getNativeState() {
        return this.k;
    }

    private static native void registerNatives();

    public native void c();

    public native void d(String str);

    public native void e(MFETrackingData mFETrackingData, MFEDebugInfo mFEDebugInfo);

    public native boolean f(MFEGLFramebuffer mFEGLFramebuffer, MFEGLFramebuffer mFEGLFramebuffer2, MFEGLFramebuffer mFEGLFramebuffer3, MFETrackingData mFETrackingData, MFEMakeupRenderingParameters mFEMakeupRenderingParameters, MFEDebugInfo mFEDebugInfo, long j);

    public native boolean g(MFEGLFramebuffer mFEGLFramebuffer);

    public void h(String str, MFEMakeupEngine.Region region, String str2, AssetManager assetManager) {
        this.k = a(str, region, str2, assetManager);
    }

    public void i() {
        if (this.k != 0) {
            b();
            this.k = 0;
        }
    }

    public boolean j() {
        return this.k != 0;
    }
}
