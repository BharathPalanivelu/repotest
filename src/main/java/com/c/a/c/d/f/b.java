package com.c.a.c.d.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.c.a.c.b.a.e;
import com.c.a.c.b.s;
import com.c.a.c.d.a.l;
import com.c.a.c.j;
import com.c.a.i.h;

public class b implements d<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f6100a;

    /* renamed from: b  reason: collision with root package name */
    private final e f6101b;

    public b(Resources resources, e eVar) {
        this.f6100a = (Resources) h.a(resources);
        this.f6101b = (e) h.a(eVar);
    }

    public s<BitmapDrawable> a(s<Bitmap> sVar, j jVar) {
        return l.a(this.f6100a, this.f6101b, sVar.c());
    }
}
