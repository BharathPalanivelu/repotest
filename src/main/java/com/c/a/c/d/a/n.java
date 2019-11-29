package com.c.a.c.d.a;

import android.graphics.Bitmap;
import android.net.Uri;
import com.c.a.c.b.a.e;
import com.c.a.c.b.s;
import com.c.a.c.d.c.d;
import com.c.a.c.j;
import com.c.a.c.k;
import com.facebook.common.util.UriUtil;
import java.io.IOException;

public class n implements k<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f6035a;

    /* renamed from: b  reason: collision with root package name */
    private final e f6036b;

    public n(d dVar, e eVar) {
        this.f6035a = dVar;
        this.f6036b = eVar;
    }

    public boolean a(Uri uri, j jVar) throws IOException {
        return UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme());
    }

    public s<Bitmap> a(Uri uri, int i, int i2, j jVar) throws IOException {
        return i.a(this.f6036b, this.f6035a.a(uri, i, i2, jVar).c(), i, i2);
    }
}
