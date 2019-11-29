package com.modiface.mfemakeupkit.mfea;

import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.data.MFEFaceTrackingParameters;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.q;

public class b {
    private long k = 0;

    static {
        q.a("MFEMakeupKit");
        registerNatives();
    }

    private native long a(String str, MFEMakeupEngine.Region region, MFEDebugInfo mFEDebugInfo);

    private native void b();

    private long getNativeState() {
        return this.k;
    }

    private static native void registerNatives();

    public native boolean c(MFETrackingData mFETrackingData, MFEFaceTrackingParameters mFEFaceTrackingParameters, MFEDebugInfo mFEDebugInfo);

    public native void d();

    public void e(String str, MFEMakeupEngine.Region region, MFEDebugInfo mFEDebugInfo) {
        this.k = a(str, region, mFEDebugInfo);
    }

    public void f() {
        if (this.k != 0) {
            b();
            this.k = 0;
        }
    }

    public boolean g() {
        return this.k != 0;
    }

    public native void h(String str, boolean z, MFEDebugInfo mFEDebugInfo);
}
