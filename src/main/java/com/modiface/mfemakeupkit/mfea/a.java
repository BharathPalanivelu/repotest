package com.modiface.mfemakeupkit.mfea;

import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.q;

public class a {
    private long k = 0;

    static {
        q.a("MFEMakeupKit");
        registerNatives();
    }

    private native long a();

    private native void b();

    private long getNativeState() {
        return this.k;
    }

    private static native void registerNatives();

    public native void c(int i, float[] fArr, float[] fArr2, MFEDebugInfo mFEDebugInfo, long j);

    public void d() {
        this.k = a();
    }

    public void e() {
        if (this.k != 0) {
            b();
            this.k = 0;
        }
    }

    public boolean f() {
        return this.k != 0;
    }
}
