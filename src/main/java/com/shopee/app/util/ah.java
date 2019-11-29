package com.shopee.app.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.garena.android.uikit.image.c.a;
import com.squareup.a.af;
import com.squareup.a.w;
import d.d.b.j;
import java.lang.ref.WeakReference;

public final class ah implements af {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<a> f26140a;

    public void a(Drawable drawable) {
    }

    public void b(Drawable drawable) {
    }

    public ah(a aVar) {
        j.b(aVar, "image");
        this.f26140a = new WeakReference<>(aVar);
    }

    public void a(Bitmap bitmap, w.d dVar) {
        j.b(bitmap, "bitmap");
        j.b(dVar, "from");
        a aVar = (a) this.f26140a.get();
        if (aVar != null) {
            aVar.setImageBitmap(bitmap);
        }
    }
}
