package com.c.a.c.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.c.a.c;
import com.c.a.c.b.a.e;
import com.c.a.c.b.p;
import com.c.a.c.b.s;
import com.c.a.i.h;
import com.c.a.i.i;

public class l implements p, s<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f6026a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f6027b;

    /* renamed from: c  reason: collision with root package name */
    private final e f6028c;

    public static l a(Context context, Bitmap bitmap) {
        return a(context.getResources(), c.a(context).a(), bitmap);
    }

    public static l a(Resources resources, e eVar, Bitmap bitmap) {
        return new l(resources, eVar, bitmap);
    }

    l(Resources resources, e eVar, Bitmap bitmap) {
        this.f6027b = (Resources) h.a(resources);
        this.f6028c = (e) h.a(eVar);
        this.f6026a = (Bitmap) h.a(bitmap);
    }

    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    /* renamed from: f */
    public BitmapDrawable c() {
        return new BitmapDrawable(this.f6027b, this.f6026a);
    }

    public int d() {
        return i.a(this.f6026a);
    }

    public void e() {
        this.f6028c.a(this.f6026a);
    }

    public void a() {
        this.f6026a.prepareToDraw();
    }
}
