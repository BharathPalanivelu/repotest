package com.tencent.liteav.beauty.a.a;

import android.view.Surface;

public class c extends b {

    /* renamed from: b  reason: collision with root package name */
    private Surface f31450b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31451c;

    public c(a aVar, int i, int i2, boolean z) {
        super(aVar);
        a(i, i2);
        this.f31451c = z;
    }

    public void c() {
        a();
        Surface surface = this.f31450b;
        if (surface != null) {
            if (this.f31451c) {
                surface.release();
            }
            this.f31450b = null;
        }
    }
}
