package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.r.b;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.source.c.b.b;
import com.google.android.exoplayer2.source.c.b.e;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.n;
import java.io.IOException;
import java.util.List;

public final class h implements e.C0188e, i {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f11702a;

    /* renamed from: b  reason: collision with root package name */
    private final d f11703b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11704c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0185a f11705d;

    /* renamed from: e  reason: collision with root package name */
    private e f11706e;

    /* renamed from: f  reason: collision with root package name */
    private i.a f11707f;

    static {
        k.a("goog.exo.hls");
    }

    public h(Uri uri, f.a aVar, Handler handler, a aVar2) {
        this(uri, aVar, 3, handler, aVar2);
    }

    public h(Uri uri, f.a aVar, int i, Handler handler, a aVar2) {
        this(uri, (d) new b(aVar), i, handler, aVar2);
    }

    public h(Uri uri, d dVar, int i, Handler handler, a aVar) {
        this.f11702a = uri;
        this.f11703b = dVar;
        this.f11704c = i;
        this.f11705d = new a.C0185a(handler, aVar);
    }

    public void a(com.google.android.exoplayer2.f fVar, boolean z, i.a aVar) {
        com.google.android.exoplayer2.s.a.b(this.f11706e == null);
        this.f11706e = new e(this.f11702a, this.f11703b, this.f11705d, this.f11704c, this);
        this.f11707f = aVar;
        this.f11706e.a();
    }

    public void a() throws IOException {
        this.f11706e.d();
    }

    public com.google.android.exoplayer2.source.h a(i.b bVar, b bVar2) {
        com.google.android.exoplayer2.s.a.a(bVar.f12083b == 0);
        return new g(this.f11706e, this.f11703b, this.f11704c, this.f11705d, bVar2);
    }

    public void a(com.google.android.exoplayer2.source.h hVar) {
        ((g) hVar).f();
    }

    public void b() {
        e eVar = this.f11706e;
        if (eVar != null) {
            eVar.c();
            this.f11706e = null;
        }
        this.f11707f = null;
    }

    public void a(com.google.android.exoplayer2.source.c.b.b bVar) {
        n nVar;
        long j;
        long j2;
        com.google.android.exoplayer2.source.c.b.b bVar2 = bVar;
        long j3 = bVar2.k ? 0 : -9223372036854775807L;
        long a2 = bVar2.k ? com.google.android.exoplayer2.b.a(bVar2.f11646c) : -9223372036854775807L;
        long j4 = bVar2.f11645b;
        if (this.f11706e.e()) {
            long j5 = bVar2.j ? bVar2.n + bVar2.f11646c : -9223372036854775807L;
            List<b.a> list = bVar2.m;
            if (j4 == -9223372036854775807L) {
                if (list.isEmpty()) {
                    j2 = 0;
                } else {
                    j2 = list.get(Math.max(0, list.size() - 3)).f11654d;
                }
                j = j2;
            } else {
                j = j4;
            }
            nVar = new n(j3, a2, j5, bVar2.n, bVar2.f11646c, j, true, !bVar2.j);
        } else {
            nVar = new n(j3, a2, bVar2.f11646c + bVar2.n, bVar2.n, bVar2.f11646c, j4 == -9223372036854775807L ? 0 : j4, true, false);
        }
        this.f11707f.a(nVar, new e(this.f11706e.b(), bVar2));
    }
}
