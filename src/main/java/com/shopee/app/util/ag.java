package com.shopee.app.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.garena.android.appkit.tools.b;
import com.garena.android.uikit.image.c.a;
import com.squareup.a.af;
import com.squareup.a.w;
import d.d.b.j;
import java.lang.ref.WeakReference;

public final class ag implements af {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<a> f26138a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26139b;

    public void a(Drawable drawable) {
    }

    public void b(Drawable drawable) {
    }

    public ag(a aVar, String str) {
        j.b(aVar, "image");
        j.b(str, "path");
        this.f26139b = str;
        this.f26138a = new WeakReference<>(aVar);
    }

    public void a(Bitmap bitmap, w.d dVar) {
        j.b(bitmap, "bitmap");
        j.b(dVar, "from");
        a aVar = (a) this.f26138a.get();
        if (aVar != null) {
            boolean z = true;
            boolean z2 = ((float) bitmap.getHeight()) > ((float) bitmap.getWidth()) * 3.5f;
            if (((float) bitmap.getWidth()) <= ((float) bitmap.getHeight()) * 3.5f) {
                z = false;
            }
            if (z2) {
                int b2 = b.b();
                j.a((Object) aVar, "it");
                Context context = aVar.getContext();
                j.a((Object) context, "it.context");
                aa.a(context, aVar, this.f26139b, new ah(aVar), b2, 0);
                w.a(aVar.getContext()).a((af) this);
            } else if (z) {
                int d2 = b.d() / 2;
                j.a((Object) aVar, "it");
                Context context2 = aVar.getContext();
                j.a((Object) context2, "it.context");
                aa.a(context2, aVar, this.f26139b, new ah(aVar), 0, d2);
                w.a(aVar.getContext()).a((af) this);
            } else {
                aVar.setImageBitmap(bitmap);
            }
        }
    }
}
