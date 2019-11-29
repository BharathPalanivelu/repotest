package com.c.a.c.c;

import android.net.Uri;
import com.c.a.c.c.n;
import com.c.a.c.j;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class x<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f5987a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: b  reason: collision with root package name */
    private final n<g, Data> f5988b;

    public x(n<g, Data> nVar) {
        this.f5988b = nVar;
    }

    public n.a<Data> a(Uri uri, int i, int i2, j jVar) {
        return this.f5988b.a(new g(uri.toString()), i, i2, jVar);
    }

    public boolean a(Uri uri) {
        return f5987a.contains(uri.getScheme());
    }

    public static class a implements o<Uri, InputStream> {
        public n<Uri, InputStream> a(r rVar) {
            return new x(rVar.a(g.class, InputStream.class));
        }
    }
}
