package com.modiface.mfemakeupkit.utils;

import android.opengl.EGLContext;

public class s extends m {
    private static final String m = "MFEMakeupGLThread";
    private static final r n = new r();

    public s(String str) {
        this(str, false);
    }

    /* access modifiers changed from: protected */
    public void a(EGLContext eGLContext) {
        if (eGLContext == null) {
            super.a(n.a(this));
            return;
        }
        throw new IllegalArgumentException("cannot create GL context with a user specified share context in MFEMakeupGLThread");
    }

    /* access modifiers changed from: protected */
    public void c() {
        super.c();
        n.b(this);
    }

    public s(String str, boolean z) {
        super(str, (EGLContext) null, z);
    }
}
