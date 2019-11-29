package com.squareup.a;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.a.w;

class n extends a<ImageView> {
    e m;

    n(w wVar, ImageView imageView, z zVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, e eVar, boolean z) {
        super(wVar, imageView, zVar, i, i2, i3, drawable, str, obj, z);
        this.m = eVar;
    }

    public void a(Bitmap bitmap, w.d dVar) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.f30491c.get();
            if (imageView != null) {
                Bitmap bitmap2 = bitmap;
                w.d dVar2 = dVar;
                x.a(imageView, this.f30489a.f7155c, bitmap2, dVar2, this.f30492d, this.f30489a.k);
                e eVar = this.m;
                if (eVar != null) {
                    eVar.c();
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    public void a() {
        ImageView imageView = (ImageView) this.f30491c.get();
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).stop();
            }
            if (this.f30495g != 0) {
                imageView.setImageResource(this.f30495g);
            } else if (this.h != null) {
                imageView.setImageDrawable(this.h);
            }
            e eVar = this.m;
            if (eVar != null) {
                eVar.d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        super.b();
        if (this.m != null) {
            this.m = null;
        }
    }
}
