package com.c.a.c.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.c.a.c.b.a.e;
import com.c.a.c.b.s;
import com.c.a.c.c;
import com.c.a.c.j;
import com.c.a.c.l;
import java.io.File;

public class b implements l<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final e f5993a;

    /* renamed from: b  reason: collision with root package name */
    private final l<Bitmap> f5994b;

    public b(e eVar, l<Bitmap> lVar) {
        this.f5993a = eVar;
        this.f5994b = lVar;
    }

    public boolean a(s<BitmapDrawable> sVar, File file, j jVar) {
        return this.f5994b.a(new d(sVar.c().getBitmap(), this.f5993a), file, jVar);
    }

    public c a(j jVar) {
        return this.f5994b.a(jVar);
    }
}
