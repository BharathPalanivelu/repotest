package com.c.a.c.c.a;

import android.content.Context;
import android.net.Uri;
import com.c.a.c.a.a.b;
import com.c.a.c.c.n;
import com.c.a.c.c.o;
import com.c.a.c.c.r;
import com.c.a.c.j;
import java.io.InputStream;

public class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5900a;

    public c(Context context) {
        this.f5900a = context.getApplicationContext();
    }

    public n.a<InputStream> a(Uri uri, int i, int i2, j jVar) {
        if (b.a(i, i2)) {
            return new n.a<>(new com.c.a.h.b(uri), com.c.a.c.a.a.c.a(this.f5900a, uri));
        }
        return null;
    }

    public boolean a(Uri uri) {
        return b.c(uri);
    }

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f5901a;

        public a(Context context) {
            this.f5901a = context;
        }

        public n<Uri, InputStream> a(r rVar) {
            return new c(this.f5901a);
        }
    }
}
