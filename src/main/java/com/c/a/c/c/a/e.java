package com.c.a.c.c.a;

import com.c.a.c.c.g;
import com.c.a.c.c.n;
import com.c.a.c.c.o;
import com.c.a.c.c.r;
import com.c.a.c.j;
import java.io.InputStream;
import java.net.URL;

public class e implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f5904a;

    public boolean a(URL url) {
        return true;
    }

    public e(n<g, InputStream> nVar) {
        this.f5904a = nVar;
    }

    public n.a<InputStream> a(URL url, int i, int i2, j jVar) {
        return this.f5904a.a(new g(url), i, i2, jVar);
    }

    public static class a implements o<URL, InputStream> {
        public n<URL, InputStream> a(r rVar) {
            return new e(rVar.a(g.class, InputStream.class));
        }
    }
}
