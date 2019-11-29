package com.c.a.c.d.f;

import android.graphics.Bitmap;
import com.c.a.c.b.s;
import com.c.a.c.d.b.b;
import com.c.a.c.j;
import java.io.ByteArrayOutputStream;

public class a implements d<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.CompressFormat f6098a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6099b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(Bitmap.CompressFormat compressFormat, int i) {
        this.f6098a = compressFormat;
        this.f6099b = i;
    }

    public s<byte[]> a(s<Bitmap> sVar, j jVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        sVar.c().compress(this.f6098a, this.f6099b, byteArrayOutputStream);
        sVar.e();
        return new b(byteArrayOutputStream.toByteArray());
    }
}
