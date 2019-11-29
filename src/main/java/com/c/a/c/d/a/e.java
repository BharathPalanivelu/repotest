package com.c.a.c.d.a;

import android.graphics.Bitmap;
import com.c.a.c.b.s;
import com.c.a.c.j;
import com.c.a.c.k;
import com.c.a.i.a;
import java.io.IOException;
import java.nio.ByteBuffer;

public class e implements k<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final h f5999a;

    public e(h hVar) {
        this.f5999a = hVar;
    }

    public boolean a(ByteBuffer byteBuffer, j jVar) throws IOException {
        return this.f5999a.a(byteBuffer);
    }

    public s<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, j jVar) throws IOException {
        return this.f5999a.a(a.b(byteBuffer), i, i2, jVar);
    }
}
