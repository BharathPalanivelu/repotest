package com.c.a.c.c.a;

import android.net.Uri;
import com.c.a.c.c.g;
import com.c.a.c.c.n;
import com.c.a.c.c.o;
import com.c.a.c.c.r;
import com.c.a.c.j;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class b implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f5897a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: b  reason: collision with root package name */
    private final n<g, InputStream> f5898b;

    public b(n<g, InputStream> nVar) {
        this.f5898b = nVar;
    }

    public n.a<InputStream> a(Uri uri, int i, int i2, j jVar) {
        return this.f5898b.a(new g(uri.toString()), i, i2, jVar);
    }

    public boolean a(Uri uri) {
        return f5897a.contains(uri.getScheme());
    }

    public static class a implements o<Uri, InputStream> {
        public n<Uri, InputStream> a(r rVar) {
            return new b(rVar.a(g.class, InputStream.class));
        }
    }
}
