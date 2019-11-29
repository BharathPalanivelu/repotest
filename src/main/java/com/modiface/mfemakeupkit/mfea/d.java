package com.modiface.mfemakeupkit.mfea;

import android.graphics.Bitmap;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.utils.q;

public class d {
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

    public native void c(int i, float[] fArr, float[] fArr2, MFEGLFramebuffer mFEGLFramebuffer, long j);

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

    public native void g(Bitmap bitmap, Bitmap bitmap2, int i);
}
