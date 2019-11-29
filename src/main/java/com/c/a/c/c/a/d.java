package com.c.a.c.c.a;

import android.content.Context;
import android.net.Uri;
import com.c.a.c.a.a.b;
import com.c.a.c.a.a.c;
import com.c.a.c.c.n;
import com.c.a.c.c.o;
import com.c.a.c.d.a.r;
import com.c.a.c.j;
import java.io.InputStream;

public class d implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5902a;

    d(Context context) {
        this.f5902a = context.getApplicationContext();
    }

    public n.a<InputStream> a(Uri uri, int i, int i2, j jVar) {
        if (!b.a(i, i2) || !a(jVar)) {
            return null;
        }
        return new n.a<>(new com.c.a.h.b(uri), c.b(this.f5902a, uri));
    }

    private boolean a(j jVar) {
        Long l = (Long) jVar.a(r.f6047a);
        return l != null && l.longValue() == -1;
    }

    public boolean a(Uri uri) {
        return b.b(uri);
    }

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f5903a;

        public a(Context context) {
            this.f5903a = context;
        }

        public n<Uri, InputStream> a(com.c.a.c.c.r rVar) {
            return new d(this.f5903a);
        }
    }
}
