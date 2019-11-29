package com.c.a.c.c.a;

import com.c.a.c.a.h;
import com.c.a.c.c.g;
import com.c.a.c.c.m;
import com.c.a.c.c.n;
import com.c.a.c.c.o;
import com.c.a.c.c.r;
import com.c.a.c.i;
import com.c.a.c.j;
import java.io.InputStream;

public class a implements n<g, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public static final i<Integer> f5893a = i.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: b  reason: collision with root package name */
    private final m<g, g> f5894b;

    public boolean a(g gVar) {
        return true;
    }

    public a() {
        this((m<g, g>) null);
    }

    public a(m<g, g> mVar) {
        this.f5894b = mVar;
    }

    public n.a<InputStream> a(g gVar, int i, int i2, j jVar) {
        m<g, g> mVar = this.f5894b;
        if (mVar != null) {
            g a2 = mVar.a(gVar, 0, 0);
            if (a2 == null) {
                this.f5894b.a(gVar, 0, 0, gVar);
            } else {
                gVar = a2;
            }
        }
        return new n.a<>(gVar, new h(gVar, ((Integer) jVar.a(f5893a)).intValue()));
    }

    /* renamed from: com.c.a.c.c.a.a$a  reason: collision with other inner class name */
    public static class C0103a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final m<g, g> f5895a = new m<>(500);

        public n<g, InputStream> a(r rVar) {
            return new a(this.f5895a);
        }
    }
}
