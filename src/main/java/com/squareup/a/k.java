package com.squareup.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.a.w;

class k extends a<Object> {
    private final Object m = new Object();
    private e n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k(w wVar, z zVar, int i, int i2, Object obj, String str, e eVar) {
        super(wVar, null, zVar, i, i2, 0, (Drawable) null, str, obj, false);
        this.n = eVar;
    }

    /* access modifiers changed from: package-private */
    public void a(Bitmap bitmap, w.d dVar) {
        e eVar = this.n;
        if (eVar != null) {
            eVar.c();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        e eVar = this.n;
        if (eVar != null) {
            eVar.d();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        super.b();
        this.n = null;
    }

    /* access modifiers changed from: package-private */
    public Object d() {
        return this.m;
    }
}
