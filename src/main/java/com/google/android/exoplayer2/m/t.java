package com.google.android.exoplayer2.m;

import android.net.Uri;
import com.google.android.exoplayer2.m.r;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class t<T> implements r.c {

    /* renamed from: a  reason: collision with root package name */
    public final i f10827a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10828b;

    /* renamed from: c  reason: collision with root package name */
    private final f f10829c;

    /* renamed from: d  reason: collision with root package name */
    private final a<? extends T> f10830d;

    /* renamed from: e  reason: collision with root package name */
    private volatile T f10831e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f10832f;

    /* renamed from: g  reason: collision with root package name */
    private volatile long f10833g;

    public interface a<T> {
        T a(Uri uri, InputStream inputStream) throws IOException;
    }

    public t(f fVar, Uri uri, int i, a<? extends T> aVar) {
        this.f10829c = fVar;
        this.f10827a = new i(uri, 1);
        this.f10828b = i;
        this.f10830d = aVar;
    }

    public final T d() {
        return this.f10831e;
    }

    public long e() {
        return this.f10833g;
    }

    public final void a() {
        this.f10832f = true;
    }

    public final boolean b() {
        return this.f10832f;
    }

    public final void c() throws IOException, InterruptedException {
        h hVar = new h(this.f10829c, this.f10827a);
        try {
            hVar.b();
            this.f10831e = this.f10830d.a(this.f10829c.a(), hVar);
        } finally {
            this.f10833g = hVar.a();
            com.google.android.exoplayer2.n.t.a((Closeable) hVar);
        }
    }
}
