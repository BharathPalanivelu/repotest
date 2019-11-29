package com.google.android.exoplayer2.r;

import android.net.Uri;
import com.google.android.exoplayer2.r.r;
import com.google.android.exoplayer2.s.v;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class t<T> implements r.c {

    /* renamed from: a  reason: collision with root package name */
    public final i f11379a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11380b;

    /* renamed from: c  reason: collision with root package name */
    private final f f11381c;

    /* renamed from: d  reason: collision with root package name */
    private final a<? extends T> f11382d;

    /* renamed from: e  reason: collision with root package name */
    private volatile T f11383e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f11384f;

    /* renamed from: g  reason: collision with root package name */
    private volatile long f11385g;

    public interface a<T> {
        T b(Uri uri, InputStream inputStream) throws IOException;
    }

    public t(f fVar, Uri uri, int i, a<? extends T> aVar) {
        this.f11381c = fVar;
        this.f11379a = new i(uri, 1);
        this.f11380b = i;
        this.f11382d = aVar;
    }

    public final T d() {
        return this.f11383e;
    }

    public long e() {
        return this.f11385g;
    }

    public final void a() {
        this.f11384f = true;
    }

    public final boolean b() {
        return this.f11384f;
    }

    public final void c() throws IOException, InterruptedException {
        h hVar = new h(this.f11381c, this.f11379a);
        try {
            hVar.b();
            this.f11383e = this.f11382d.b(this.f11381c.b(), hVar);
        } finally {
            this.f11385g = hVar.a();
            v.a((Closeable) hVar);
        }
    }
}
