package com.c.a.c.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.c.a.c.b.a.e;
import com.c.a.c.b.s;
import com.c.a.c.j;
import com.c.a.c.k;
import com.c.a.i.h;
import java.io.IOException;

public class a<DataType> implements k<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final k<DataType, Bitmap> f5990a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f5991b;

    /* renamed from: c  reason: collision with root package name */
    private final e f5992c;

    public a(Resources resources, e eVar, k<DataType, Bitmap> kVar) {
        this.f5991b = (Resources) h.a(resources);
        this.f5992c = (e) h.a(eVar);
        this.f5990a = (k) h.a(kVar);
    }

    public boolean a(DataType datatype, j jVar) throws IOException {
        return this.f5990a.a(datatype, jVar);
    }

    public s<BitmapDrawable> a(DataType datatype, int i, int i2, j jVar) throws IOException {
        s<Bitmap> a2 = this.f5990a.a(datatype, i, i2, jVar);
        if (a2 == null) {
            return null;
        }
        return l.a(this.f5991b, this.f5992c, a2.c());
    }
}
