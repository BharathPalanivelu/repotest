package com.squareup.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.a.w;

final class ag extends a<af> {
    ag(w wVar, af afVar, z zVar, int i, int i2, Drawable drawable, String str, Object obj, int i3) {
        super(wVar, afVar, zVar, i, i2, i3, drawable, str, obj, false);
    }

    /* access modifiers changed from: package-private */
    public void a(Bitmap bitmap, w.d dVar) {
        if (bitmap != null) {
            af afVar = (af) d();
            if (afVar != null) {
                afVar.a(bitmap, dVar);
                if (bitmap.isRecycled()) {
                    throw new IllegalStateException("Target callback must not recycle bitmap!");
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    /* access modifiers changed from: package-private */
    public void a() {
        af afVar = (af) d();
        if (afVar == null) {
            return;
        }
        if (this.f30495g != 0) {
            afVar.b(this.f30489a.f7155c.getResources().getDrawable(this.f30495g));
        } else {
            afVar.b(this.h);
        }
    }
}
