package com.c.a.c.d.a;

import android.graphics.Bitmap;
import com.c.a.c.b.a.e;
import com.c.a.c.b.p;
import com.c.a.c.b.s;
import com.c.a.i.h;
import com.c.a.i.i;

public class d implements p, s<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f5997a;

    /* renamed from: b  reason: collision with root package name */
    private final e f5998b;

    public static d a(Bitmap bitmap, e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, eVar);
    }

    public d(Bitmap bitmap, e eVar) {
        this.f5997a = (Bitmap) h.a(bitmap, "Bitmap must not be null");
        this.f5998b = (e) h.a(eVar, "BitmapPool must not be null");
    }

    public Class<Bitmap> b() {
        return Bitmap.class;
    }

    /* renamed from: f */
    public Bitmap c() {
        return this.f5997a;
    }

    public int d() {
        return i.a(this.f5997a);
    }

    public void e() {
        this.f5998b.a(this.f5997a);
    }

    public void a() {
        this.f5997a.prepareToDraw();
    }
}
